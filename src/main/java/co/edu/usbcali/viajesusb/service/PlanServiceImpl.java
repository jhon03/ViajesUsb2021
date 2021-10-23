package co.edu.usbcali.viajesusb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.domain.Plan;
import co.edu.usbcali.viajesusb.domain.Usuario;
import co.edu.usbcali.viajesusb.dto.PlanDTO;
import co.edu.usbcali.viajesusb.repository.PlanRepository;

@Scope("singleton")
@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository planRepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private UsuarioService usuarioService;

	public PlanServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Plan findByCodigo(String codigo) throws Exception {
		// TODO Auto-generated method stub

		Plan plan = null;
		plan = planRepository.findByCodigo(codigo);
		return plan;
	}

	@Override
	public void crearPlan(PlanDTO planDTO) throws Exception {

		Plan plan = null;
		Cliente cliente = null;

		Usuario usuario = null;

		// se arma el plan

		plan = new Plan();

		plan.setCodigo(planDTO.getCodigo());
		plan.setNombre(planDTO.getNombre());
		plan.setDescripcionSolicitud(planDTO.getDescripcionSolicitud());
		plan.setCantidadPersonas(planDTO.getCantidadPersonas());
		plan.setFechaSolicitud(planDTO.getFechaSolicitud());
		plan.setFechaInicioViaje(planDTO.getFechaInicioViaje());
		plan.setFechaFinViaje(planDTO.getFechaFinViaje());
		plan.setValorTotal(planDTO.getValorTotal());
		plan.setFechaCreacion(planDTO.getFechaCreacion());
		plan.setUsuCreador(planDTO.getUsuCreador());
		plan.setEstado(planDTO.getEstado());

		cliente = clienteService.findByCorreoIgnoreCase(planDTO.getNumeroIdentificacionCliente());

		if (cliente == null || cliente.equals("")) {
			throw new Exception("El Cliente" + planDTO.getNumeroIdentificacionCliente() + "No existe");

		}

		usuario = usuarioService.findByLogin(planDTO.getIdentificacionUsuario());

		if (usuario == null || usuario.equals("")) {
			throw new Exception("El Usuario" + planDTO.getIdentificacionUsuario() + "No existe");

		}

		plan.setIdClie(cliente);
		plan.setIdUsua(usuario);

		planRepository.save(plan);

	}
}
