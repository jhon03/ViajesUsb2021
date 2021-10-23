package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.TipoDestino;

//creación de repositorio
public interface TipoDestinoRepository extends JpaRepository<TipoDestino, Long> {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws SQLException
	 * @author Anderson
	 */
	public TipoDestino findByCodigo(String codigo) throws SQLException;

	/**
	 * 
	 * @param codigo
	 * @param estado
	 * @return
	 * @throws SQLException
	 * @author Anderson
	 */
	public TipoDestino findByCodigoAndEstado(String codigo, String estado) throws SQLException;

}
