package dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import jakarta.persistence.Query;
import models.User;

public class UserDaoImpl extends CommonDaoImpl<User> implements UserDaoInt {
	private Session session;
	
	public UserDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public User getByEmail(String email) throws SQLException {
		if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		
		Query query = session.createQuery("SELECT u FROM User u WHERE email = :email", User.class).setParameter("email", email);
		return (User)query.getSingleResult();
	}

	@Override
	public User getById(int id) throws SQLException {
		if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		
		Query query = session.createQuery("SELECT u FROM User u WHERE id = :id", User.class).setParameter("id", id);
		return (User)query.getSingleResult();
	}
	

}
