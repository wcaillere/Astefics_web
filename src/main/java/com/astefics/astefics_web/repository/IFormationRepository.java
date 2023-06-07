package com.astefics.astefics_web.repository;

import com.astefics.astefics_web.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFormationRepository extends JpaRepository<Formation, Integer> {

    @Query(value = "SELECT * FROM formations f where f.id_category = :idCategory", nativeQuery = true)
    public List<Formation> getFormationsByCategory(String idCategory);
}
