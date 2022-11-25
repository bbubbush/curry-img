package com.bbubbush.curryimg.entity.common;

import com.bbubbush.curryimg.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity @Getter
@Table(name = "search_image_log")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@DynamicUpdate @Builder
public class SearchImageLog extends BaseEntity {
  @Id @GeneratedValue
  @Column(name = "search_image_id")
  private Long id;

  @Column(name = "keyword")
  private String keyword;
}
