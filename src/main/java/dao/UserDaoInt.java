package dao;

import java.sql.SQLException;

import models.User;

public interface UserDaoInt {
	/**
	 * Busca un usuario por correo electrónico, que es único e irrepetible
	 * @param email
	 * @return - Usuario cuyo correo coincida con el proporcionado
	 * @throws SQLException
	 */
	User getByEmail(String email) throws SQLException;
	
	/**
	 * Buscamos a un usuario por ID específico
	 * @param id
	 * @return - Usuario encontrado con el ID proporcionado
	 * @throws SQLException
	 */
	User getById(int id) throws SQLException;
}
