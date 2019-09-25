package com.tts.studentExample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.studentExample.model.Student;

//5
@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	
}
