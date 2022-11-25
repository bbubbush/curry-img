package com.bbubbush.curryimg.entity.app;

import com.bbubbush.curryimg.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity @Getter
@Table(name = "dictionary")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@DynamicUpdate @Builder
public class Dictionary extends BaseEntity {
  @Id @GeneratedValue
  @Column(name = "dictionary_id")
  private Long id;

  @Column(name = "keyword")
  private String keyword;

  @Column(name = "translateText")
  private String translateText;


}
