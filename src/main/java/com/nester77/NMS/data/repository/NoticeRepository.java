package com.nester77.NMS.data.repository;

import com.nester77.NMS.data.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
