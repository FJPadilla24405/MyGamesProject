package dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import jakarta.persistence.Query;
import models.Game;

public class GameDaoImpl extends CommonDaoImpl<Game> implements GameDaoInt {
	private Session session;
	
	public GameDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> getByGenre(String genero) throws SQLException {
		if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		
		Query query = session.createQuery("SELECT g FROM Game g WHERE genres LIKE :genero", Game.class);
		
		query.setParameter("genero", genero);
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Game> getByPlatform(String plataforma) throws SQLException {
		if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		
		Query query = session.createQuery("SELECT g FROM Game g WHERE platforms LIKE :plataforma", Game.class);
		
		query.setParameter("plataforma", plataforma);
		
		return query.getResultList();
	}

}
