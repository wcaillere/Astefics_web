package com.astefics.astefics_web.DAO;

import com.astefics.astefics_web.entity.Teacher;
import com.astefics.astefics_web.repository.ITeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeacherDAO {

    @Autowired
    private ITeacherRepository repository;

    public List<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    public Teacher getOneTeacherById(Integer id) {
        Teacher teacher = null;

        Optional<Teacher> fundTeacher = repository.findById(id);

        if (fundTeacher.isPresent()) {
            teacher = fundTeacher.get();
        }

        return teacher;
    }

    public void addTeacher(Teacher teacher) {
        repository.save(teacher);
    }

    public void deleteTeacher(Integer id) {
        if (getOneTeacherById(id) != null) {
            repository.deleteById(id);
        }
    }

}
