package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Class: TipoDestinoDTO
 * 
 * @author Anderson Copyright: USB
 *
 */

@Data
public class TipoDestinoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8203322629166546833L;

	private Long idTide;
	private String codigo;
	private String nombre;
	private String descripcion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;

}
