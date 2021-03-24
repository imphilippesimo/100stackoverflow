package com.zerofiltre.stackoverflow.q_66752109_5615357_save_mongodb;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/songsinfo")
public class SongsInfoController {

  private final SongInfoService songInfoService;
  private final SongInfoRepository songInfoRepository;

  public SongsInfoController(SongInfoService songInfoService,
      SongInfoRepository songInfoRepository) {
    this.songInfoService = songInfoService;
    this.songInfoRepository = songInfoRepository;
  }

  @GetMapping(value = "/init")
  public ResponseEntity<SongInfo> init() {
    SongInfo songInfo = new SongInfo();
    songInfo.setSongName("First song name");
    songInfo.setSongId(12);
    songInfo.setDescription("First song description");

    songInfo = songInfoRepository.save(songInfo);
    return new ResponseEntity<>(songInfo, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}", headers = "Accept=application/json", produces =
      {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<SongInfo> getSongInfoById(@PathVariable(value = "id") String id) {
    SongInfo songInfo;
    try {
      songInfo = songInfoService.getSongInfoById(id);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(songInfo, HttpStatus.OK);
  }

  @GetMapping(value = "/songid={songId}", headers = "Accept=application/json", produces =
      {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<SongInfo> getSongInfoBySongId(@PathVariable(value = "songId")
      Integer songId) {
    SongInfo songInfo = songInfoService.getSongInfoBySongId(songId);
    if (songInfo == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(songInfo, HttpStatus.OK);
  }
}
