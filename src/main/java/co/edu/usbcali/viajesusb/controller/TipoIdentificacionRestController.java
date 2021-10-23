package co.edu.usbcali.viajesusb.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;
import co.edu.usbcali.viajesusb.mapper.TipoIdentificacionMapper;
import co.edu.usbcali.viajesusb.service.TipoIdentificacionService;

@RestController
@RequestMapping("/api")
public class TipoIdentificacionRestController {

	
	
	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;
	
	
	@Autowired
	private TipoIdentificacionMapper tipoIdentificacionMapper;
	
	
	@GetMapping("/getTipoIdentificacionPorCodigoAndEstado")
	public ResponseEntity<TipoIdentificacionDTO> consultarTipoIdentificacionPorCodigoAndEstado(@RequestParam("codigo") String codigo, @RequestParam("estado") String estado){
		
		try {
			TipoIdentificacion tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado(codigo, estado);
			return ResponseEntity.ok(tipoIdentificacionMapper.tipoIdentificacionToTipoIdentificacionDTO(tipoIdentificacion));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	

}
