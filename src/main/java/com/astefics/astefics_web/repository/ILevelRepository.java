package com.astefics.astefics_web.repository;

import com.astefics.astefics_web.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILevelRepository extends JpaRepository<Level, Integer> {
}
