package com.group_3.backen_project.repositories;

import com.group_3.backen_project.models.Bootcamps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcampsRepository extends JpaRepository<Bootcamps, Long> {
}
