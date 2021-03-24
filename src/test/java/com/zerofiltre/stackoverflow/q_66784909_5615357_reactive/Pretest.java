package com.zerofiltre.stackoverflow.q_66784909_5615357_reactive;


import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class Pretest {

  @Test
  void convert() throws JsonProcessingException {

    String responseAsjsonString = "[{\"id\": \"123abc\"},{\"id\": \"123cba\"}] ";
    Workspace[] workspaces = new ObjectMapper().readValue(responseAsjsonString, Workspace[].class);

    ArrayList<String> newmWorkspace = new ArrayList<>();
    Flux<Workspace> mWorkspace = Flux.fromArray(workspaces)
        .map(workspace -> {
          newmWorkspace.add(workspace.getId());
          return workspace;
        });
    mWorkspace.blockLast();

    assertThat(newmWorkspace.get(0)).isEqualTo("123abc");
    assertThat(newmWorkspace.get(1)).isEqualTo("123cba");

  }

}
