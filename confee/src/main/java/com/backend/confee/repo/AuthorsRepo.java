package com.backend.confee.repo;

import com.backend.confee.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepo extends JpaRepository<Authors, Integer> {

}
