package com.astefics.astefics_web.DAO;

import com.astefics.astefics_web.entity.Student;
import com.astefics.astefics_web.repository.IStudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class StudentDAO {

    private IStudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getOneStudentById(Integer id) {
        Student student = null;

        Optional<Student> fundStudent = repository.findById(id);

        if (fundStudent.isPresent()) {
            student = fundStudent.get();
        }

        return student;
    }

    public void addStudent(Student student) {
        repository.save(student);
    }

    public void deleteStudent(Integer id) {
        if (getOneStudentById(id) != null) {
            repository.deleteById(id);
        }
    }
}
