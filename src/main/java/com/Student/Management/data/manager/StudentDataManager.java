package com.Student.Management.data.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Student.Management.entities.Student;

@Repository
public interface StudentDataManager extends JpaRepository<Student, String>
{
	public Student findByIdAndPassword(String id, String password);
}
