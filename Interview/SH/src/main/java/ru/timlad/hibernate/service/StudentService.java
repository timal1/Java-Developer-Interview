package ru.timlad.hibernate.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.timlad.hibernate.entity.Student;
import ru.timlad.hibernate.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    public List<Student> findAll() {
       return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public Student update(Student student) {

        Student studentUpdate = studentRepository.getById(student.getId());
        studentUpdate.setName(student.getName());
        studentUpdate.setMark(student.getMark());
        return studentUpdate;
    }
}
