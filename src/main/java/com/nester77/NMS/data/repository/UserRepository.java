package com.nester77.NMS.data.repository;

import com.nester77.NMS.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
