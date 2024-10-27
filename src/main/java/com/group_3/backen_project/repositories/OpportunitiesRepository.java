package com.group_3.backen_project.repositories;

import com.group_3.backen_project.models.Opportunities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunitiesRepository extends JpaRepository<Opportunities, Long> {
}
