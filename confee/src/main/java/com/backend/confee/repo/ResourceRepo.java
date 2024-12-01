package com.backend.confee.repo;

import com.backend.confee.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepo extends JpaRepository<Resource, Long> {
    List<Resource> findByWorkshopId(Long workshopId);

}
