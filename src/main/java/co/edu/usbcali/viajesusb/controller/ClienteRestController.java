package co.edu.usbcali.viajesusb.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import co.edu.usbcali.viajesusb.mapper.ClienteMapper;
import co.edu.usbcali.viajesusb.service.ClienteService;
import co.edu.usbcali.viajesusb.service.TipoIdentificacionService;
import co.edu.usbcali.viajesusb.utils.Constantes;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteMapper clienteMapper;

	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;

	
	/**
	 * 
	 * @param clienteDTO
	 * @return
	 * @Name: crear cliente
	 * @author Anderson
	 */
	@PostMapping("/crearCliente")
	public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO clienteDTO) {

		try {
			Cliente cliente = clienteService.crearCliente(clienteDTO);
			return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));
		} catch (Exception e) {
			// TODO: handle exception

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	/**
	 * 
	 * @param idClie
	 * @return
	 * @author Anderson
	 */
	@DeleteMapping("/eliminarCliente/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable("id") Long idClie) {

		try {

			clienteService.eliminarCliente(idClie);
			return ResponseEntity.ok("Cliente eliminado sactisfactoriamente");
		} catch (Exception e) {
			// TODO: handle exception

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * 
	 * @param clienteDTO
	 * @return
	 * @author Anderson
	 * @throws Exception 
	 */
	@PutMapping("/actualizarCliente")
	public ResponseEntity<?> actualizarCliente(@RequestBody ClienteDTO clienteDTO)  {
       
		


		try {
			
		    TipoIdentificacion tipoIdentificacion = tipoIdentificacionService
					.findByCodigoAndEstado(clienteDTO.getCodigoTipoIdentificacion(), Constantes.ACTIVO);

		
			Cliente cliente = clienteService.actualizarCliente(clienteDTO);
			return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));

		} catch (Exception e) {
			// TODO: handle exception

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
@GetMapping("/getEstadoOrderByNumIdentificacion")
public ResponseEntity<ClienteDTO> consultarClientePorEstadoOrderNumIdentificacion(@RequestParam("estado") String estado, @RequestParam("pageable") Pageable pageable  ){
	
	
	try {
		Cliente cliente =  (Cliente) clienteService.findByEstadoOrderByNumeroIdentificacion(estado, pageable);
		return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));
	} catch (Exception e) {
		// TODO: handle exception
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}

@GetMapping("/getEstadoAndPaginado")
public ResponseEntity<ClienteDTO> consultarClientePorEstadoAndPaginado(@RequestParam("estado") String estado, @RequestParam("pageable") Pageable pageable  ){
	
	
	
	try {
		
 
		Cliente  cliente =  (Cliente) clienteService.findByEstadoOrderByNumeroIdentificacion(estado, pageable);
		return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));
	} catch (Exception e) {
		// TODO: handle exception
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}

@GetMapping("/getnumIdentificacion")
public ResponseEntity<ClienteDTO> consultarClientePorNumoIdentificacion(@RequestParam("numeroIdentificacion") String numeroIdentificacion){
	
	try {
		Cliente cliente = clienteService.findByNumeroIdentificacionLike(numeroIdentificacion);
		return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));
	} catch (Exception e) {
		// TODO: handle exception
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}

@GetMapping("/getNombre")
public ResponseEntity<ClienteDTO> consultarClientePorNombre(@RequestParam("nombre") String nombre){
	
	try {
		Cliente cliente = clienteService.findByNombreIgnoreCaseLike(nombre);
		return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));
	} catch (Exception e) {
		// TODO: handle exception
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}

@GetMapping("/getIdClie")
public ResponseEntity<ClienteDTO> consultarClientePorId(@RequestParam("idClie") Long idClie){
	
	try {
		Cliente cliente = clienteService.findById(idClie);
		return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));
	} catch (Exception e) {
		// TODO: handle exception
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}

@GetMapping("/getCorreo")
public ResponseEntity<ClienteDTO> consultarPorCorreo(@RequestParam("correo") String correo){
	
	try {
		Cliente cliente = clienteService.findByCorreoIgnoreCase(correo);
		return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));
	} catch (Exception e) {
		// TODO: handle exception
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
}



