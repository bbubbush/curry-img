package com.bbubbush.curryimg.translate.service;

import com.bbubbush.curryimg.translate.dto.TranslateDto;

public interface TranslateService {
    TranslateDto translate(String keyword);
}
