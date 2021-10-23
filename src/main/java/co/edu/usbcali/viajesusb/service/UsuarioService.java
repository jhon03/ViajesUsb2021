package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;

import co.edu.usbcali.viajesusb.domain.Usuario;

public interface UsuarioService {

	/**
	 * 
	 * @param login
	 * @return
	 * @throws SQLException
	 * @author Anderson
	 * @Name: Buscar usuario por Login
	 */
	public Usuario findByLogin(String login) throws Exception;

}
