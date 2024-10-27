package com.group_3.backen_project.repositories;

import com.group_3.backen_project.models.Descriptions_bootcamps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionsBootcampsRepository extends JpaRepository<Descriptions_bootcamps, Long> {
}
