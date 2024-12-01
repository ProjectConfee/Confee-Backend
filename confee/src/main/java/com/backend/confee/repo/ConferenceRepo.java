package com.backend.confee.repo;

import com.backend.confee.entity.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepo extends JpaRepository<Conference, Integer> {

}
