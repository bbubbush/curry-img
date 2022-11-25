package com.bbubbush.curryimg.api;

import com.bbubbush.curryimg.dto.req.TranslateArabicReq;
import com.bbubbush.curryimg.dto.res.TranslateArabicRes;
import com.bbubbush.curryimg.service.translate.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translate")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TranslateRestController {
  private final TranslateService googleTranslateService;

  @GetMapping("/arabic")
  public TranslateArabicRes translateForArabic(TranslateArabicReq translateArabicReq) {
    return TranslateArabicRes.builder()
      .translateText(googleTranslateService.translate(translateArabicReq))
      .build();
  }
}
