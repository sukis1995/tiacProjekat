package projekat.tiac.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.tiac.dto.OcenaDTO;
import projekat.tiac.model.Ocena;
@Component
public class OcenaToOcenaDTO implements Converter<Ocena, OcenaDTO> {

	@Override
	public OcenaDTO convert(Ocena ocena) {
		OcenaDTO dto= new OcenaDTO();
		dto.setId(ocena.getId());
		dto.setIdKorisnik(ocena.getKorisnik().getId());
		dto.setImeKorisnik(ocena.getKorisnik().getUsername());
		dto.setIdPost(ocena.getPost().getId());
		dto.setVrednost(ocena.getVrednost());
		return dto;
	}
	
	

}
