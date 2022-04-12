package com.training.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedback_id;
	
	private String feedback_test;

	public Feedback() {
	}

	public int getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	public String getFeedback_test() {
		return feedback_test;
	}

	public void setFeedback_test(String feedback_test) {
		this.feedback_test = feedback_test;
	}
	
	
}
