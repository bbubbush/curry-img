package com.bbubbush.curryimg.repository.common;

import com.bbubbush.curryimg.entity.common.SearchImageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchImageLogRepository extends JpaRepository<SearchImageLog, Long> {
}
