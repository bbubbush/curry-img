package com.bbubbush.curryimg.service.translate.impl;

import com.bbubbush.curryimg.dto.req.TranslateArabicReq;
import com.bbubbush.curryimg.entity.app.Dictionary;
import com.bbubbush.curryimg.service.dictionary.DictionaryService;
import com.google.api.services.translate.model.TranslationsResource;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.hibernate.sql.ordering.antlr.TranslationContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

//@ExtendWith(MockitoExtension.class)
//@Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class GoogleTranslateServiceTest {
  @Autowired
  private GoogleTranslateService translateService;



  @Test
  @DisplayName("구글 번역")
  void translate() {
    // given
//    TranslationsResource a = new Translate();
//    Translate translate = TranslateOptions.getDefaultInstance().getService();
//    given(dictionaryService.findArabicByWord(any())).willReturn(null);
//    given(TranslateOptions.getDefaultInstance().getService()).willReturn(translate);
//    given(translate.translate(anyString(), any())).willReturn(new TranslateImpl(any()));



    TranslateArabicReq translateArabicReq = new TranslateArabicReq();
    translateArabicReq.setKeyword("사과");
    //translateArabicReq.("사과");


    // when
    final String arabicWord = translateService.translate(translateArabicReq);

    // then
    assertThat(arabicWord).isNotNull();
    assertThat(arabicWord).isEqualTo("يعتذر");
  }
}