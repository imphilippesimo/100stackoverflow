package com.zerofiltre.stackoverflow.q_66417284_5615357_zalando.problem;

import java.net.URI;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class TaskNotFoundProblem extends AbstractThrowableProblem {

  private static final URI TYPE
      = URI.create("https://example.org/not-found");

  public TaskNotFoundProblem(Long taskId) {
    super(
        TYPE,
        "Not found",
        Status.NOT_FOUND,
        String.format("Task '%s' not found", taskId));
  }

}
