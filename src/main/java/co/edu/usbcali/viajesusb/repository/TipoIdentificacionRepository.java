package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;

// creación de repositorio
public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Long> {

	// 1. Consultar todos los tipos de identificación por estado ordenados
	// alfabeticamente
	public List<TipoIdentificacion> findByEstadoOrderByCodigoAsc(String estado) throws SQLException;

	// public TipoIdentificacion findByCodigo(@Param("pCodigo") String codigo);

	public TipoIdentificacion findByCodigoAndEstado(String codigo, String estado) throws SQLException;
}
