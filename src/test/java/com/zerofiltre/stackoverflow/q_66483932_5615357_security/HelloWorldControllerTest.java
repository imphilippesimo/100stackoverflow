package com.zerofiltre.stackoverflow.q_66483932_5615357_security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(controllers = HelloWorldController.class)
@ContextConfiguration
@WebAppConfiguration
class HelloWorldControllerTest {

  @Autowired
  private WebApplicationContext webApplicationContext;

  @MockBean
  UserDetailsServiceImpl userDetailsService;

  private MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void getBootstrappedDoc() throws Exception {
    MvcResult mvcResult = mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andReturn();
    assertEquals("index.html", mvcResult.getModelAndView().getViewName());
  }
}
