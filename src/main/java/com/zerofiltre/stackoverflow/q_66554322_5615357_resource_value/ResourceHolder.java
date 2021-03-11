package com.zerofiltre.stackoverflow.q_66554322_5615357_resource_value;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ResourceHolder {

  @Value("file:${input.file}")
  private Resource inputResource;

  @Bean
  public FlatFileItemReader<PE> reader() {
    FlatFileItemReader<PE> itemReader = new FlatFileItemReader<PE>();
    itemReader.setResource(inputResource);
    //Set number of lines to skips. Use it if file has header rows.
    itemReader.setLinesToSkip(1);
    //Configure how each line will be parsed and mapped to different values
    itemReader.setLineMapper(new DefaultLineMapper<PE>() {
      {
        //2 columns in each row
        setLineTokenizer(new DelimitedLineTokenizer() {
          {
            setNames("key", "value");
          }
        });
        //Set values in PE class
        setFieldSetMapper(new BeanWrapperFieldSetMapper<PE>() {
          {
            setTargetType(PE.class);
          }
        });
      }
    });
    return itemReader;
  }

}
