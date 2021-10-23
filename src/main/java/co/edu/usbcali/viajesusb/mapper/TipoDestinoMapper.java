package co.edu.usbcali.viajesusb.mapper;

import org.mapstruct.Mapper;


import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;

/**
 * @ClassName. TipoDestinoMapper
 * @author Anderson
 * 
 *
 */

@Mapper(componentModel = "spring")
public interface TipoDestinoMapper {
	
	public TipoDestinoDTO tipoDestinoToTipoDestinoDTO(TipoDestino tipoDestino);
	
	//@Mapping(source ="tipoDestino.idTide", target = "idTide")
	//public TipoDestino tipoDestinoDTOToTipoDestino(TipoDestinoDTO tipoDestinoDTO);

}
