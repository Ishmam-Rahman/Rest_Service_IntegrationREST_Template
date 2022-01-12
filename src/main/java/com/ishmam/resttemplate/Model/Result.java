package com.ishmam.resttemplate.Model;


public class Result {
  private Long id;
  private String name;
  private Long mark;

  @Override
  public String toString() {
    return "Result{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", mark=" + mark +
        '}';
  }

  public Result() {
  }

  public Result(Long id, String name, Long total) {
    this.id = id;
    this.name = name;
    this.mark = total;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getMark() {
    return mark;
  }

  public void setMark(Long mark) {
    this.mark = mark;
  }
}
