package com.springgithub.springgithub.controller;

import com.springgithub.springgithub.services.stackoverflow.CustomStackService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.print.attribute.standard.Media;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
public class StackControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CustomStackService customStackService;

    @InjectMocks
    private StackController stackController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(stackController, customStackService).setHandlerExceptionResolvers(new ExceptionHandlerExceptionResolver()).build();
    }

    @Test
    public void testGetUser() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/stackuser/7870026")
                    .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.items", Matchers.notNullValue()));
    }

    @Test
    public void testGetBadges() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/stackuserbadges/7870026")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json("{\"GOLD\":0,\"BRONZE\":4,\"SILVER\":0}"));
    }

    @Test
    public void testGetQuestions() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/stackuserquestionscount/7870026")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json("{\"total\":3}"));
    }

    @Test
    public void testGetAnswers() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/stackuseranswerscount/7870026")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json("{\"total\":2}"));
    }

    @Test
    public void testGetComments() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/stackuserreputation/7870026")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.items", Matchers.notNullValue()));
    }


}