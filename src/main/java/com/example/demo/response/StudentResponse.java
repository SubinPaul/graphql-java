package com.example.demo.response;

import com.example.demo.entity.Student;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponse {

  private long id;

  private String firstName;

  private String lastName;

  private String email;

  private String street;

  private String city;

  private List<SubjectResponse> learningSubjects;

  // this is for internal use. do not put in schema file
  private Student student;

  private String fullname;

  public StudentResponse(Student student) {
    this.student = student;
    this.id = student.getId();
    this.firstName = student.getFirstName();
    this.lastName = student.getLastName();
    this.email = student.getEmail();

    this.street = student.getAddress().getStreet();
    this.city = student.getAddress().getCity();

    // Moving to Resolver
    /*	if (student.getLearningSubjects() != null) {
    	learningSubjects = new ArrayList<SubjectResponse>();
    	for (Subject subject: student.getLearningSubjects()) {
    		learningSubjects.add(new SubjectResponse(subject));
    	}
    }*/
  }
}
