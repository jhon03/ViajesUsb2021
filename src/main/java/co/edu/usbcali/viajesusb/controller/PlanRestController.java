package co.edu.usbcali.viajesusb.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import co.edu.usbcali.viajesusb.service.PlanService;

@RestController
@RequestMapping("/api")
public class PlanRestController {
	
	private PlanService planService;
	
	//private PlanMapper planMapper;
/*@GetMapping("/getBuscarPorCodigo")
public ResponseEntity<PlanDTO> consultarPorCodigo(@RequestParam("codigo") String codigo){

	try {
		
		Plan plan = planService.findByCodigo(codigo);
		//return ResponseEntity.ok(planMapper)
	} catch (Exception e) {
		// TODO: handle exception
	}*/
	
}


