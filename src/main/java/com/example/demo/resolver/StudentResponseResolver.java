package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.entity.Subject;
import com.example.demo.response.StudentResponse;
import com.example.demo.response.SubjectResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

  public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse) {

    List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();

    if (studentResponse.getStudent().getLearningSubjects() != null) {
      for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
        learningSubjects.add(new SubjectResponse(subject));
      }
    }

    return learningSubjects;
  }

  public String getFullName (StudentResponse studentResponse){
    return studentResponse.getFirstName() + " " + studentResponse.getLastName();
  }
}
