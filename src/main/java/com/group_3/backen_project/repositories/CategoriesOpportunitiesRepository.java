package com.group_3.backen_project.repositories;

import com.group_3.backen_project.models.Categories_opportunities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesOpportunitiesRepository extends JpaRepository<Categories_opportunities, Long> {
}
