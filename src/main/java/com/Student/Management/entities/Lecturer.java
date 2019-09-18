package com.Student.Management.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="lecturer")
public class Lecturer
{
	@Id
	@Column(name="lecturer_id")
	private String id;
	
	@Column(name="fname")
	private String firstName;
	
	@Column(name="lname")
	private String lastName;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="password")
	private String password = Student.passwordGenerator();
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Size(max=3)
	public List<Course> coursesTaught;
	
	public List<Course> getCoursesTaught() 
	{
		return coursesTaught;
	}

	public void setCoursesTaught(List<Course> coursesTaught)
	{
		this.coursesTaught = coursesTaught;
	}

	public String getEmploymentNumber()
	{
		return id;
	}

	public void setEmploymentNumber(String id) 
	{
		this.id= id;
	}

	public String getSex() 
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	
}
