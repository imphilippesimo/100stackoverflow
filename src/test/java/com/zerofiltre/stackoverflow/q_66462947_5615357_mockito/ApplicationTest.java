package com.zerofiltre.stackoverflow.q_66462947_5615357_mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ApplicationTest {


  @InjectMocks
  MainClass mainClass;

  @Mock
  DatabaseDAO databaseDAO;

  @Mock
  NetworkDAO networkDAO;


  @Test
  public void validateTest() {
    boolean saved = mainClass.save("temp.txt");
    assertEquals(true, saved);
  }
}