package ru.timlad.spring.repository.specification;


import org.springframework.data.jpa.domain.Specification;
import ru.timlad.spring.entity.Student;

public class StudentSpecification {
    public static Specification<Student> ageEqualThan(Integer age) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("age"), age);
    }

    public static Specification<Student> nameLike(String namePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), String.format("%%%s%%", namePart));
    }
}
