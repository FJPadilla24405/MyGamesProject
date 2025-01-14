package dao;

import java.sql.SQLException;
import java.util.List;

import models.Collection;

public interface CollectionDaoInt {
	/**
	 * Buscamos una entrada según la clave primaria (Clave compuesta), que la generaremos dentro de este método
	 * @param userId
	 * @param gameId
	 * @return - Entrada de la tabla cuya clave compuesta coincida con los datos por parámetro
	 * @throws SQLException
	 */
	Collection getByCompositeKey(int userId, int gameId) throws SQLException;
	
	/**
	 * Bucamos dentro de la clave compuesta, todas las entradas de un usuario en específico
	 * @param userId
	 * @return - Lista de entradas bajo el número de un usuario en específico
	 * @throws SQLException
	 */
	List<Collection> getByUserId(int userId) throws SQLException;
}
