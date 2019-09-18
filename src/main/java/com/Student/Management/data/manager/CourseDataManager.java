package com.Student.Management.data.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Student.Management.entities.Course;

public interface CourseDataManager extends JpaRepository<Course, String>
{
	

}
