package co.edu.usbcali.viajesusb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
	
	@Mapping(source = "tipoIdentificacion.nombre", target = "nombreTipoIdentificacion")
	@Mapping(source = "tipoIdentificacion.codigo", target = "codigoTipoIdentificacion")
	@Mapping(source = "tipoIdentificacion.idTiid", target = "idTiid")
	public ClienteDTO clienteToClienteDTO(Cliente cliente);

}
