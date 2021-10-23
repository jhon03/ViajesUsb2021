package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TipoIdentificacionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2690546921274388309L;

	private Integer idTiid;
	private String codigo;
	private String nombre;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;

}
