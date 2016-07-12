package hcmuaf.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hcmuaf.edu.vn.dao.FeedBackDAO;
import hcmuaf.edu.vn.model.Feedback;

@Transactional
@Service
public class FeedBackServicesImpl implements FeedBackServices{
	@Autowired
	FeedBackDAO feedBackDAO;
	@Override
	public void addFeedBack(Feedback feedBack) {
		feedBackDAO.addFeedBack(feedBack);
	}

	@Override
	public Feedback getFeedBack(int feedBackId) {
		return feedBackDAO.getFeedBack(feedBackId);
	}

	@Override
	public List<Feedback> getListFeedback() {
		return feedBackDAO.getListFeedback();
	}

	@Override
	public void deleteFeedbackById(int id) {
		feedBackDAO.deleteFeedbackById(id);
	}

}
