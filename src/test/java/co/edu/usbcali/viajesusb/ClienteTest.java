package co.edu.usbcali.viajesusb;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.viajesusb.domain.Cliente;

import co.edu.usbcali.viajesusb.dto.ClienteDTO;

import co.edu.usbcali.viajesusb.repository.ClienteRepository;
import co.edu.usbcali.viajesusb.service.ClienteService;
import co.edu.usbcali.viajesusb.utils.Constantes;

@SpringBootTest
@Rollback(false)
class ClienteTest {

	private Cliente cliente = null;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteRepository clienteRepository;

	/*
	 * punto 2.
	 * 
	 * @author Anderson Description: Consultar todos los clientes por estado. Esta
	 * consulta debe ser paginada y ordenada de forma ascendente por numero de
	 * identificación
	 */
	@Test
	@Transactional
	void debeConsultarClientePorEstadoPaginado() {

		Page<Cliente> pageCliente = null;

		try {
			Pageable pageable = PageRequest.of(0, 3);

			pageCliente = clienteService.findByEstadoOrderByNumeroIdentificacion("A", pageable);
			for (Cliente cliente : pageCliente) {

				System.out.println(cliente.getNombre());
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	/**
	 * punto 3
	 * 
	 * @author Anderson Description: Consultar un cliente por correo electrónico.
	 *         Esta consulta debe ignorar las mayusculas y minúsculas.
	 */
	@Test
	@Transactional
	void debeConsultarClientePorCorreoIgnorandoMm() {

		try {
			cliente = clienteService.findByCorreoIgnoreCase("_-.-.___—–_._gon.rz365@gmail.com.mx");
			System.out.println(cliente.getNombre());
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}

	}

	/**
	 * @author Anderson Dwcription: punto 4. Consultar cliente por numero de
	 *         identificación, usando LIKE
	 */

	@Test
	@Transactional
	void debeConsultarClientePorNúmeroIdLike() {

		try {

			cliente = clienteService.findByNumeroIdentificacionLike("");
			System.out.println(cliente.getNombre());
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
	}

	/**
	 * @author Anderson Description: 5. Consultar cliente por nombre, * ignorando
	 *         Mayusculas y minúsculas, usando LIKE.OK
	 * 
	 **/

	@Test
	@Transactional
	void consultarClientePorNombre() {

		try {
			cliente = clienteService.findByNombreIgnoreCaseLike("");
			System.out.println(cliente.getNombre());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
	}

	// punto 6

	/**
	 * @author Anderson Description: Consultar clientes por rango de fecha (Se debe
	 *         pasar dos fechas y traer los clientes cuya fecha de nacimiento se
	 *         encuentre entre el rango ingresado). revisar
	 */

	@Test
	@Transactional
	void consultarClientesPorRangoFechaNacimiento() {

		Calendar fechaInicio = new GregorianCalendar(1991, 5, 30);

		Calendar fechaFin = new GregorianCalendar(2016, 12, 8);

		try {
			List<Cliente> lstCliente = clienteService.findByFechaNacimientoBetween(fechaInicio.getTime(),
					fechaFin.getTime());

			for (Cliente cliente : lstCliente) {
				System.out.println(cliente.getNombre());
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	/**
	 * @author Anderson Description: 8.Consultar total de clientes por estado.
	 */

	@Test
	@Transactional
	void consultarTotalCLientesPorEstado() {
		try {

			Long lstCliente = clienteService.countAndfindByEstado("");

			System.out.println(lstCliente);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @author Anderson punto 9. Description: Consultar clientes por tipo de
	 *         identificación. Debe de ser paginado
	 */

	@Test
	@Transactional
	void consultarClientesPorTipoIdentificacionPaginado() {

		Page<Cliente> pageCliente = null;

		try {
			Pageable pageable = PageRequest.of(0, 3);

			pageCliente = clienteRepository.findByTipoIdentificacion(1, pageable);

			for (Cliente cliente : pageCliente) {
				System.out.println(cliente.getNombre());
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	/**
	 * @author Anderson punto 10. Description: Consultar clientes por apellido
	 *         (tener en cuenta los campos primer y segundo apellido)
	 * 
	 **/

	@Test
	@Transactional
	void debeConsultarClientesPorApellidos() {

		try {

			List<Cliente> cliente = clienteService.findByPrimerApellidoAndSegundoApellido("HJGHJH", "hasdaZ");

			for (Cliente clientex : cliente) {
				System.out.println(clientex.getNombre());
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@Test
	@Transactional
	void debeCrearElClienteSamuel() {

		Calendar fechaNac = new GregorianCalendar(1990, 3, 15);

		try {

			ClienteDTO clienteeDTO = new ClienteDTO();

			clienteeDTO.setNumeroIdentificacion("222222222");
			clienteeDTO.setPrimerApellido("arcos");
			clienteeDTO.setSegundoApellido("velez");
			clienteeDTO.setNombre("Valeria");
			clienteeDTO.setTelefono1("3111119899");
			clienteeDTO.setTelefono2("3168111666");
			clienteeDTO.setCorreo("valery@hotmail.com");
			clienteeDTO.setSexo("F");
			clienteeDTO.setFechaNacimiento(fechaNac.getTime());
			clienteeDTO.setFechaCreacion(new Date());
			clienteeDTO.setEstado("A");
			clienteeDTO.setUsuCreador("JHOYOS");

			clienteeDTO.setCodigoTipoIdentificacion("PA");
			clienteeDTO.setNombreTipoIdentificacion("PASAPORTE");

			clienteService.crearCliente(clienteeDTO);

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}

	}

	@Test
	@Transactional
	void debeEliminarElClienteCOnstantino() {

		try {
			ClienteDTO clienteDTO = new ClienteDTO();
			clienteDTO.setIdClie(7L);

			clienteService.eliminarCliente(clienteDTO.getIdClie());

			System.out.println("Cliente eliminado sactifactoriamente");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Test
	@Transactional
	void debeBuscarCientePorId() {

		try {

			cliente = clienteService.findById(7L);

			System.out.println(cliente.getNombre());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Test
	@Transactional
	void debeActualizarElClienteDavidDanilo() {

		Calendar fechaNac = new GregorianCalendar(1990, 03, 29);

		try {

			ClienteDTO clienteDTO = new ClienteDTO();

			clienteDTO.setIdClie(5L);

			clienteDTO.setNumeroIdentificacion("11436758766");
			clienteDTO.setPrimerApellido("Hoyoss");
			clienteDTO.setSegundoApellido("Idrobo");
			clienteDTO.setNombre("David Danilooo");
			clienteDTO.setSexo("M");
			clienteDTO.setFechaNacimiento(fechaNac.getTime());
			clienteDTO.setFechaCreacion(new Date());
			clienteDTO.setFechaModificacion(new Date());
			clienteDTO.setUsuCreador("JHOYOS");

			clienteDTO.setUsuModificador("JHOYOSS");
			clienteDTO.setEstado(Constantes.ACTIVO);

			clienteDTO.setCodigoTipoIdentificacion("CE");
			clienteDTO.setNombreTipoIdentificacion("CEDULA EXTRANJERA");

			clienteService.actualizarCliente(clienteDTO);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
