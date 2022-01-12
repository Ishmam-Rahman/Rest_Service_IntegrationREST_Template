package com.ishmam.resttemplate.Controller;

import com.ishmam.resttemplate.Model.Student;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  static List<Student> students = new ArrayList<>();

  static {
    students.add(new Student(1L, "A"));
    students.add(new Student(2L, "B"));
    students.add(new Student(3L, "C"));
  }
  public StudentController() {
  }

  @GetMapping("/student")
  public List<Student> getStudent(){
    return students;
  }

  @GetMapping("/student/id/{id}")
  public Student getByid(@PathVariable Long id){
    return students.stream().filter(student -> student.getId().equals(id)).findAny().orElse(null);
  }

  @PostMapping("/student-create")
  public Student create(HttpServletRequest request, @RequestBody Student student){

    String requestHeader = request.getHeader("Passing-Header");
    System.out.println(requestHeader);
    students.add(student);
    return student;
  }

  @PutMapping("/student-update")
  public Student update(HttpServletRequest request, @RequestBody Student student){
    String userAgent = request.getHeader("user-agent");
    return students.stream().filter(student1 -> student1.getId().equals(student.getId())).findFirst().map(student1 -> {
      student1.setName(student.getName());
      return student1;
    }).get();
  }

  @DeleteMapping("/student-delete/{id}")
  public String delete(@PathVariable Long id){
    students.removeIf(student -> student.getId().equals(id));
    return "Ok";
  }
}
