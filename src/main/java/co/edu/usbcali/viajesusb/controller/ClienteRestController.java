package co.edu.usbcali.viajesusb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.mapper.ClienteMapper;
import co.edu.usbcali.viajesusb.service.ClienteService;
import co.edu.usbcali.viajesusb.service.TipoIdentificacionService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

	
	@Autowired
	private ClienteService clienteService;
	
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	
	@Autowired 
	private TipoIdentificacionService tipoIdentificacionService;
	
	@PostMapping("/crearCliente")
	public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO clienteDTO){
		
		try {
			Cliente cliente = clienteService.crearCliente(clienteDTO);
			return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));
		} catch (Exception e) {
			// TODO: handle exception
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping("/eliminarCliente/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable("id") Long idClie){
		
		try {
			
			clienteService.eliminarCliente(idClie);
			return ResponseEntity.ok("Cliente eliminado sactisfactoriamente");
		} catch (Exception e) {
			// TODO: handle exception
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
 @PutMapping("/actualizarCliente")
 public ResponseEntity<?> actualizarCliente(@RequestBody ClienteDTO clienteDTO){
	 
	 try {
		TipoIdentificacion tipoIdentidicacion =  tipoIdentificacionService.findByCodigoAndEstado(clienteDTO.getCodigoTipoIdentificacion(),clienteDTO.getEstado());
	
		Cliente cliente = clienteService.actualizarCliente(clienteDTO);
	    return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));
	
	 } catch (Exception e) {
		// TODO: handle exception
		 
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
 }
	}
	
	
