package com.bbubbush.curryimg.repository.app;

import com.bbubbush.curryimg.entity.app.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
  Dictionary findByKeyword(String keyword);
}
