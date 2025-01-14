package dao;

import java.sql.SQLException;
import java.util.List;

import models.Game;

public interface GameDaoInt {
	/**
	 * Obtenemos una lista de juegos por género
	 * @param genero
	 * @return - lista de juegos
	 */
	public List<Game> getByGenre(String genero) throws SQLException;
	
	/**
	 * Obtenemos una lista de juegos según la plataforma
	 * @param platform
	 * @return - lista de juegos
	 */
	public List<Game> getByPlatform(String platform) throws SQLException;
}
