package co.edu.usbcali.viajesusb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.viajesusb.domain.TipoDestino;

import co.edu.usbcali.viajesusb.service.TipoDestinoService;
import co.edu.usbcali.viajesusb.utils.Constantes;

// Ejemplo de la clase
@SpringBootTest
class TipoDestinoTest {

	@Autowired
	private TipoDestinoService tipoDestinoService;
	private TipoDestino tipoDestino = null;

	@Test
	@Transactional
	public void debeConsultarUnTipoDestinoPorCodigo() throws Exception {

		try {
			tipoDestino = tipoDestinoService.findByCodigo("PLAYA");

			System.out.println(tipoDestino.getNombre());

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
	}

	@Test
	@Transactional
	public void debeConsultarTipoDestinoPorCodigoAndEstado() throws Exception {

		try {
			tipoDestino = tipoDestinoService.findByCodigoAndEstado("BOSQU", Constantes.ACTIVO);

			System.out.println(tipoDestino.getNombre());

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
	}
}
