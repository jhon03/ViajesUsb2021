package co.edu.usbcali.viajesusb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;
import co.edu.usbcali.viajesusb.mapper.TipoDestinoMapper;
import co.edu.usbcali.viajesusb.service.TipoDestinoService;

@RestController
@RequestMapping("/api")
public class TipoDestinoRestController {

	@Autowired
	private TipoDestinoService tipoDestinoService;
	
	
	@Autowired
	private TipoDestinoMapper tipoDestinoMapper;
	
	/**
	 * 
	 * @param codigo
	 * @return
	 * @author Anderson
	 */
	@GetMapping("/getTipoDestinoPorCodigo")
	public ResponseEntity<TipoDestinoDTO> consultarTipoDestinoPorCodigo(@RequestParam("codigo")String codigo){
		
	try {
		
		TipoDestino tipoDestino = tipoDestinoService.findByCodigo(codigo);
		return ResponseEntity.ok(tipoDestinoMapper.tipoDestinoToTipoDestinoDTO(tipoDestino));

	} catch (Exception e) {
		// TODO: handle exception

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	}
	
	/**
	 * 
	 * @param codigo
	 * @param estado
	 * @return
	 * @author Anderson
	 */
	@GetMapping("/getTipoDestinoPorCodigoAndEstado")
    public ResponseEntity<TipoDestinoDTO> consultarTipoDestinoCodigoANDEstado(@RequestParam("codigo") String codigo, @RequestParam("estado") String estado){
    	
    	try {
			TipoDestino tipoDestino = tipoDestinoService.findByCodigoAndEstado(codigo, estado);
			return ResponseEntity.ok(tipoDestinoMapper.tipoDestinoToTipoDestinoDTO(tipoDestino));
		} catch (Exception e) {
			// TODO: handle exception
			
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    	
    }
	}

	


