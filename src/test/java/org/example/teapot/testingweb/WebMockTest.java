package org.example.teapot.testingweb;
import org.example.teapot.config.BasicConfig;
import org.example.teapot.controller.ReController;
import org.example.teapot.controller.StatusController;
import org.example.teapot.service.RepairBayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;



@WebMvcTest(ReController.class)
@AutoConfigureWebMvc
//@ContextConfiguration(classes = {BasicConfig.class, ReController.class})
public class WebMockTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Mock
    private RepairBayService service;

    @BeforeEach
    public void setUp(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void statusShouldReturnMessageFromService() throws Exception {
//        when(service.greet()).thenReturn("Hello, Mock");
        this.mockMvc.perform(get("/api/status")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("navigation")));
    }




}
