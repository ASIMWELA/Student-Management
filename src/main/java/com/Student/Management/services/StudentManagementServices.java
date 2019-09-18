package com.Student.Management.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.Management.data.manager.CourseDataManager;
import com.Student.Management.data.manager.StudentDataManager;
import com.Student.Management.entities.Course;
import com.Student.Management.entities.Student;

@Service
public class StudentManagementServices
{
	@Autowired
	private StudentDataManager studentDataManager;
	
	@Autowired 
	private CourseDataManager  courseDataManager ;
		
	
	public Student registerStudent(Student student) 
	{
		return studentDataManager.save(student);
	}

	public Student findOneStudent(String studentId)
	{
		return studentDataManager.findById(studentId)
				.orElseThrow(()->new ResourceNotFoundException("NO STUDENT FOUND WITH ID "+ studentId));
	}

	public Iterable<Student> findAllStudents()
	{
		return studentDataManager.findAll();
	}

	public void deleteStudent(String studentId)
	{
		studentDataManager.findById(studentId).
		orElseThrow(()->new ResourceNotFoundException("NO STUDENT WITH ID " + studentId));
		
		studentDataManager.deleteById(studentId);
		
	}

	public Student findStudentByIdAndPassword(String studentId, String password)
	{
		
		return studentDataManager.findByIdAndPassword(studentId, password);
	}
	
	//regestering for the available courses in the system
	
	public Student registerForCourse(String courseId, String studentId)
	{
		Student student = studentDataManager.findById(studentId)
				.orElseThrow(()->new ResourceNotFoundException("NO STUDENT WITH ID " + studentId ));
		
		Course course = courseDataManager.findById(courseId)
				.orElseThrow(()->new ResourceNotFoundException("NO COURSE WITH ID " + courseId ));
		
		//course.setStudent(student);
		
		List<Course> courses = student.getRegisteredCourses();
		
		List<Student> students = course.getStudents();
		
		
		students.add(0, student);		
		courses.add(0,course);
		
		student.setRegisteredCourses(courses);
		course.setStudent(students);
		
		studentDataManager.save(student);
		courseDataManager.save(course);
		
		return student;
		
	} 
	
	public Student changePassword(String studentId, String newPassword)
	{
		Student student = studentDataManager.findById(studentId)
				.orElseThrow(()->new ResourceNotFoundException("NO STUDENT FOUND WITH ID  "+ studentId));
		
		student.setPassword(newPassword);
		
		studentDataManager.save(student);
		
		return student;
		
	}
	
}
