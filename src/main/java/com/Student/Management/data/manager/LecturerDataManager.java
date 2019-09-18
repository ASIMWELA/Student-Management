package com.Student.Management.data.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.Management.entities.Lecturer;

public interface LecturerDataManager extends JpaRepository<Lecturer, String> 
{

}
