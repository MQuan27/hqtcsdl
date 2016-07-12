package hcmuaf.edu.vn.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hcmuaf.edu.vn.model.Feedback;

@Repository
public class FeedBackDAOImpl implements FeedBackDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addFeedBack(Feedback feedBack) {
		sessionFactory.getCurrentSession().save(feedBack);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public Feedback getFeedBack(int feedBackId) {
		return (Feedback) sessionFactory.getCurrentSession()
				.createQuery("FROM Feedback us WHERE us.feedbackId=:id")
				.setInteger("id", feedBackId).uniqueResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> getListFeedback() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Feedback.class).list();
	}

	public void deleteFeedbackById(int id) {
		sessionFactory.getCurrentSession()
				.createQuery("DELETE FROM Feedback fb WHERE fb.feedbackId=:id")
				.setInteger("id", id).executeUpdate();
	}
}
