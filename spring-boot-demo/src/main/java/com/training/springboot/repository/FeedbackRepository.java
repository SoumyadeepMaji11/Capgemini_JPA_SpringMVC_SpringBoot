package com.training.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springboot.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{

}
