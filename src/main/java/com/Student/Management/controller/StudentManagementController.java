package com.Student.Management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Student.Management.entities.Course;
import com.Student.Management.entities.Lecturer;
import com.Student.Management.entities.Student;
import com.Student.Management.services.CourseManagementServices;
import com.Student.Management.services.LecturerManagementServices;
import com.Student.Management.services.StudentManagementServices;

@RestController
@RequestMapping("/api/students")

//enabling cors on local machine to access the api on react app
@CrossOrigin(origins="http://localhost:3000")
public class StudentManagementController 
{
	@Autowired
	private StudentManagementServices studentManagementServices;
	
	@Autowired
	private CourseManagementServices courseManagementServices;
	
	@Autowired
	private LecturerManagementServices lecturerManagementServices;
	
	//students end points
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(produces= {"application/json"},value="/register")
	public Student registerStudent(@RequestBody Student student)
	{
		return studentManagementServices.registerStudent(student);
	}
	
	@PutMapping(value="/courses/{courseId}/student/{studentId}")
	public Student registerForCourse(@PathVariable("courseId")String courseId, @PathVariable("studentId")String studentId)
	{
		return studentManagementServices.registerForCourse(courseId, studentId);
	}
	
	@GetMapping(produces= {"application/json"}, value="/student/{studentId}")
	public Student viewSingleStudent(@PathVariable("studentId")String studentId)
	{
		return studentManagementServices.findOneStudent(studentId);
	}
	
	@GetMapping(value="/all")
	public Iterable<Student> getAllStudents()
	{
		return studentManagementServices.findAllStudents();
	}
	
	@GetMapping(value="/student/login/{studentId}/password/{password}")
	public Student studentLogIn(@PathVariable("studentId")String studentId, @PathVariable("password")String password)
	{
		return studentManagementServices.findStudentByIdAndPassword(studentId, password);
	}
	
	@PostMapping(value="/student/{studentId}")
	public Student changePassword(@PathVariable("studentId")String studentId, String newPassword)
	{
		return studentManagementServices.changePassword(studentId, newPassword);
	}
	
	@DeleteMapping(value="/student/{studentId}")
	public void deteleStudent(@PathVariable("studentId")String studentId)
	{
		studentManagementServices.deleteStudent(studentId);
	}

	//courses end points

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value="/courses/add")
	public Course addCourse(@RequestBody Course course)
	{
		return courseManagementServices.createCourse(course);
	}
	
	@GetMapping(value="/courses/all")
	public List<Course> getAllCourses()
	{
		return courseManagementServices.getAllCourses();
	}
	
	@DeleteMapping(value="/courses/{courseId}")
	public void deleteCourse(@PathVariable("courseId") String courseId)
	{
		courseManagementServices.deleteCourse(courseId);
	}
	
	//lecturer end points
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value="/lecturer/register")
	public Lecturer addLecturer(@RequestBody Lecturer lecturer)
	{
		return lecturerManagementServices.registerLecture(lecturer);
	}
	
	@GetMapping(value="lecturer/{employmentNumber}")
	public Lecturer findLecturerById(@PathVariable String employmentNumber)
	{
		return lecturerManagementServices.findLecturerById(employmentNumber);
	}
	
	@GetMapping(value="/lecturer/all")
	public Iterable<Lecturer> getAllLecturers()
	{
		return lecturerManagementServices.findAllLecturers();
	}
	
	@PutMapping(value="/lecturer/{empNumber}/course/{courseId}")
	public Lecturer assignLectureToCourse(@PathVariable("empNumber") String empNumber, @PathVariable("courseId") String courseId)
	{
		return lecturerManagementServices.assignLecturerToCourse(empNumber, courseId);
	} 
	@DeleteMapping(value="/lecturer/{empNumber}")
	public void deleteLecturer(@PathVariable("empNumber") String empNumber)
	{
		lecturerManagementServices.deleteLecturerById(empNumber);
	}
	
}
