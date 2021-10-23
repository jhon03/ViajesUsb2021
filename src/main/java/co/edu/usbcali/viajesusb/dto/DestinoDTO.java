package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Class: DestinoDTO
 * 
 * @author Anderson
 *
 */

@Data
public class DestinoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7366225104227032107L;

	private Long idDest;
	private String codigo;
	private String nombre;
	private String descripcion;
	private String tierra;
	private String aire;
	private String mar;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;

	private Long idTide;
	private String nombreTipoDestino;
	private String codigoTipoDestino;

}
