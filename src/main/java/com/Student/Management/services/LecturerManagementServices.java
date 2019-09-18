package com.Student.Management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.Management.data.manager.CourseDataManager;
import com.Student.Management.data.manager.LecturerDataManager;
import com.Student.Management.entities.Course;
import com.Student.Management.entities.Lecturer;

@Service
public class LecturerManagementServices 
{
	@Autowired
	private LecturerDataManager lecturerDataManager;
	
	@Autowired
	private CourseDataManager courseDataManager;
	
	
	public Lecturer registerLecture(Lecturer lecturer)
	{
		
		return lecturerDataManager.save(lecturer);
	}
	
	public Lecturer findLecturerById(String employementNumber)
	{
		Lecturer lecturer = lecturerDataManager.findById(employementNumber)
				.orElseThrow(()->new ResourceNotFoundException("NO LECTURER WITH ID " + employementNumber));
		
		return lecturer;
	}
	
	public Iterable<Lecturer> findAllLecturers()
	{
		return lecturerDataManager.findAll();
	}
	
	public void deleteLecturerById(String empNum)
	{
		lecturerDataManager.findById(empNum)
			.orElseThrow(()->new ResourceNotFoundException("NO LECTURER FOUND WITH ID " + empNum));
		
		lecturerDataManager.deleteById(empNum);
	}
	
	public Lecturer assignLecturerToCourse(String lecturerEmpNumber, String courseId)
	{
		Course course = courseDataManager.findById(courseId)
				.orElseThrow(()->new ResourceNotFoundException("NO COURSE FOUND WITH ID " + courseId));
		
		Lecturer lecturer = lecturerDataManager.findById(lecturerEmpNumber)
				.orElseThrow(()->new ResourceNotFoundException("NO LECTURER FOUND WITH ID " + lecturerEmpNumber));
		
		List<Lecturer> lecturers = course.getLecturers(); 
		List<Course> courses = lecturer.getCoursesTaught();
		
		courses.add(0,course);
		lecturers.add(0, lecturer);
		
		lecturer.setCoursesTaught(courses);
		course.setLecturer(lecturers);
		
		lecturerDataManager.save(lecturer);
		courseDataManager.save(course);
		
		return lecturer;
		
	}

}
