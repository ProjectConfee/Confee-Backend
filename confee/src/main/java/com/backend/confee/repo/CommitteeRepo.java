package com.backend.confee.repo;

import com.backend.confee.entity.Committee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitteeRepo extends JpaRepository<Committee,Integer> {

}
