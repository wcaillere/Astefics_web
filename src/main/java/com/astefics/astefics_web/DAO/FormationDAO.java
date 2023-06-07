package com.astefics.astefics_web.DAO;

import com.astefics.astefics_web.entity.Formation;
import com.astefics.astefics_web.repository.IFormationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class FormationDAO {

    private IFormationRepository repository;

    public List<Formation> getAllFormations() {
        return repository.findAll();
    }

    public List<Formation> getFormationsByCategory(String idCategory) {
        return repository.getFormationsByCategory(idCategory);
    }

    public Formation getOneFormationById(Integer id) {
        Formation formation = null;
        Optional<Formation> fundFormation = repository.findById(id);

        if (fundFormation.isPresent()) {
            formation = fundFormation.get();
        }

        return formation;
    }

    public void addFormation(Formation formation) {
        repository.save(formation);
    }

    public void deleteFormation(Integer id) {
        if (getOneFormationById(id) != null) {
            repository.deleteById(id);
        }
    }
}
