package com.backend.confee.repo;




import com.backend.confee.entity.Feedback_sp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedbackRepo extends CrudRepository<Feedback_sp, Long> {
    List<Feedback_sp> findBySponsorId(Long sponsorId);
}

