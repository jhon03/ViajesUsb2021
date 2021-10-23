package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ClienteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9129772445621627163L;

	private long idClie;
	private String numeroIdentificacion;
	private String primerApellido;
	private String segundoApellido;
	private String nombre;
	private String telefono1;
	private String telefono2;
	private String correo;
	private String sexo;
	private Date fechaNacimiento;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;

	private Long idTiid;
	private String nombreTipoIdentificacion;
	private String codigoTipoIdentificacion;

}
