package ru.timlad.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.timlad.spring.converter.StudentConverter;
import ru.timlad.spring.dto.StudentDto;
import ru.timlad.spring.entity.Student;
import ru.timlad.spring.service.StudentService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentConverter studentConverter;

    @GetMapping("/findAll")
    public Page<StudentDto> findAll(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "name_part", required = false) String namePart,
            @RequestParam(name = "age", required = false) Integer age

    ) {
        if (page < 1) {
            page = 1;
        }
        return studentService.findAll(namePart, age, page).map(
                p -> studentConverter.entityToDto(p));
    }

    @GetMapping("/get_student/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentConverter.entityToDto(studentService.findById(id));
    }

    @PostMapping("/save")
    public StudentDto saveNewStudent(@RequestBody Student student) {
        return studentConverter.entityToDto(studentService.save(student));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @PutMapping("/update")
    public StudentDto updateStudent(@RequestBody Student student) {
        return studentConverter.entityToDto(studentService.update(student));
    }
}
