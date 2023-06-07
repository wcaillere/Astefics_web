package com.astefics.astefics_web.DAO;

import com.astefics.astefics_web.entity.Level;
import com.astefics.astefics_web.repository.ILevelRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class LevelDAO {

    private ILevelRepository repository;

    public List<Level> getAllLevels() {
        return repository.findAll();
    }
}
