package co.edu.usbcali.viajesusb.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.edu.usbcali.viajesusb.domain.Cliente;

import co.edu.usbcali.viajesusb.dto.ClienteDTO;

public interface ClienteService {

	/**
	 * 
	 * @param estado
	 * @param pageable
	 * @return
	 * @throws Exception
	 * @author Anderson Description: Consultar todos los clientes por estado. Esta
	 *         consulta debe ser paginada y ordenada de forma ascendente por numero
	 *         de identificación
	 */
	public Page<Cliente> findByEstadoOrderByNumeroIdentificacion(String estado, Pageable pageable) throws Exception;

	/**
	 * 
	 * @param correo
	 * @return
	 * @throws Exception
	 * @author Anderson Description: Consultar un cliente por correo electrónico.
	 *         Esta consulta debe ignorar las mayusculas y minúsculas.
	 */
	public Cliente findByCorreoIgnoreCase(String correo) throws Exception;

	/**
	 * 
	 * @param numeroIdentificacion
	 * @return
	 * @throws Exception
	 * @author Anderson Descripcion: Consultar cliente por numero de identificación,
	 *         usando LIKE
	 */

	public Cliente findByNumeroIdentificacionLike(String numeroIdentificacion) throws Exception;

	/**
	 * 
	 * @param nombre
	 * @return
	 * @throws Exception
	 * @author Anderson Dexcription: Consultar cliente por nombre, ignorando
	 *         Mayusculas y minúsculas, usando LIKE.
	 */
	public Cliente findByNombreIgnoreCaseLike(String nombre) throws Exception;

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 * @throws Exception
	 * @author Anderson Description: Consultar clientes por rango de fecha (Se debe
	 *         pasar dos fechas y traer los clientes cuya fecha de nacimiento se
	 *         encuentre entre el rango ingresado).
	 */
	public List<Cliente> findByFechaNacimientoBetween(Date fechaInicio, Date fechaFin) throws Exception;

	/**
	 * 
	 * @param estado
	 * @return
	 * @throws Exception
	 * @author Anderson Description: Consultar total de clientes por estado.
	 * 
	 */
	long countAndfindByEstado(String estado) throws Exception;

	/**
	 * 
	 * @param primerApellido
	 * @param segundoApellido
	 * @return
	 * @throws Exception
	 * @author Anderson Description: Consultar clientes por apellido (tener en
	 *         cuenta los campos primer y segundo apellido)
	 * 
	 */
	public List<Cliente> findByPrimerApellidoAndSegundoApellido(String primerApellido, String segundoApellido)
			throws Exception;

	/**
	 * 
	 * @param destinoDTO
	 * @throws Exception
	 * @author Anderson
	 * @name: crear cliente
	 */
	public Cliente crearCliente(ClienteDTO clienteDTO) throws Exception;

	/**
	 * 
	 * @param idClie
	 * @return
	 * @throws Exception
	 * @name: buscar cliente por id
	 */
	public Cliente findById(Long idClie) throws Exception;

	/**
	 * 
	 * @param clienteDTO
	 * @throws Exception
	 * @name: EliminarCliente
	 */

	public void eliminarCliente(Long idClie) throws Exception;

	/**
	 * 
	 * @param clienteDTO
	 * @throws Exception
	 * @name: actualizaCliente
	 */
	public Cliente actualizarCliente(ClienteDTO clienteDTO) throws Exception;

}
