package com.springgithub.springgithub.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.hamcrest.Matchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.Assert.*;

import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import twitter4j.User;


@RunWith(SpringJUnit4ClassRunner.class)
public class TwitterControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private TwitterController twitterController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(twitterController).setHandlerExceptionResolvers(new ExceptionHandlerExceptionResolver()).build();
    }

    @Test
    public void getTwitterUserTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/twitteruser/dasunpubudumal")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Dasun")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.screenName", Matchers.is("dasunpubudumal")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Matchers.nullValue()));

    }

    @Test
    public void getTwitterUserStatusesTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/twitterstatuses/dasunpubudumal")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));

    }

    @Test
    public void getTwitterUserFriendsTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/twitterfriends/dasunpubudumal")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "  \"users\": [\n" +
                        "    {\n" +
                        "      \"id\": 1890373940,\n" +
                        "      \"id_str\": \"1890373940\",\n" +
                        "      \"name\": \"Minol Hewage\",\n" +
                        "      \"screen_name\": \"MinolHewage\",\n" +
                        "      \"location\": \"Homagama\",\n" +
                        "      \"description\": \"\",\n" +
                        "      \"url\": null,\n" +
                        "      \"entities\": {\n" +
                        "        \"description\": {\n" +
                        "          \"urls\": []\n" +
                        "        }\n" +
                        "      },\n" +
                        "      \"protected\": false,\n" +
                        "      \"followers_count\": 30,\n" +
                        "      \"friends_count\": 175,\n" +
                        "      \"listed_count\": 0,\n" +
                        "      \"created_at\": \"Sat Sep 21 14:33:28 +0000 2013\",\n" +
                        "      \"favourites_count\": 48,\n" +
                        "      \"utc_offset\": null,\n" +
                        "      \"time_zone\": null,\n" +
                        "      \"geo_enabled\": false,\n" +
                        "      \"verified\": false,\n" +
                        "      \"statuses_count\": 57,\n" +
                        "      \"lang\": \"en\",\n" +
                        "      \"status\": {\n" +
                        "        \"created_at\": \"Tue May 16 10:08:44 +0000 2017\",\n" +
                        "        \"id\": 864422356252598274,\n" +
                        "        \"id_str\": \"864422356252598274\",\n" +
                        "        \"text\": \"I found a #cloud #torrent that's awesome ;) @seedrcoil it's FREE just give it a try! https://t.co/F9rN03jekK\",\n" +
                        "        \"truncated\": false,\n" +
                        "        \"entities\": {\n" +
                        "          \"hashtags\": [\n" +
                        "            {\n" +
                        "              \"text\": \"cloud\",\n" +
                        "              \"indices\": [\n" +
                        "                10,\n" +
                        "                16\n" +
                        "              ]\n" +
                        "            },\n" +
                        "            {\n" +
                        "              \"text\": \"torrent\",\n" +
                        "              \"indices\": [\n" +
                        "                17,\n" +
                        "                25\n" +
                        "              ]\n" +
                        "            }\n" +
                        "          ],\n" +
                        "          \"symbols\": [],\n" +
                        "          \"user_mentions\": [\n" +
                        "            {\n" +
                        "              \"screen_name\": \"seedrcoil\",\n" +
                        "              \"name\": \"Seedr Official\",\n" +
                        "              \"id\": 2582437764,\n" +
                        "              \"id_str\": \"2582437764\",\n" +
                        "              \"indices\": [\n" +
                        "                44,\n" +
                        "                54\n" +
                        "              ]\n" +
                        "            }\n" +
                        "          ],\n" +
                        "          \"urls\": [\n" +
                        "            {\n" +
                        "              \"url\": \"https://t.co/F9rN03jekK\",\n" +
                        "              \"expanded_url\": \"https://www.seedr.cc/\",\n" +
                        "              \"display_url\": \"seedr.cc\",\n" +
                        "              \"indices\": [\n" +
                        "                85,\n" +
                        "                108\n" +
                        "              ]\n" +
                        "            }\n" +
                        "          ]\n" +
                        "        },\n" +
                        "        \"source\": \"<a href=\\\"http://twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client</a>\",\n" +
                        "        \"in_reply_to_status_id\": null,\n" +
                        "        \"in_reply_to_status_id_str\": null,\n" +
                        "        \"in_reply_to_user_id\": null,\n" +
                        "        \"in_reply_to_user_id_str\": null,\n" +
                        "        \"in_reply_to_screen_name\": null,\n" +
                        "        \"geo\": null,\n" +
                        "        \"coordinates\": null,\n" +
                        "        \"place\": null,\n" +
                        "        \"contributors\": null,\n" +
                        "        \"is_quote_status\": false,\n" +
                        "        \"retweet_count\": 1,\n" +
                        "        \"favorite_count\": 0,\n" +
                        "        \"favorited\": false,\n" +
                        "        \"retweeted\": false,\n" +
                        "        \"possibly_sensitive\": false,\n" +
                        "        \"lang\": \"en\"\n" +
                        "      },\n" +
                        "      \"contributors_enabled\": false,\n" +
                        "      \"is_translator\": false,\n" +
                        "      \"is_translation_enabled\": false,\n" +
                        "      \"profile_background_color\": \"C0DEED\",\n" +
                        "      \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
                        "      \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
                        "      \"profile_background_tile\": false,\n" +
                        "      \"profile_image_url\": \"http://pbs.twimg.com/profile_images/378800000487805804/a32fca4da12314c834d26bb057d475f4_normal.jpeg\",\n" +
                        "      \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/378800000487805804/a32fca4da12314c834d26bb057d475f4_normal.jpeg\",\n" +
                        "      \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/1890373940/1448426473\",\n" +
                        "      \"profile_link_color\": \"1DA1F2\",\n" +
                        "      \"profile_sidebar_border_color\": \"C0DEED\",\n" +
                        "      \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
                        "      \"profile_text_color\": \"333333\",\n" +
                        "      \"profile_use_background_image\": true,\n" +
                        "      \"has_extended_profile\": true,\n" +
                        "      \"default_profile\": true,\n" +
                        "      \"default_profile_image\": false,\n" +
                        "      \"following\": null,\n" +
                        "      \"follow_request_sent\": null,\n" +
                        "      \"notifications\": null,\n" +
                        "      \"muting\": null,\n" +
                        "      \"blocking\": null,\n" +
                        "      \"blocked_by\": null,\n" +
                        "      \"translator_type\": \"none\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"next_cursor\": 0,\n" +
                        "  \"next_cursor_str\": \"0\",\n" +
                        "  \"previous_cursor\": 0,\n" +
                        "  \"previous_cursor_str\": \"0\"\n" +
                        "}"));

    }


}