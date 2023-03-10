package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.entity.Subject;
import com.example.demo.enums.SubjectNameFilter;
import com.example.demo.response.StudentResponse;
import com.example.demo.response.SubjectResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

  public List<SubjectResponse> getLearningSubjects (StudentResponse studentResponse,
      SubjectNameFilter subjectNameFilter) {

    List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();

    if (studentResponse.getStudent().getLearningSubjects() != null) {
      for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
        if (subjectNameFilter.name().equalsIgnoreCase("ALL")) {
          learningSubjects.add(new SubjectResponse(subject));
        } else if (subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())) {
          learningSubjects.add(new SubjectResponse(subject));
        }
      }
    }

    return learningSubjects;
  }

  public String getFullName(StudentResponse studentResponse) {
    return studentResponse.getFirstName() + " " + studentResponse.getLastName();
  }
}
