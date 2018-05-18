package com.springgithub.springgithub.controller;

import com.google.code.stackexchange.schema.Reputation;
import com.springgithub.springgithub.services.stackoverflow.CustomStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StackController {

    @Autowired
    private CustomStackService so;

    // Uses an adapter
    // You can get user badges from here as well.
    @RequestMapping(method = RequestMethod.GET, value = "/api/stackuser/{id}")
    public @ResponseBody Object getUser(@PathVariable String id) {
        return so.getUser(id);
    }

    // Uses an adapter
    // This will give you a lesser amount of badges.
    @RequestMapping(method = RequestMethod.GET, value = "/api/stackuserbadges/{id}")
    public @ResponseBody Object getBadges(@PathVariable String id) {
        return so.getBadges(id);
    }

    // Uses an adapter
    @RequestMapping(method = RequestMethod.GET, value = "/api/stackuserquestionscount/{id}")
    public @ResponseBody Object getQuestions(@PathVariable String id) {
        return so.getQuestionsCount(id);
    }

    // Uses RestTemplate
    @RequestMapping(method = RequestMethod.GET, value = "/api/stackuseranswerscount/{id}")
    public @ResponseBody Object getAnswers(@PathVariable String id) { return so.getAnswersCount(id); }

    // Uses an adapter
    @RequestMapping(method = RequestMethod.GET, value = "/api/getstackusercomments/{id}")
    public @ResponseBody Object getComments(@PathVariable String id) { return so.getComments(id); }

    // Uses an adapter
    @RequestMapping(method = RequestMethod.GET, value = "/api/stackuserreputation/{id}")
    public @ResponseBody Object getReputation(@PathVariable String id) { return so.getReputation(id); }

    // Get Tags (100 responses) -- Can put up a chart.
    @RequestMapping(method = RequestMethod.GET, value = "/api/stackusertags/{id}")
    public @ResponseBody ArrayList<Object> getTags(@PathVariable String id) { return so.getTags(id); }

    @RequestMapping(method = RequestMethod.GET, value = "/api/stackusermensions/{id}")
    public @ResponseBody Object getMentions(@PathVariable String id) { return so.getMentions(id); }

    @RequestMapping(method = RequestMethod.GET, value = "/api/stackuserfavorites/{id}")
    public @ResponseBody Object getFavorites(@PathVariable String id) { return so.getFavorites(id); }

    @RequestMapping(method = RequestMethod.GET, value = "/api/stackusertoptags/{id}")
    public @ResponseBody Object getUserTopTags(@PathVariable String id) { return so.getTopTags(id); }

    @RequestMapping(method = RequestMethod.GET, value = "/api/stackuserrephis/{id}")
    public @ResponseBody Object getReputationHistory(@PathVariable String id) { return so.getReputationHistory(id); }

}
