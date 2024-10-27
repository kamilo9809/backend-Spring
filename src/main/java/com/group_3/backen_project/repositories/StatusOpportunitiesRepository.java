package com.group_3.backen_project.repositories;

import com.group_3.backen_project.models.Status_opportunities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusOpportunitiesRepository extends JpaRepository<Status_opportunities, Long> {
}
