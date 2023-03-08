package com.nester77.NMS.data.repository;

import com.nester77.NMS.data.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
