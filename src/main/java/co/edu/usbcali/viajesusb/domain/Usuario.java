package co.edu.usbcali.viajesusb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usua")
	private long id_usua;
	
	@Column(name = "login", nullable = false, length = 10)
	private String login;
	
	@Column(name = "password", nullable = false, length = 50)
	private String password;
	

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "identificacion", nullable = false, length = 15, unique = true)
	private long identificacion;
	
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion", nullable = true)
	private Date fechaModificacion;
	
	@Column(name = "usu_creador", nullable = false)
	private String usuCreador;
	
	@Column(name = "usu_modificador", nullable = true)
	private String usuModificador;
	
	@Column(name = "estado", nullable = false, length = 1)
	private String Estado;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

}
