package com.nester77.NMS.data.repository;

import com.nester77.NMS.data.entity.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {
}
