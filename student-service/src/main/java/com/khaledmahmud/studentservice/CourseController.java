package com.khaledmahmud.studentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

  @Autowired
  private CourseService courseService;

  @RequestMapping("/students/{roll}/courses")
  public List<Course> getAllCourses(@PathVariable String roll){
    return courseService.getAllCourses(roll);
  }
  
  @RequestMapping("/students/{roll}/courses/{id}")
  public Course getCourse(@PathVariable String id){
    return courseService.getCourse(id);
  }

  
  @RequestMapping(method = RequestMethod.POST, value = "/students/{roll}/courses")
  public void addCourse(@RequestBody Course course, @PathVariable String roll){
    course.setStudent(new Student(roll, "", ""));
    courseService.addCourse(course);
  }


  @RequestMapping(method = RequestMethod.PUT, value = "/students/{roll}/courses/{id}")
  public void updateCourse(@RequestBody Course course, @PathVariable String roll){
    course.setStudent(new Student(roll, "", ""));
    courseService.updateCourse(course);
  }


  @RequestMapping(method = RequestMethod.DELETE, value = "/students/{roll}/courses/{id}")
  public void deleteCourse(@PathVariable String id){
    courseService.deleteCourse(id);
  }

}

