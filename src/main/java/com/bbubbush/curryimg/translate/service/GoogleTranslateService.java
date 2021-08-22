package com.bbubbush.curryimg.translate.service;

import com.bbubbush.curryimg.translate.dto.TranslateDto;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.cloud.translate.v3.TranslateTextRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Slf4j
public class GoogleTranslateService implements TranslateService {

  @Override
  public TranslateDto translate(String keyword) {
    Translate translate = TranslateOptions.getDefaultInstance().getService();
    Translation translation =
        translate.translate(
            "시험",
            Translate.TranslateOption.sourceLanguage(Locale.KOREA.getLanguage()),
            Translate.TranslateOption.targetLanguage("hi"));
    log.info("Translated Text:\n\t{}\n", translation.getTranslatedText());
    return null;
  }
}
