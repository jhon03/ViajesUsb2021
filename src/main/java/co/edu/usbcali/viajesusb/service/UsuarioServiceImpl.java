package co.edu.usbcali.viajesusb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.Usuario;
import co.edu.usbcali.viajesusb.repository.UsuarioRepository;

@Service
@Scope("singleton")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario findByLogin(String login) throws Exception {
		// TODO Auto-generated method stub

		Usuario usuario = null;
		usuario = usuarioRepository.findByLogin(login);
		return usuario;
	}

}
