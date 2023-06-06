package com.astefics.astefics_web.DAO;

import com.astefics.astefics_web.entity.Level;
import com.astefics.astefics_web.repository.ILevelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LevelDAO {

    @Autowired
    private ILevelRepository repository;

    public List<Level> getAllLevels() {
        return repository.findAll();
    }
}
