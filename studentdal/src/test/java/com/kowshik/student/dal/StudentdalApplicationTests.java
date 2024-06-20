package com.kowshik.student.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kowshik.student.dal.entities.Student;
import com.kowshik.student.dal.repos.StudentRepository;

@SpringBootTest
class StudentdalApplicationTests {
	
	@Autowired
	private StudentRepository repo;
	
	
	@Test
	void testCreateStudent() {
		Student student=new Student();
		student.setName("Kowshik");
		student.setCourse("AWS");
		student.setFee(30d);
		
		repo.save(student);
	}
	@Test
	void testFindStudentbyId() {
		Student student=repo.findById(2l).get();
		System.out.println(student);
	}
	
	@Test
	void testUpdateStudent() {
		Student student=repo.findById(2l).get();
		student.setFee(50d);
		repo.save(student);
		
	}
	
	@Test
	void testDeleteStudent() {
		Student student=repo.findById(2l).get();
		repo.delete(student);
	}
}
