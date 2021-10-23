package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PlanDTO implements Serializable {

	/**
	 * @Class: PlanDTO
	 * @author Anderson
	 */
	private static final long serialVersionUID = -8662520000174818986L;

	private long idPlan;
	private String codigo;
	private String nombre;
	private String descripcionSolicitud;
	private long cantidadPersonas;
	private Date fechaSolicitud;
	private Date fechaInicioViaje;
	private Date fechaFinViaje;
	private double valorTotal;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;

	private Long idClie;
	private String nombreCliente;
	private String numeroIdentificacionCliente;

	private Long idUsua;
	private String loginUsuario;
	private String IdentificacionUsuario;

}
