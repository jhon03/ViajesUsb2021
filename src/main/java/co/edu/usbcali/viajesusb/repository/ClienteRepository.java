package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.Cliente;

//creación de repositorio
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	/*
	 * 2. Consultar todos los clientes por estado. Esta consulta debe ser paginada y
	 * ordenada de forma ascendente por numero de identificación_
	 */

	public Page<Cliente> findByEstadoOrderByNumeroIdentificacion(String estado, Pageable pageable) throws SQLException;

	// 3.

	public Cliente findByCorreoIgnoreCase(String correo) throws SQLException;

	// 4. Consultar cliente por número de identificación usando like.

	public Cliente findByNumeroIdentificacionLike(String numeroIdentificacion) throws SQLException;

	// punto 5.
	public Cliente findByNombreIgnoreCaseLike(String nombre) throws SQLException;

	// punto 6.

	public List<Cliente> findByFechaNacimientoBetween(Date fechaInicio, Date fechaFin) throws SQLException;

	// punto 8.

	long countAndfindByEstado(String estado) throws SQLException;

	// punto 9.

	Page<Cliente> findByTipoIdentificacion(Integer idTiid, Pageable pageable) throws SQLException;

	// punto 10.

	public List<Cliente> findByPrimerApellidoAndSegundoApellido(String primerApellido, String segundoApellido)
			throws SQLException;
}
