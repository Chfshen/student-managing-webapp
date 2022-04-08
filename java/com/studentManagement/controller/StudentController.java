package com.studentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.studentManagement.entity.Student;
import com.studentManagement.service.StudentListService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentListService service;

	@GetMapping("/list")
	public String listStudent(Model model) {
		model.addAttribute("students", service.getStudents());
		return "List";
	}
	
	@GetMapping("/addNewForm")
	public String addNewStudent(Model model) {
		Student newStudent = new Student();
		model.addAttribute("new-student", newStudent);
		return "add-new-form";
	}
	
	@PostMapping("/saveNewStudent")
	public String saveNewStudent(@ModelAttribute("new-student") Student newStudent) {
		service.saveStudent(newStudent);
		return "redirect:/student/list";
	}
	
	@GetMapping("/getUpdateForm")
	public String showUpdateForm(@RequestParam("id") int id, Model model) {
		Student theStudent = service.getStudent(id);
		model.addAttribute("the-student", theStudent);
		return "update-form";
	}
	
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute("the-student") Student theStudent) {
		service.updateStudent(theStudent);
		return "redirect:/student/list";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id) {
		service.deleteStudent(id);
		return "redirect:/student/list";
	}
}
