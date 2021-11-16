package co.edu.usbcali.viajesusb;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.service.DestinoService;
import co.edu.usbcali.viajesusb.utils.Constantes;

@SpringBootTest
@Rollback(false)
class DestinoTest {

	Destino destino = null;

	@Autowired
	private DestinoService destinoService;

	@Test
	@Transactional
	void debeGuardarElDestinoSanAndres() {

		try {

			DestinoDTO destinoDTO = new DestinoDTO();

			destinoDTO.setAire(Constantes.SI);
			destinoDTO.setTierra(Constantes.NO);
			destinoDTO.setMar(Constantes.NO);
			destinoDTO.setNombre("Medellin");
			destinoDTO.setCodigo("CULTU");
			destinoDTO.setDescripcion("capital salsera");
			destinoDTO.setEstado("AA");
			destinoDTO.setFechaCreacion(new Date());
			destinoDTO.setUsuCreador("CLOPEZ");

			destinoDTO.setCodigoTipoDestino("CULTU");
			destinoDTO.setNombreTipoDestino("CULTURAL");

			destinoService.guardarDestino(destinoDTO);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Test
	@Transactional
	void debeActualizarElDestinoSanAndres() {

		try {
			
			DestinoDTO destinoDTO = new DestinoDTO();
			destinoDTO.setIdDest(9L);
			destinoDTO.setAire(Constantes.SI);
			destinoDTO.setTierra(Constantes.NO);
			destinoDTO.setMar(Constantes.SI);

			destinoDTO.setCodigo("Cart");
			destinoDTO.setNombre("CARTAGENA");
			destinoDTO.setDescripcion("prueba naturaleza y aire");
			destinoDTO.setEstado(Constantes.ACTIVO);
			destinoDTO.setFechaCreacion(new Date());
			destinoDTO.setFechaModificacion(new Date());
			destinoDTO.setUsuCreador("CLOPEZ");
			destinoDTO.setUsuModificador("CLOPEZ");

			destinoDTO.setCodigoTipoDestino("PLAYA");
			destinoDTO.setNombreTipoDestino("PLAYA Y MAR");

			destinoService.actualizarDestino(destinoDTO);

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
	}

	@Test
	@Transactional
	void debeEliminarElDestinoCartagena() {

		try {
			DestinoDTO destinoDTO = new DestinoDTO();
			destinoDTO.setIdDest(4L);

			destinoService.eliminarDestino(destinoDTO.getIdDest());
		

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@Test
	@Transactional
	void debeBuscarDestinoPorId() {

		try {

			destino = destinoService.findById(3L);

			System.out.println(destino.getNombre());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
