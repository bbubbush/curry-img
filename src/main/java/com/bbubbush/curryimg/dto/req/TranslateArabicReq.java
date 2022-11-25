package com.bbubbush.curryimg.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranslateArabicReq {
  public String keyword;
  public String locale;
}
