package com.zerofiltre.stackoverflow.q_66483932_5615357_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloWorldController {

  @GetMapping
  public ModelAndView helloWorld() {
    final ModelAndView bootstrapFront = new ModelAndView("index.html");
    return bootstrapFront;
  }
}
