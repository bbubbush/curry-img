package com.bbubbush.curryimg.service.translate.impl;

import com.bbubbush.curryimg.dto.req.TranslateArabicReq;
import com.bbubbush.curryimg.entity.app.Dictionary;
import com.bbubbush.curryimg.service.dictionary.DictionaryService;
import com.bbubbush.curryimg.service.translate.TranslateService;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class GoogleTranslateService implements TranslateService {
  private final DictionaryService dictionaryService;

  @Override
  public String translate(TranslateArabicReq translateArabicReq) {
    final String keyword = translateArabicReq.getKeyword();
    final Dictionary arabicWord = dictionaryService.findArabicByWord(keyword);
    if (arabicWord != null) {
      return arabicWord.getTranslateText();
    }
    String getArabicWord = translate(keyword, translateArabicReq.getLocale());

    dictionaryService.insertArabicWord(keyword, getArabicWord);
    return getArabicWord;
  }


  private String translate(String keyword, String locale) {
    Translate translate = null;
    try {
      translate = TranslateOptions
        .newBuilder()
        .setCredentials(
          ServiceAccountCredentials.fromStream(new ClassPathResource("google-translate-key").getInputStream()))
        .build()
        .getService();
    } catch (IOException e) {
      throw new RuntimeException("Not found google translate key file.");
    }
    Translation translation =
      translate.translate(
        keyword,
        Translate.TranslateOption.sourceLanguage(locale),
        Translate.TranslateOption.targetLanguage("ar"));
    return translation.getTranslatedText();
  }

}
