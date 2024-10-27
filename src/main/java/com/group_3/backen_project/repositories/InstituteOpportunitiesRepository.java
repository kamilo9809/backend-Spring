package com.group_3.backen_project.repositories;

import com.group_3.backen_project.models.Institute_opportunities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteOpportunitiesRepository extends JpaRepository<Institute_opportunities, Long> {
}
