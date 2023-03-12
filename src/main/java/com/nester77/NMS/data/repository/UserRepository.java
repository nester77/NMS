package com.nester77.NMS.data.repository;

import com.nester77.NMS.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users u WHERE LOWER(u.user_name) = LOWER(:user_name)", nativeQuery = true)
    Optional<User> findByUserName(@Param("user_name") String userName);
}
