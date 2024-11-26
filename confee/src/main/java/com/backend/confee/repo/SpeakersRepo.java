package com.backend.confee.repo;

import com.backend.confee.entity.Speakers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakersRepo extends JpaRepository<Speakers, Integer> {

}
