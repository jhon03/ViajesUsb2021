package co.edu.usbcali.viajesusb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.viajesusb.domain.Usuario;
import co.edu.usbcali.viajesusb.service.UsuarioService;

@SpringBootTest
class UsuarioTest {

	private Usuario usuario = null;

	@Autowired
	private UsuarioService usuarioService;

	@Test
	@Transactional
	void debeConsultarUserLogin() {

		try {

			usuario = usuarioService.findByLogin("CLOPEZ");
			System.out.println(usuario.getNombre());
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
	}

}
