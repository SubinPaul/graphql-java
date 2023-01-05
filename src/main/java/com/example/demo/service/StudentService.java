package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired StudentRepository studentRepository;

  public Student getStudentById(long id) {
    return studentRepository.findById(id).get();
  }
}
