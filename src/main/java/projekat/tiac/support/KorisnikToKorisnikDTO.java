package projekat.tiac.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.tiac.dto.KorisnikDTO;
import projekat.tiac.model.Korisnik;
@Component
public class KorisnikToKorisnikDTO implements Converter<Korisnik, KorisnikDTO> {

	@Override
	public KorisnikDTO convert(Korisnik korisnik) {
		KorisnikDTO dto= new KorisnikDTO();
		dto.setId(korisnik.getId());
		dto.setUsername(korisnik.getUsername());
		
		return dto;
	}

}
