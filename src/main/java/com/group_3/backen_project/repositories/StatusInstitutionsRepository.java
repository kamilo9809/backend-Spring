package com.group_3.backen_project.repositories;

import com.group_3.backen_project.models.Status_institutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusInstitutionsRepository extends JpaRepository<Status_institutions, Long> {
}
