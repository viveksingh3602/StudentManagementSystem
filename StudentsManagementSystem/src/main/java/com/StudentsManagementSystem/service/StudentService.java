package com.StudentsManagementSystem.service;

import java.util.List;

import com.StudentsManagementSystem.entity.Student;
 
public interface StudentService {
    public List<Student> getAllStudents();
    public Student saveStudent(Student student);
    //public Student getById(int id);
	public Object getById(int id);
	
	public void deleteById(int id);
}
