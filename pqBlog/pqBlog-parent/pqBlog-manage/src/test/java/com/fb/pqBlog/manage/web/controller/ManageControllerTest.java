package com.fb.pqBlog.manage.web.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fb.pqBlg.manage.web.controller.ManageController;
import com.fb.pqBlog.common.eneity.common.User;
import com.fb.pqBlog.manage.config.JsonConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest(classes = ManageController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Import(JsonConfig.class)
public class ManageControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void whenUserListSuccess() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/user").
                contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1));
    }

    @Test
    public void whenUserAddSuccess() throws Exception {
        User user = new User();
        user.setUsername("1111");
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/user").content(JSON.toJSONString(user)).
                contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }


}
