package com.Student.Management.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="courses")
public class Course
{
	@Id
	@Column(name="course_code", nullable=false, unique=true)
	private String courseCode;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="credit_hours", length=2)
	private int creditHours;
	
	@JsonIgnore
	@ManyToMany(mappedBy="registeredCourses")
	private List<Student> students;

	@JsonIgnore
	@ManyToMany(mappedBy="coursesTaught")
	private List<Lecturer> lecturers;
	
	public List<Lecturer> getLecturers()
	{
		return lecturers;
	}


	public void setLecturer(List<Lecturer> lecturer)
	{
		this.lecturers = lecturer;
	}


	public List<Student> getStudents() 
	{
		return students;
	}

	
	public void setStudent(List<Student> students)
	{
		this.students = students;
	}

	public String getCourseCode() 
	{
		return courseCode;
	}
	
	

	public void setCourseCode(String courseCode)
	{
		this.courseCode = courseCode;
	}

	public String getCourseName()
	{
		return courseName;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}

	public int getCreditHours()
	{
		return creditHours;
	}

	public void setCreditHours(int creditHours) 
	{
		this.creditHours = creditHours;
	}
	
}
