package com.Student.Management.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student
{
	@Id
	@Column(name = "student_id", unique=true)
	private String id;
	
	@Column(name="fname")
	private String firstName;
	
	@Column(name = "lname")
	private String lastName;
	
	@Column(name ="sex")
	private String sex;

	@Column(name="password")
	private String password = passwordGenerator();
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Course> registeredCourses;
	
	public List<Course> getRegisteredCourses()
	{	
		return registeredCourses;
	}
	
	public void setRegisteredCourses(List<Course> registeredCourses) 
	{
		this.registeredCourses = registeredCourses;
	}


	public String getId()
	{
		return id;
	}
	

	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setPassword(String password)
	{
		this.password =password;
	}
	
	public String getPassword()
	{
		return password;
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

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public static String passwordGenerator()
	{
		int passwordLength = 6;
		int [] password = new int[passwordLength];
		
		for(int i = 0; i < passwordLength; i++)
		{
			password[i] = (int)Math.random()*100;
		}
		
		String passwordContent = (password.toString()).substring(3, 10);
		
		return passwordContent;
		
	}
	
}
