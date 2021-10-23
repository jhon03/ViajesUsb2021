package co.edu.usbcali.viajesusb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;

import co.edu.usbcali.viajesusb.repository.TipoIdentificacionRepository;

@Scope("singleton")
@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {

	@Autowired
	private TipoIdentificacionRepository tipoIdentificacionRepository;

	/**
	 * Description: Consulta Tipos de Identificacion por Estado ordenados por código
	 * en orden ascendente
	 */
	@Override
	public List<TipoIdentificacion> findByEstadoOrderByCodigoAsc(String estado) throws Exception {
		// TODO Auto-generated method stub

		if (estado == null || estado.trim().equals("")) {
			throw new Exception("debe ingresar un estado de tipo identificacion válido");
		}

		if (estado.getBytes().length > 1) {
			throw new Exception("numero de caracteres inválido");
		}
		List<TipoIdentificacion> lstTipoIdentificacion = tipoIdentificacionRepository
				.findByEstadoOrderByCodigoAsc(estado);

		return lstTipoIdentificacion;
	}

	/**
	 * Description: consulta Tipo Identificación por Código y Estado
	 */
	@Override
	public TipoIdentificacion findByCodigoAndEstado(String codigo, String estado) throws Exception {
		// TODO Auto-generated method stub

		if (codigo == null && estado == null || codigo.trim().equals("") || estado.trim().equals("")) {
			throw new Exception("Debe Ingresar un codigo y estado válido");
		}

		TipoIdentificacion tipoIdentificacion = null;
		tipoIdentificacion = tipoIdentificacionRepository.findByCodigoAndEstado(codigo, estado);

		return tipoIdentificacion;

	}

}
