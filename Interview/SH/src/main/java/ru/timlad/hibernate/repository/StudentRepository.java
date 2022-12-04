package ru.timlad.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.timlad.hibernate.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
