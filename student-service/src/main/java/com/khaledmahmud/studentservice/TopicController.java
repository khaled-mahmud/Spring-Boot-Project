package com.khaledmahmud.studentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

  @Autowired
  private TopicService topicService;

  @RequestMapping("/students/{roll}/courses/{courseId}/topics")
  public List<Topic> getAllTopics(@PathVariable String courseId){
    return topicService.getAllTopics(courseId);
  }
  
  @RequestMapping("/students/{roll}/courses/{courseId}/topics/{id}")
  public Topic getTopic(@PathVariable String id){
    return topicService.getTopic(id);
  }

  
  @RequestMapping(method = RequestMethod.POST, value = "/students/{roll}/courses/{courseId}/topics")
  public void addTopic(@RequestBody Topic topic, @PathVariable String courseId){
    //course.setStudent(new Student(roll, "", ""));
    topic.setCourse(new Course(courseId, "", "", ""));
    topicService.addTopic(topic);
  }


  @RequestMapping(method = RequestMethod.PUT, value = "/students/{roll}/courses/{courseId}/topics/{id}")
  public void updateTopic(@RequestBody Topic topic, @PathVariable String courseId){
    //course.setStudent(new Student(roll, "", ""));
    topic.setCourse(new Course(courseId, "", "", ""));
    topicService.updateTopic(topic);
  }


  @RequestMapping(method = RequestMethod.DELETE, value = "/students/{roll}/courses/{courseId}/topics/{id}")
  public void deleteTopic(@PathVariable String id){
    topicService.deleteTopic(id);
  }

}

