package co.edu.usbcali.viajesusb.service;

import java.util.List;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;

public interface TipoIdentificacionService {

	/**
	 * 
	 * @param estado
	 * @return ListTipoIdentificacion
	 * @throws Exception Description: Description: Consultar todos los tipos de
	 *                   identificación por estado ordenados alfabeticamente
	 */

	public List<TipoIdentificacion> findByEstadoOrderByCodigoAsc(String estado) throws Exception;

	/**
	 * 
	 * @param codigo
	 * @param estado
	 * @return
	 * @throws Exception Description: consultar tipo Identificación por código y
	 *                   estado
	 */
	public TipoIdentificacion findByCodigoAndEstado(String codigo, String estado) throws Exception;

}
