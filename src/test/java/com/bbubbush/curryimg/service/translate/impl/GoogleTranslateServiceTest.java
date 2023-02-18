package com.bbubbush.curryimg.service.translate.impl;

import com.bbubbush.curryimg.dto.req.TranslateArabicReq;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(MockitoExtension.class)
//@Transactional

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@SpringBootTest
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