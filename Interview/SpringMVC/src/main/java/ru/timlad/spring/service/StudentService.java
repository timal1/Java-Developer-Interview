package ru.timlad.spring.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.timlad.spring.entity.Student;
import ru.timlad.spring.exeption.ResourceNotFoundException;
import ru.timlad.spring.repository.StudentRepository;
import ru.timlad.spring.repository.specification.StudentSpecification;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    public Page<Student> findAll(String namePart, Integer age, Integer page) {
        Specification<Student> spec = Specification.where(null);
        if (namePart != null) {
            spec = spec.and(StudentSpecification.nameLike(namePart));
        }

        if (age != null) {
            spec = spec.and(StudentSpecification.ageEqualThan(age));
        }

        return studentRepository.findAll(spec, PageRequest.of(page - 1, 20));
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found, id: " + id));
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
        studentUpdate.setAge(student.getAge());
        return studentUpdate;
    }
}
