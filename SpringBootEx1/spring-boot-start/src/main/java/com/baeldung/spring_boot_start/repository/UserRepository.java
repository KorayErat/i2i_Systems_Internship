package com.baeldung.spring_boot_start.repository;

import com.baeldung.spring_boot_start.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
