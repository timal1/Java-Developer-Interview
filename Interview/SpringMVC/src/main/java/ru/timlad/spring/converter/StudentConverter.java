package ru.timlad.spring.converter;

import org.springframework.stereotype.Component;
import ru.timlad.spring.dto.StudentDto;
import ru.timlad.spring.entity.Student;

@Component
public class StudentConverter {
    public Student dtoToEntity(StudentDto studentDto) {
        return new Student(studentDto.getId(), studentDto.getName(), studentDto.getAge());
    }

    public StudentDto entityToDto(Student student) {
        return new StudentDto(student.getId(), student.getName(), student.getAge());
    }
}
