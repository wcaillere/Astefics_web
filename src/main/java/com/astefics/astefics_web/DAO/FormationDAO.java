package com.astefics.astefics_web.DAO;

import com.astefics.astefics_web.entity.Category;
import com.astefics.astefics_web.entity.Formation;
import com.astefics.astefics_web.repository.IFormationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FormationDAO {

    @Autowired
    private IFormationRepository repository;

    public List<Formation> getAllFormations() {
        return repository.findAll();
    }

    public Formation getOneFormationById(Integer id) {
        Formation formation = null;
        Optional<Formation> fundFormation = repository.findById(id);

        if (fundFormation.isPresent()) {
            formation = fundFormation.get();
        }

        return formation;
    }
}
