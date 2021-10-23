package co.edu.usbcali.viajesusb.service;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;

public interface DestinoService {

	/**
	 * @title: GuardarDestino
	 * @descripción: guarda un destino dado un DTO
	 * @param destinoDTO
	 * @throws Exception
	 * @author Anderson
	 */
	public Destino guardarDestino(DestinoDTO destinoDTO) throws Exception;

	public Destino findById(Long idDest) throws Exception;

	public Destino actualizarDestino(DestinoDTO destinoDTO) throws Exception;

	public void eliminarDestino(Long idDest) throws Exception;
}
