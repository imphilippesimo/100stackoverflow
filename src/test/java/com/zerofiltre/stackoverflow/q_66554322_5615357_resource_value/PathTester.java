package com.zerofiltre.stackoverflow.q_66554322_5615357_resource_value;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PathTester {

  @Autowired
  private PathHolder pathHolder;

  @Autowired
  private FlatFileItemReader itemReader;

  @Test
  void afterContextLoads_PathShouldBeRetrieved() {

    assertThat(PathHolder.prop)
        .isEqualTo("C:\\zerofiltre\\services_tech\\100stackoverflow\\100stackoverflow\\sheets.csv");

  }

  @Test
  void mustReadTheResource() throws Exception {
    itemReader.open(new ExecutionContext());
    PE object = (PE) itemReader.read();
    assert object != null;
    assertThat(object.getKey()).isEqualTo("sheets.credentials.file");
    assertThat(object.getValue()).isEqualTo("/my/file");
  }

}
