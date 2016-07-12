package hcmuaf.edu.vn.service;

import java.util.List;

import hcmuaf.edu.vn.entity.Feedback;

public interface FeedBackServices {
	public void addFeedBack(Feedback feedBack);

	public Feedback getFeedBack(int feedBackId);

	public List<Feedback> getListFeedback();
	
	public void deleteFeedbackById(int id);
}
