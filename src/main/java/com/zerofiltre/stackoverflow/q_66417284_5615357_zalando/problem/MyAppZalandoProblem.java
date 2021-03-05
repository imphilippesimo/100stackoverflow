package com.zerofiltre.stackoverflow.q_66417284_5615357_zalando.problem;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class MyAppZalandoProblem extends AbstractThrowableProblem {


  public MyAppZalandoProblem() {
    super(
        null,
        null,
        Status.BAD_REQUEST,
        null,
        null,
        null,
        Collections.singletonMap("appError", "The name field that you filled in has Invalid special characters.")
    );
  }

  @Override
  public String toString() {
    Stream<String> parts = this.getParameters().entrySet().stream().map(Object::toString).filter(Objects::nonNull);
    return this.getType().toString() + "{" + parts.collect(Collectors.joining(", ")) + "}";
    //return "";
  }
}
