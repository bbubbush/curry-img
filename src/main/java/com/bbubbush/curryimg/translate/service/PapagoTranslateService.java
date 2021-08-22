package com.bbubbush.curryimg.translate.service;

import com.bbubbush.curryimg.translate.dto.TranslateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PapagoTranslateService implements TranslateService {
  @Override
  public TranslateDto translate(String keyword) {
    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl
            = "https://translate.googleapis.com";
    ResponseEntity<String> response
            = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
//    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    return null;
  }
}
