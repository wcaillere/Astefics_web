package com.astefics.astefics_web.repository;

import com.astefics.astefics_web.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormationRepository extends JpaRepository<Formation, Integer> {
}
