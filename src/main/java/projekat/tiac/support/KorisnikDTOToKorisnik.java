package projekat.tiac.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import projekat.tiac.dto.KorisnikDTO;
import projekat.tiac.model.Korisnik;
import projekat.tiac.service.UlogaService;
@Component
public class KorisnikDTOToKorisnik implements Converter<KorisnikDTO, Korisnik> {
	@Autowired
	private UlogaService ulogaService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public Korisnik convert(KorisnikDTO dto) {
		Korisnik korisnik= new Korisnik();
		korisnik.setUsername(dto.getUsername());
		korisnik.addUloga(ulogaService.findByNaziv("USER"));
		korisnik.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		return korisnik;
	}
	
	

}
