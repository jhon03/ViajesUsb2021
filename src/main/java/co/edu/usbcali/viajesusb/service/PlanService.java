package co.edu.usbcali.viajesusb.service;

import co.edu.usbcali.viajesusb.domain.Plan;
import co.edu.usbcali.viajesusb.dto.PlanDTO;

public interface PlanService {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws Exception
	 * @author Anderson
	 * @name: buscarPlanPorCodigo
	 */
	public Plan findByCodigo(String codigo) throws Exception;

	/**
	 * 
	 * @param planDTO
	 * @throws Exception
	 * @author Anderson
	 * @Name: Crear Plan
	 */
	public void crearPlan(PlanDTO planDTO) throws Exception;

}
