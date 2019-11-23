package com.khaledmahmud.studentservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService{

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(String courseId){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findByCourseId(courseId).forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        return topicRepository.findById(id).get();
    }

	public void addTopic(Topic topic) {
        topicRepository.save(topic);
	}

	public void updateTopic(Topic topic) {

        topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
        topicRepository.deleteById(id);
	}

}