package com.zerofiltre.stackoverflow.q_66752109_5615357_save_mongodb;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(value = Lifecycle.PER_CLASS)
public class MongoTests {

  @Autowired
  private SongInfoRepository songInfoRepository;

  @Autowired
  private MockMvc mockMvc;

  SongInfo songInfo = new SongInfo();


  @BeforeAll
  void init() {
    songInfo.setSongName("First song name");
    songInfo.setSongId(12);
    songInfo.setDescription("First song description");
    songInfo = songInfoRepository.save(songInfo);
  }

  @Test
  public void getSongBySongId_ShouldReturnASong() throws Exception {
    mockMvc.perform(get("/songsinfo/songid=12"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("First song description")));

  }

  @Test
  public void getSongById_ShouldReturnASong() throws Exception {
    mockMvc.perform(get("/songsinfo/" + songInfo.getId()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("First song description")));

  }



}
