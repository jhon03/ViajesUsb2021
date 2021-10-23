package co.edu.usbcali.viajesusb.service;



import co.edu.usbcali.viajesusb.domain.TipoDestino;

public interface TipoDestinoService {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	public TipoDestino findByCodigo(String codigo) throws Exception;

	/**
	 * 
	 * @param codigo
	 * @param estado
	 * @return
	 * @throws Exception
	 * @author Anderson
	 */
	public TipoDestino findByCodigoAndEstado(String codigo, String estado) throws Exception;

}
