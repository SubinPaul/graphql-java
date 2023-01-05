package com.example.demo.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.request.SampleRequest;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

  @Autowired StudentService studentService;

  public String firstQuery() {
    return "First Query";
  }

  public String secondQuery() {
    return "Second Query";
  }

  // Pass parameters
  public String fullName(String firstName, String lastName) {
    return firstName + lastName;
  }

  // Pass parameters json request
  public String fullNameJson(SampleRequest sampleRequest) {
    return sampleRequest.getFirstName() + sampleRequest.getLastName();
  }

  // Get Student
  public StudentResponse student(long id) {
    return new StudentResponse((studentService.getStudentById(id)));
  }
}
