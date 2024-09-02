package com.backend.confee.repo;

import com.backend.confee.entity.AllUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AllUsersRepo extends JpaRepository<AllUsers,Integer> {
    Optional<AllUsers> findByEmail(String email);
}
