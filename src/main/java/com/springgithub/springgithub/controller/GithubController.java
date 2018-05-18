package com.springgithub.springgithub.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springgithub.springgithub.data.GithubData;
import com.springgithub.springgithub.services.github.CustomGithubService;
import com.springgithub.springgithub.model.User;
import com.springgithub.springgithub.services.github.GithubDBUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class GithubController {

    private static final Gson gson = new GsonBuilder().create();

    @Autowired
    // Setter Injection instead of Constructor Injection
    private CustomGithubService gh;

    @Autowired
    private GithubDBUtility githubDBUtility;

    @RequestMapping(method = RequestMethod.GET, value = "/api/githubUser/{username}")
    public User getUser(@PathVariable String username) {
        if(githubDBUtility.getUserDB(username.toLowerCase()).getUser().getLogin() == null) {
            System.out.println("USER NOT IN THE CURRENT DATABASE.");
            githubDBUtility.insertData(username.toLowerCase());
        }

        return githubDBUtility.getUserDB(username.toLowerCase()).getUser();
//        return gh.getUser(username);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/getuserfortests/{username}")
    public @ResponseBody User getUserForTests(@PathVariable String username) {
        return gh.getUser(username);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/githubRepo/{username}")
    public @ResponseBody Object getRepository(@PathVariable String username) {
        return gh.getRepo(username);
    }

    // New Commits adapter - Uses EGit
    @RequestMapping(method = RequestMethod.GET, value = "/api/githubCommits/{username}")
    public @ResponseBody Map getCommitsAdaptorRe(@PathVariable String username){

        Map map;

        if(githubDBUtility.getUserDB(username.toLowerCase()).getUser().getLogin() != null){
            map = githubDBUtility.getUserDB(username.toLowerCase()).getCommits();
        } else {
            map = gh.getCommitsAdaptorRe(username);
        }

        return map;
    }

    // Uses RestTemplate to fetch from API
    @RequestMapping(method = RequestMethod.GET, value = "/api/githubStars/{username}")
    public @ResponseBody ArrayList<Object> getStarsPerLang(@PathVariable String username) { return gh.getStarsPerLang(username); }

    // Uses Egit adapter
    @RequestMapping(method = RequestMethod.GET, value = "/api/githubForks/{username}")
    public @ResponseBody ArrayList<Object> getForks(@PathVariable String username) {
        return gh.getForks(username);
    }

    // Uses Egit adapter
    @RequestMapping(method = RequestMethod.GET, value = "/api/githubWatchers/{username}")
    public @ResponseBody Integer getWatchers(@PathVariable String username) {
        return gh.getWatchers(username);
    }

    // Uses Egit adapter
    @RequestMapping(method = RequestMethod.GET, value = "/api/githubIssues/{username}")
    public @ResponseBody Integer getIssues(@PathVariable String username) {
        return gh.getIssues(username);
    }

    // Uses Egit adapter
    @RequestMapping(method = RequestMethod.GET, value = "/api/githubOrganizations/{username}")
    public @ResponseBody Integer getCommitsLastYear(@PathVariable String username) { return gh.getOrganizations(username);
    }

    // Test
    @RequestMapping(method = RequestMethod.GET, value = "/api/testgithub/{username}")
    public @ResponseBody void test(@PathVariable String username) { }


}
