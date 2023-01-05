package com.example.demo.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.request.SampleRequest;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
  public String firstQuery () {
    return "First Query";
  }

  public String secondQuery () {
    return "Second Query";
  }

  //Pass parameters
  public String fullName(String firstName, String lastName)
  {
    return firstName + lastName;
  }

  //Pass parameters json request
  public String fullNameJson(SampleRequest sampleRequest)
  {
    return sampleRequest.getFirstName() + sampleRequest.getLastName();
  }
}
