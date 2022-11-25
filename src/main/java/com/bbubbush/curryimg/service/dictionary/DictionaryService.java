package com.bbubbush.curryimg.service.dictionary;

import com.bbubbush.curryimg.entity.app.Dictionary;
import com.bbubbush.curryimg.entity.common.SearchImageLog;
import com.bbubbush.curryimg.repository.app.DictionaryRepository;
import com.bbubbush.curryimg.repository.common.SearchImageLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DictionaryService {
  private final DictionaryRepository dictionaryRepository;
  private final SearchImageLogRepository logRepository;

  public Dictionary findArabicByWord(String keyword) {
    return dictionaryRepository.findByKeyword(keyword);
  }

  public Dictionary insertArabicWord(String keyword, String translateText) {
    final Dictionary createDictionary = Dictionary.builder()
      .keyword(keyword)
      .translateText(translateText)
      .build();

    logRepository.save(SearchImageLog
      .builder()
      .keyword(keyword)
      .build());

    return dictionaryRepository.save(createDictionary);
  }

}
