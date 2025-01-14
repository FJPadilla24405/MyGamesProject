package dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import jakarta.persistence.Query;
import models.Collection;
import models.CollectionId;

public class CollectionDaoImpl extends CommonDaoImpl<Collection> implements CollectionDaoInt {
	private Session session;
	
	public CollectionDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Collection getByCompositeKey(int userId, int gameId) throws SQLException {
		if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		
		Query query = session.createQuery("SELECT c FROM Collection c WHERE id = :id", Collection.class).setParameter("id", new CollectionId(userId, gameId));

		return (Collection)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Collection> getByUserId(int userId) throws SQLException {
		if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		Query query = session.createQuery("SELECT c FROM Collection c WHERE id.userId = :id", Collection.class).setParameter("id", userId);
		
		return query.getResultList();
	}

}
