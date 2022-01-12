package com.ishmam.resttemplate.Controller;

import com.ishmam.resttemplate.Model.IdVerificationDto;
import com.ishmam.resttemplate.Model.IdVerificationPostDto;
import com.ishmam.resttemplate.Model.Result;
import com.ishmam.resttemplate.Model.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ResultController {

  private RestTemplate template = new RestTemplate();
  List<Result> result = new ArrayList<>();

  public ResultController() {
    result.add(new Result(1L, " ", 1L));
    result.add(new Result(2L, " ", 2L));
    result.add(new Result(3L, " ", 3L));
  }

  @GetMapping("/results")
  public List<Result> getRsult() {
    return result.stream().map(result1 -> {
      Student student = template.getForObject("http://localhost:8081/student/id/" + result1.getId(),
          Student.class);
      return new Result(result1.getId(), student.getName(), result1.getMark());
    }).collect(Collectors.toList());
  }

  @PostMapping("/results-post-student")
  public Student postStudent() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("Passing-Header", "Aise vai aise......");
    Student student = new Student(1L, "D");

    HttpEntity<Student> entity = new HttpEntity<Student>(student, headers);
    return template.exchange("http://localhost:8081/student-create", HttpMethod.POST, entity,
        Student.class).getBody();
  }

  @GetMapping("/results-get-students")
  public List<Student> getStudents() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("Passing-Header", "Aise vai aise......");
    Student student = new Student(1L, "D");

    HttpEntity<String> entity = new HttpEntity<String>(headers);
    return template.exchange("http://localhost:8081/student", HttpMethod.GET, entity,
        List.class).getBody();
  }


  @PutMapping("/results-put-student")
  public Student putStudent() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("Passing-Header", "Aise vai aise......");
    Student student = new Student(1L, "F");

    HttpEntity<Student> entity = new HttpEntity<Student>(student, headers);
    return template.exchange("http://localhost:8081/student-update", HttpMethod.PUT, entity,
        Student.class).getBody();
  }


  @PostMapping("/result-id-verification")
  public IdVerificationDto IdVerify(@RequestBody IdVerificationPostDto idVerificationPostDto) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("Passing-Header", "Aise vai aise......");
    Student student = new Student(1L, "D");

    HttpEntity<IdVerificationPostDto> entity =
        new HttpEntity<IdVerificationPostDto>(idVerificationPostDto, headers);

    return template.exchange("http://localhost:8081/student" + "/id-verification", HttpMethod.POST, entity,
        IdVerificationDto.class).getBody();
  }

}
