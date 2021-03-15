package com.zerofiltre.stackoverflow.q_66589790_5615357_json_to_map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {


  @Value("classpath:data.json")
  private Resource resourceFile;


  public HashMap<String, String> convertData() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    TypeReference<HashMap<String, String>> typeRef
        = new TypeReference<>() {
    };
    return mapper.readValue(resourceFile.getInputStream(), typeRef);

  }


}
