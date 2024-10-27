package com.group_3.backen_project.repositories;

import com.group_3.backen_project.models.Ubications_institutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicationsInstitutionsRepository extends JpaRepository<Ubications_institutions, Long> {
}
