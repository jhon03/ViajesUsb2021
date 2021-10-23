package co.edu.usbcali.viajesusb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.repository.DestinoRepository;

import co.edu.usbcali.viajesusb.utils.Constantes;

@Scope("singleton")
@Service
public class DestinoServiceImpl implements DestinoService {

	@Autowired
	private TipoDestinoService tipoDestinoService;

	@Autowired
	private DestinoRepository destinoRepository;

	@Override
	public Destino guardarDestino(DestinoDTO destinoDTO) throws Exception {

		Destino destino = null;
		TipoDestino tipoDestino = null;

		// Se arma el destino

		destino = new Destino();

		destino.setAire(destinoDTO.getAire());
		destino.setTierra(destinoDTO.getTierra());
		destino.setMar(destinoDTO.getMar());
		destino.setCodigo(destinoDTO.getCodigo());
		destino.setNombre(destinoDTO.getNombre());
		destino.setDescripcion(destinoDTO.getDescripcion());
		destino.setFechaCreacion(destinoDTO.getFechaCreacion());
		destino.setFechaModificacion(destinoDTO.getFechaModificacion());
		destino.setUsuCreador(destinoDTO.getUsuCreador());
		destino.setUsuModificador(destinoDTO.getUsuModificador());
		destino.setEstado(destinoDTO.getEstado());

		tipoDestino = tipoDestinoService.findByCodigoAndEstado(destinoDTO.getCodigoTipoDestino(), Constantes.ACTIVO);

		if (tipoDestino == null || tipoDestino.equals("")) {
			throw new Exception("El tipo de destino" + destinoDTO.getCodigoTipoDestino() + "No existe");
		}
		if (destino.getCodigo() == null || destino.getCodigo().equals("")) {
			throw new Exception("Debe ingresar un código de destino válido");
		}

		if (destino.getCodigo().length() > 5) {
			throw new Exception("Debe ingresar un código de máximo 5 caractes");
		}

		if (destino.getNombre() == null || destino.getNombre().equals("")) {
			throw new Exception("Debe ingresar un nombre de destino válido");
		}
		if (destino.getNombre().length() > 100) {
			throw new Exception("Debe ingresar un nombre de destino de máximo 100 caracteres");
		}
		if (destino.getDescripcion() == null || destino.getDescripcion().equals("")) {
			throw new Exception("Debe ingresar una descripción del  destino válida");
		}

		if (destino.getDescripcion().length() > 300) {
			throw new Exception("El texto de la descripción debe tener máximo 300 caracteres");
		}
		if (destino.getEstado() == null || destino.getEstado().equals("")) {
			throw new Exception("Debe ingresar un estado válido");
		}

		if (destino.getEstado().length() > 1) {
			throw new Exception("No debe ingresar más de un caracter");
		}

		if (destino.getFechaCreacion() == null || destino.getFechaCreacion().equals("")) {
			throw new Exception("Debe ingresar una fecha  válida");
		}

		if (destino.getTierra() == null || destino.getTierra().equals("")) {
			throw new Exception("Debe ingresar un caracter válido");
		}

		if (destino.getTierra().length() > 1) {
			throw new Exception("No debe ingresar más de un caracter");
		}

		if (destino.getAire() == null || destino.getAire().equals("")) {
			throw new Exception("Debe ingresar un caracter válido");
		}

		if (destino.getAire().length() > 1) {
			throw new Exception("No debe ingresar más de un caracter");
		}

		if (destino.getMar() == null || destino.getMar().equals("")) {
			throw new Exception("Debe ingresar un caracter válido");
		}

		if (destino.getMar().length() > 1) {
			throw new Exception("No debe ingresar más de un caracter");
		}

		if (destino.getUsuCreador() == null || destino.getUsuCreador().equals("")) {
			throw new Exception("Debe ingresar un usuario creador válido");
		}

		if (destino.getUsuCreador().length() > 10) {
			throw new Exception("Debe ingresar un nombre de usuario no mayor a 10 caracteres");
		}

		destino.setTipoDestino(tipoDestino);

		destinoRepository.save(destino);
		
		return destino;
	}

	/**
	 * 
	 */

	@Override
	public Destino findById(Long idDest) throws Exception {
		// TODO Auto-generated method stub
		if (idDest == null) {
			throw new Exception("Debe ingresar un id de destino");

		}

		if (!destinoRepository.findById(idDest).isPresent()) {
			throw new Exception("El destino con id:  " + idDest + "no existe");
		}
		return destinoRepository.findById(idDest).get();
	}

	@Override
	public Destino actualizarDestino(DestinoDTO destinoDTO) throws Exception {
		// TODO Auto-generated method stub

		Destino destino = null;
		TipoDestino tipoDestino = null;

		// Arnar el destino
		destino = findById(destinoDTO.getIdDest());

		destino.setAire(destinoDTO.getAire());
		destino.setTierra(destinoDTO.getTierra());
		destino.setMar(destinoDTO.getMar());
		destino.setCodigo(destinoDTO.getCodigo());
		destino.setNombre(destinoDTO.getNombre());
		destino.setDescripcion(destinoDTO.getDescripcion());
		destino.setEstado(destinoDTO.getEstado());
		destino.setFechaCreacion(destinoDTO.getFechaCreacion());
		destino.setFechaModificacion(destinoDTO.getFechaModificacion());
		destino.setUsuCreador(destinoDTO.getUsuCreador());

		tipoDestino = tipoDestinoService.findByCodigoAndEstado(destinoDTO.getCodigoTipoDestino(), Constantes.ACTIVO);

		if (tipoDestino == null) {
			throw new Exception("El tipo destino " + destinoDTO.getCodigoTipoDestino() + "No existe");

		}

		if (destino == null || destino.getIdDest() == null) {
			throw new Exception("debe ingresar un destino para actualizar");

		}

		if (destino.getNombre() == null || destino.getNombre().equals("")) {
			throw new Exception("Debe ingresar un nombre de destino válido");

		}

		if (destino.getNombre().length() > 100) {

			throw new Exception("Debe ingresar un nombre no mayor a 100 caracteres");
		}
		if (destino.getFechaModificacion() == null || destino.getFechaModificacion().equals("")) {
			throw new Exception("Debe ingresar una fecha válida");
		}
		
		if (destino.getUsuModificador().length() > 10) {
			throw new Exception("El nombre de usuario modificador no puede tener más de 10 carácteres");
		}

		destino.setTipoDestino(tipoDestino);
		destinoRepository.save(destino);
		
		return destino;

	}

	@Override
	public void eliminarDestino(Long  idDest) throws Exception {
		if (idDest == null) {
			throw new Exception("El id de destinod es obligatorio");
		}
		Optional<Destino> destinoBD = destinoRepository.findById(idDest);

		if (destinoBD == null || destinoBD.equals("")) {

			throw new Exception("El destino que va eliminar no existe");
		}

		if (destinoBD.isPresent()) {
			destinoRepository.delete(destinoBD.get());
		} else {
			throw new Exception("El destino no se encontró");
		}
	}

	public DestinoServiceImpl() {
		// TODO Auto-generated constructor stub
	}
}
