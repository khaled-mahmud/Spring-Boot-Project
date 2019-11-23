package com.khaledmahmud.studentservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>{
 
    public List<Topic> findByCourseId(String id);
}