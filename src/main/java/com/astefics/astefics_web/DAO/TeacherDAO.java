package com.astefics.astefics_web.DAO;

import com.astefics.astefics_web.entity.Category;
import com.astefics.astefics_web.entity.Teacher;
import com.astefics.astefics_web.repository.ITeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TeacherDAO {

    @Autowired
    private ITeacherRepository repository;

    public List<Teacher> getAllTeachers() {
        return repository.findAll();
    }

}
