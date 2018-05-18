package com.springgithub.springgithub.controller;

import com.springgithub.springgithub.services.twitter.CustomTwitterService;
import com.springgithub.springgithub.services.twitter.TwitterToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.PagableResponseList;
import twitter4j.TwitterException;
import twitter4j.User;

@RestController
public class TwitterController {

    @Autowired
    private CustomTwitterService tw;

    @RequestMapping(method = RequestMethod.GET, value = "/api/twitteruser/{username}")
    public User getTwitterUser(@PathVariable String username) throws TwitterException {
        return tw.getTwitterUser(username);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/twitterstatuses/{handle}")
    public Object getTwitterUserStatuses(@PathVariable String handle) throws TwitterException {
        return tw.getTwitterUserTimelines(handle);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/twitterfriends/{handle}")
    public Object authCheck(@PathVariable String handle) throws TwitterException {
        return tw.getFriendsAPI(handle);
    }

    // The endpoint `/gettwitterfriends` should be executed before executing this endpoint.
    @RequestMapping(method = RequestMethod.GET, value = "/api/twitterfollowers/{handle}")
    public Object getTwitterFollowersRe(@PathVariable String handle) throws TwitterException {
        return tw.getTwitterFollowersRe(handle);
    }

}
