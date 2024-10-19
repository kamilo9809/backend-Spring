package com.group_3.backen_project.repositories;

import com.group_3.backen_project.models.User_oportunities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOpportunitiesRepository extends JpaRepository<User_oportunities, Long> {
}
