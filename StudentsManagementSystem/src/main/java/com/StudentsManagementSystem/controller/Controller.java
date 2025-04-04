package com.StudentsManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.StudentsManagementSystem.entity.Student;
import com.StudentsManagementSystem.service.StudentService;



@org.springframework.stereotype.Controller
public class Controller {
    
	@Autowired
	private StudentService service;
	
	
	@GetMapping("/home")
	public String home() {
		return "home";//view page html file-home.html
	}
	
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", service.getAllStudents());//students is a key and it is passed through thymeleaf in students.html
		return "students";
	}
	
	@GetMapping("students/new")
	public String createStudentForm(Model model) {
		Student student=new Student();//hold the student object
		model.addAttribute("students", student);
		
		return "create-student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		 service.saveStudent(student);
		 return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id,Model model) {
		model.addAttribute("student",service.getById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute("|student") Student student) {
		Object existingStudent=service.getById(id);
		((Student) existingStudent).setFirstName(student.getFirstName());
		((Student) existingStudent).setLastName(student.getLastName());
		((Student) existingStudent).setEmail(student.getEmail());
		
		service.saveStudent((Student) existingStudent);
		
		
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/students";
	}
}
