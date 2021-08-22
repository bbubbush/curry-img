package com.bbubbush.curryimg;

import com.bbubbush.curryimg.translate.service.GoogleTranslateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppRunner implements ApplicationRunner {
  private final GoogleTranslateService service;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    service.translate("");
  }
}
