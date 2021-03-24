package com.zerofiltre.stackoverflow.q_66752109_5615357_save_mongodb;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SongInfoServiceImpl implements SongInfoService {

  private final SongInfoRepository songInfoRepository;

  @Override
  public SongInfo getSongInfoById(String id) {
    SongInfo songInfo = songInfoRepository.findById(id).orElse(null);
    return songInfo;
  }

  @Override
  public SongInfo getSongInfoBySongId(Integer songId) {
    List<SongInfo> songInfo = new ArrayList();
    for (SongInfo info : songInfoRepository.findAll()) {
      if (info.getSongId() == songId) {
        songInfo.add(info);
      }
    }
    return songInfo.get(0);
  }
}
