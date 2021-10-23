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

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.mapper.DestinoMapper;
import co.edu.usbcali.viajesusb.service.DestinoService;
import co.edu.usbcali.viajesusb.service.TipoDestinoService;

@RestController
@RequestMapping("/api")
public class DestinoRestController {

	@Autowired
	private DestinoService destinoService;
	
	@Autowired
	private DestinoMapper destinoMapper; 
	
	@Autowired
	private TipoDestinoService tipoDestinoService;
	
	private TipoDestino tipoDestino = null;
	
	@PostMapping("/guardarDestino")
	public 	ResponseEntity<DestinoDTO> guardarDestino(@RequestBody DestinoDTO destinoDTO) {
		
		try {
			
			Destino destino = destinoService.guardarDestino(destinoDTO);
			return ResponseEntity.ok(destinoMapper.destinoToDestinoDTO(destino));
		} catch (Exception e) {
			// TODO: handle exception
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
		@DeleteMapping("/eliminarDestino/{id}")
		public ResponseEntity<?> eliminarDestino(@PathVariable("id") Long id){
			
			try {
				destinoService.eliminarDestino(id);
				return ResponseEntity.ok("Se eliminó sactisfactoriamente");
			} catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		
		@PutMapping("/actualizarDestino")
		public ResponseEntity<?> actualizarDestino(@RequestBody DestinoDTO destinoDTO){
			
			
			try {
				TipoDestino tipoDestino = tipoDestinoService.findByCodigo(destinoDTO.getCodigoTipoDestino());
				
				
				Destino destino = destinoService.actualizarDestino(destinoDTO);
				return ResponseEntity.ok(destinoMapper.destinoToDestinoDTO(destino));
				
			} catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
	
	}
