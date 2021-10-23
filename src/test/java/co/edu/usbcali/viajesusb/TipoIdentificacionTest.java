package co.edu.usbcali.viajesusb;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;

import co.edu.usbcali.viajesusb.service.TipoIdentificacionService;

@SpringBootTest

class TipoIdentificacionTest {

	@Autowired
	private TipoIdentificacion tipoIdentificacion;

	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;
	/*
	 * 1. Consultar todos los tipos de identificación por estado ordenados
	 * alfabeticamente.
	 */

	@Test
	@Transactional
	void consultarTipoIdentificacionOrdenadoAlfabeticamente() {

		try {

			List<TipoIdentificacion> lstTipoIdentificacion = tipoIdentificacionService
					.findByEstadoOrderByCodigoAsc("AA");

			for (TipoIdentificacion tiid : lstTipoIdentificacion) {
				System.out.println(tiid.getCodigo());

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			// e.printStackTrace();

		}
	}

	/* 7. Consultar tipo de identificación por código y estado. */

	@Test
	@Transactional
	void debeConsultarTipoIdentificacionPorCodigoAndEstado() {

		try {
			tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado("", "");

			System.out.println(tipoIdentificacion.getNombre());
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}

	}
}
