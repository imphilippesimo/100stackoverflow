package com.zerofiltre.stackoverflow.q_66752109_5615357_save_mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SongInfo {

  @Id
  private String id;
  private int songId;
  private String songName;
  private String description;

}
