package co.edu.usbcali.viajesusb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import co.edu.usbcali.viajesusb.domain.TipoDestino;

import co.edu.usbcali.viajesusb.repository.TipoDestinoRepository;

@Scope("singleton")
@Service
public class TipoDestinoServiceImpl implements TipoDestinoService {

	@Autowired
	private TipoDestinoRepository tipoDestinoRepository;

	// TODO Auto-generated constructor stub

	@Override
	public TipoDestino findByCodigo(String codigo) throws Exception {

		if (codigo == null || codigo.trim().equals("")) {

			throw new Exception("debe ingresar un código de tipo de destino válido");

		}
		if (codigo.trim().length() > 5) {

			throw new Exception("El codigo no puede tener más de 5 carácteres");
		}

		// TODO Auto-generated method stub
		TipoDestino tipoDestino = null;
		tipoDestino = tipoDestinoRepository.findByCodigo(codigo);
		return tipoDestino;
	}

	@Override
	public TipoDestino findByCodigoAndEstado(String codigo, String estado) throws Exception {
		// TODO Auto-generated method stub

		TipoDestino tipoDestino = null;
		tipoDestino = tipoDestinoRepository.findByCodigoAndEstado(codigo, estado);

		return tipoDestino;
	}

}
