package co.edu.usbcali.viajesusb.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.Cliente;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;

import co.edu.usbcali.viajesusb.repository.ClienteRepository;
import co.edu.usbcali.viajesusb.utils.Constantes;
import co.edu.usbcali.viajesusb.utils.Utilities;

@Scope("singleton")
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;

	/**
	 * Description: consultar todos los clientes por estado, paginada y ordenado por
	 * número de identificacion
	 */
	@Override
	public Page<Cliente> findByEstadoOrderByNumeroIdentificacion(String estado, Pageable pageable) throws Exception {

		// TODO Auto-generated method stub

		if (estado == null || estado.trim().equals("")) {
			throw new Exception("debe ingresar un estado del  cliente válido");

		}

		if (estado.trim().length() > 1) {
			throw new Exception("No se puede ingresar más de un caracter");
		}

		Page<Cliente> pageCliente = null;

		pageCliente = clienteRepository.findByEstadoOrderByNumeroIdentificacion(estado, pageable);

		return pageCliente;
	}

	/**
	 * Description: consultar cliente por correo ignorando mayúsculas o minúsculas
	 */
	@Override
	public Cliente findByCorreoIgnoreCase(String correo) throws Exception {
		// TODO Auto-generated method stub

		
		if (correo == null || correo.trim().equals("")) {
			throw new Exception("Debe ingresar un correo electrónico válido");
		}

		if (correo.trim().length() > 100) {

			throw new Exception("Debe ingresar entre 0 y 100 carácteres");
		}

		if (Utilities.formatoCorreoValido(correo) == false) {
			throw new Exception("El formato de correo no es válido");
		}

		Cliente cliente = null;
		cliente = clienteRepository.findByCorreoIgnoreCase(correo);
		return cliente;
	}

	/**
	 * Description: consultar cliente por número de identificación usando like
	 */
	@Override
	public Cliente findByNumeroIdentificacionLike(String numeroIdentificacion) throws Exception {
		// TODO Auto-generated method stub

		if (numeroIdentificacion == null || numeroIdentificacion.trim().equals("")) {
			throw new Exception("debe ingresar un número de identificacion válido");

		}
		if (numeroIdentificacion.trim().length() > 15) {
			throw new Exception("El número ingresado es demasiado largo");
		}

		Cliente cliente = null;
		cliente = clienteRepository.findByNumeroIdentificacionLike(numeroIdentificacion);
		return cliente;
	}

	/**
	 * Description: consultar cliente por nombre ignorando mayúsculas
	 */
	@Override
	public Cliente findByNombreIgnoreCaseLike(String nombre) throws Exception {
		// TODO Auto-generated method stub

		if (nombre == null || nombre.trim().equals("")) {
			throw new Exception("debe ingresar un nombre válido");
		}
		if (nombre.trim().length() > 100) {
			throw new Exception("el nombre es demasiado largo");
		}

		Cliente cliente = null;
		cliente = clienteRepository.findByNombreIgnoreCaseLike(nombre);
		return cliente;
	}

	/**
	 * Descripcion: Consultar clientes por rango de fecha (Se debe pasar dos fechas
	 * y traer los clientes cuya fecha de nacimiento se encuentre entre el rango
	 * ingresado).
	 */
	@Override
	public List<Cliente> findByFechaNacimientoBetween(Date fechaInicio, Date fechaFin) throws Exception {
		// TODO Auto-generated method stub

		String fechaPattern = "\\d{1,2}-\\d{1,2}-\\d{4}";

		String mather = fechaPattern.formatted(fechaInicio);
		String mather2 = fechaPattern.formatted(fechaFin);

		if (fechaInicio == null || fechaInicio.toString().equals("") || fechaFin == null
				|| fechaFin.toString().equals("")) {

			throw new Exception("Debe ingresar una fecha válida");
		}

		if (mather.contentEquals(mather) == false || mather.contentEquals(mather2) == false) {
			throw new Exception("debe ingresar una fecha en formato válido");
		}
		List<Cliente> lstCliente = clienteRepository.findByFechaNacimientoBetween(fechaInicio, fechaFin);
		return lstCliente;
	}

	/**
	 * Description: Consultar total de clientes por estado.
	 */
	@Override
	public long countAndfindByEstado(String estado) throws Exception {
		// TODO Auto-generated method stub

		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado no es inválido");
		}

		Long lstCliente = clienteRepository.countAndfindByEstado(estado);
		return lstCliente;
	}

	/**
	 * Description: Consultar clientes por apellido (tener en cuenta los campos
	 * primer y segundo apellido)
	 * 
	 */
	@Override
	public List<Cliente> findByPrimerApellidoAndSegundoApellido(String primerApellido, String segundoApellido)
			throws Exception {
		// TODO Auto-generated method stub

		Pattern pattern = Pattern.compile("[a-zA-Z-123]");
		Matcher mather = pattern.matcher(primerApellido);
		Matcher mathersa = pattern.matcher(segundoApellido);

		if (primerApellido == null && segundoApellido == null
				|| primerApellido.trim().equals("") && segundoApellido.trim().equals("")) {
			throw new Exception("Debe ingresar primer y segundo apellido");
		}
		if (primerApellido == null || primerApellido.trim().equals("")) {

			throw new Exception("Debe un ingresar un primer apellido");
		}

		if (segundoApellido == null || segundoApellido.trim().equals("")) {
			throw new Exception("Debe ingresar un segundo apellido");
		}

		if (mather.find() == false || mathersa.find() == false) {
			throw new Exception("Debe ingresar apellidos válidos");
		}

		List<Cliente> cliente = clienteRepository.findByPrimerApellidoAndSegundoApellido(primerApellido,
				segundoApellido);

		return cliente;
	}

	@Override
	public Cliente crearCliente(ClienteDTO clienteDTO) throws Exception {
		// TODO Auto-generated method stub

		Cliente cliente = null;
		TipoIdentificacion tiid = null;

		/*
		  Pattern pattern =
		  Pattern.compile("([a-z0-9]+(\\\\.?[a-z0-9])*)+@(([a-z]+)\\\\.([a-z]+))+");
		 
		 Matcher mather = pattern.matcher(clienteDTO.getCorreo());
		 
*/
		// Se arma el destino

		cliente = new Cliente();

		cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());
		cliente.setPrimerApellido(clienteDTO.getPrimerApellido());
		cliente.setSegundoApellido(clienteDTO.getSegundoApellido());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setTelefono1(clienteDTO.getTelefono1());
		cliente.setTelefono2(clienteDTO.getTelefono2());
		cliente.setCorreo(clienteDTO.getCorreo());
		cliente.setSexo(clienteDTO.getSexo());
		cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
		cliente.setFechaCreacion(clienteDTO.getFechaCreacion());
		cliente.setUsuCreador(clienteDTO.getUsuCreador());
		cliente.setEstado(clienteDTO.getEstado());

		tiid = tipoIdentificacionService.findByCodigoAndEstado(clienteDTO.getCodigoTipoIdentificacion(),
				Constantes.ACTIVO);

		if (tiid == null || tiid.equals("")) {
			throw new Exception("El tipo de Identificacion" + clienteDTO.getCodigoTipoIdentificacion() + "No existe");
		}

		if (cliente.getNumeroIdentificacion() == null || cliente.getNumeroIdentificacion().equals("")) {
			throw new Exception("Debe ingresar un Número de Identificación válido");
		}

		if (cliente.getNumeroIdentificacion().length() > 15) {
			throw new Exception("El número de identificación es demasiado largo");
		}

		if (cliente.getPrimerApellido() == null || cliente.getPrimerApellido().equals("")) {
			throw new Exception("Debe ingresar un primer Apellido Válido");

		}

		if (cliente.getPrimerApellido().length() > 100) {
			throw new Exception("El apellido es demasiado largo");
		}
		if (cliente.getSegundoApellido() == null || cliente.getSegundoApellido().equals("")) {
			throw new Exception("Debe ingresar un segundo Apellido Válido");

		}

		if (cliente.getSegundoApellido().length() > 100) {
			throw new Exception("El apellido es demasiado largo");
		}

		if (clienteDTO.getNombre() == null || cliente.getNombre().equals("")) {
			throw new Exception("Debe ingresar nombre  Válido");

		}

		if (cliente.getNombre().length() > 100) {
			throw new Exception("El nombre es demasiado largo");
		}

		if (cliente.getTelefono1() == null || cliente.getTelefono1().equals("")) {
			throw new Exception("Debe un número de teléfono  válido");

		}

		if (cliente.getTelefono1().length() > 15) {
			throw new Exception("El número es demasiado largo");
		}
		if (cliente.getTelefono2() == null || cliente.getTelefono2().equals("")) {
			throw new Exception("Debe un número de teléfono  válido");

		}

		if (cliente.getTelefono2().length() > 15) {
			throw new Exception("El número es demasiado largo");
		}

		if (cliente.getCorreo() == null || cliente.getCorreo().equals("")) {
			throw new Exception("Debe ingresar un correo electrónico válido");

		}
		/*
		 * if(mather.find()== false) { throw new
		 * Exception("Formato de correo electrónico no válido"); }
		 */

		if (cliente.getCorreo().length() > 100) {
			throw new Exception("El correo electrónico es demasiado  demasiado largo");
		}

		if (cliente.getSexo() == null || cliente.getSexo().equals("")) {
			throw new Exception("Debe ingresar un género válido");
		}

		if (cliente.getSexo().length() > 1) {
			throw new Exception("No se permiten más de dos o más caracteres");
		}

		if (cliente.getEstado() == null || cliente.getEstado().equals("")) {
			throw new Exception("Debe ingresar un estado del cliente válido");
		}

		if (cliente.getEstado().length() > 1) {

			throw new Exception("No puede ingresar dos o más carácteres");
		}
		if (cliente.getUsuCreador() == null || cliente.getUsuCreador().equals("")) {
			throw new Exception("Debe ingresar usuario creador");
		}

		if (cliente.getUsuCreador().length() > 10) {

			throw new Exception("No puede ingresar  más de 10 carácteres");
		}
		
		/*
		if (mather.find() == false) {
			throw new Exception("El formato de correo no es válido");*/
		

		cliente.setTipoIdentificacion(tiid);

		clienteRepository.save(cliente);
		
		return cliente;
	}

	@Override
	public Cliente actualizarCliente(ClienteDTO clienteDTO) throws Exception {

		Cliente cliente = null;
		TipoIdentificacion tipoIdentificacion = null;

		// busco la existencia del cliente

		cliente = findById(clienteDTO.getIdClie());

		tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado(clienteDTO.getCodigoTipoIdentificacion(),
				Constantes.ACTIVO);

		if (tipoIdentificacion == null) {
			throw new Exception("El tipo de identificacion " + clienteDTO.getCodigoTipoIdentificacion() + "No existe");
		}

		cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());
		cliente.setPrimerApellido(clienteDTO.getPrimerApellido());
		cliente.setSegundoApellido(clienteDTO.getSegundoApellido());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setTelefono1(cliente.getTelefono1());
		cliente.setTelefono2(clienteDTO.getTelefono2());
		cliente.setCorreo(clienteDTO.getCorreo());
		cliente.setSexo(clienteDTO.getSexo());
		cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
		cliente.setFechaCreacion(clienteDTO.getFechaCreacion());
		cliente.setFechaModificacion(clienteDTO.getFechaModificacion());
		cliente.setUsuCreador(clienteDTO.getUsuCreador());
		cliente.setUsuModificador(clienteDTO.getUsuModificador());
		cliente.setEstado(clienteDTO.getEstado());

		cliente.setTipoIdentificacion(tipoIdentificacion);
		clienteRepository.save(cliente);
		
		return cliente;

	}

	@Override
	public void eliminarCliente(Long idClie) throws Exception {

		/*
		 * if (clienteDTO == null || clienteDTO.getIdClie() == null) {
		 * 
		 * throw new Exception("El id de destinod es obligatorio"); }
		 */
		Optional<Cliente> clienteBD = clienteRepository.findById(idClie);

		if (clienteBD == null || clienteBD.equals("")) {

			throw new Exception("El destino que va eliminar no existe");
		}

		if (clienteBD.isPresent()) {
			clienteRepository.delete(clienteBD.get());
		} else {
			throw new Exception("El destino no se encontró");
		}
	}

	@Override
	public Cliente findById(Long idClie) throws Exception {
		// TODO Auto-generated method stub

		if (idClie == null) {
			throw new Exception("Debe ingresar el id del Cliente");

		}

		if (!clienteRepository.findById(idClie).isPresent()) {
			throw new Exception("El destino con id:  " + idClie + "no existe");
		}
		return clienteRepository.findById(idClie).get();

	}

}
