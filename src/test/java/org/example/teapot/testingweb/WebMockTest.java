package org.example.teapot.testingweb;
import org.example.teapot.controller.ReController;
import org.example.teapot.service.RepairBayService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;


import static org.mockito.Mockito.when;

@WebMvcTest(ReController.class)
public class WebMockTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private RepairBayService service;

    @Test
    void greetingShouldReturnMessageFromService() throws Exception {
//        when(service.greet()).thenReturn("Hello, Mock");
        this.mockMvc.perform(get("/api/status")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("navigation")));
    }
}
