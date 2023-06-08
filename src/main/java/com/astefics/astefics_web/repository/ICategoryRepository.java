package com.astefics.astefics_web.repository;

import com.astefics.astefics_web.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT * FROM categories c where c.name = :name", nativeQuery = true)
    List<Category> findCategoryByName(String name);
}
