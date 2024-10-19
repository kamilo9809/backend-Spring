package com.group_3.backen_project.repositories;

import com.group_3.backen_project.models.Topics_bootcamps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicsBootcampsRepository extends JpaRepository<Topics_bootcamps, Long> {
}
