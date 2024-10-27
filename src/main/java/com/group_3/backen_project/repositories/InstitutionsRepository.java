package com.group_3.backen_project.repositories;

import com.group_3.backen_project.models.Institutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionsRepository extends JpaRepository<Institutions, Long> {
}
