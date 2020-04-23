package com.hs.service;

import java.util.List;

import com.hs.model.Student;
import com.hs.util.Page;

public interface StudentService {

	public String saveStudent(Student student);

	public Page<Student> getStudentByName(String name,Integer curPage);

	public String deleteStudentById(String id);
	
//	public String saveStudentByName(String name);
	
	public List<Student> getStudentList();
}
