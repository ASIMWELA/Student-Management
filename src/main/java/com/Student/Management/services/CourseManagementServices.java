package com.Student.Management.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.Management.data.manager.CourseDataManager;
import com.Student.Management.entities.Course;

@Service
public class CourseManagementServices
{
	@Autowired
	private CourseDataManager courseDataManager;
	
	
	public Course createCourse(Course course)
	{
		return courseDataManager.save(course);
	}
	
	public Course findCourseById(String courseId)
	{
		return courseDataManager.findById(courseId)
				.orElseThrow(()->new ResourceNotFoundException("NO COURSE FOUND WITH ID " + courseId));

	}
	
	public List<Course> getAllCourses()
	{
		return  courseDataManager.findAll();
	}
	
	public void deleteCourse(String courseId)
	{
		courseDataManager.findById(courseId)
		   		.orElseThrow(()->new ResourceNotFoundException("NO COURSE FOUND WITH ID " + courseId));
		
		courseDataManager.deleteById(courseId);
	}
	
}
