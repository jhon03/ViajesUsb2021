package co.edu.usbcali.viajesusb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "plan")
public class Plan  {
    

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_plan" )
	private long idPlan;
	
	@Column(name = "codigo", nullable = false, unique = true, length = 5)
	private String codigo;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "descripcion_solicitud", length = 4)
	private String descripcionSolicitud;
	
	@Column(name = "cantidad_personas", nullable = false, length = 4)
	private long cantidadPersonas;
	
	@Column(name = "fecha_solicitud", nullable = false)
	private Date fechaSolicitud;
	
	@Column(name = "fecha_inicio_viaje")
	private Date fechaInicioViaje;
	
	@Column(name = "fecha_fin_viaje")
	private Date fechaFinViaje;
	
	@Column(name = "valor_total", nullable = false)
	private double valorTotal;
	
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	

	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Column(name = "usu_creador", nullable = false, length = 10)
	private String usuCreador;
	
	@Column(name = "usu_modificador", length = 10)
	private String usuModificador;
	
	@Column(name = "estado", nullable = false, length = 1)
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_clie")
	private Cliente idClie;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usua")
	private Usuario idUsua;

	public Plan() {
		// TODO Auto-generated constructor stub
	}

}
