package com.khaledmahmud.studentservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Student getStudent(String roll) {
        return studentRepository.findById(roll).get();
    }

	public void addStudent(Student student) {
        studentRepository.save(student);
	}

	public void updateStudent(Student student) {
        studentRepository.save(student);
	}

	public void deleteStudent(String roll) {
        studentRepository.deleteById(roll);
	}

}