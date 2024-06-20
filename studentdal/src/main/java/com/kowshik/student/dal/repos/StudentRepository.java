package com.kowshik.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.kowshik.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
