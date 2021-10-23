package co.edu.usbcali.viajesusb;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.viajesusb.domain.Plan;
import co.edu.usbcali.viajesusb.dto.PlanDTO;
import co.edu.usbcali.viajesusb.service.PlanService;

@SpringBootTest
@Rollback(false)
class PlanTestt {

	private Plan plan = null;

	@Autowired
	private PlanService planService;

	@Test
	@Transactional
	void debeConsultarPlanPorCodigo() {

		try {

			plan = planService.findByCodigo("FAMI");
			System.out.println(plan.getNombre());

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}

	}

	@Test
	@Transactional
	void debeCrearUnPlan() {

		try {

			PlanDTO planDTO = new PlanDTO();

			planDTO.setCodigo("VACVE");
			planDTO.setNombre("VACACIONES DE VERANO");
			planDTO.setCantidadPersonas(4L);
			planDTO.setDescripcionSolicitud("almuerzo y cena incluidos");
			planDTO.setFechaSolicitud(new Date());
			planDTO.setValorTotal(300000);
			planDTO.setFechaCreacion(new Date());
			planDTO.setUsuCreador("JHOYOS");
			planDTO.setEstado("A");

			planDTO.setNumeroIdentificacionCliente("1112469726");
			planDTO.setNombreCliente("Jhon Anderson");

			planDTO.setIdentificacionUsuario("1151946203");
			planDTO.setLoginUsuario("CLOPEZ");

			planService.crearPlan(planDTO);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
