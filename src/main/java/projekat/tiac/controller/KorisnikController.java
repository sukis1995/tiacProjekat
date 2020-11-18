package projekat.tiac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import projekat.tiac.dto.KorisnikDTO;
import projekat.tiac.model.Korisnik;
import projekat.tiac.service.KorisnikService;
import projekat.tiac.support.KorisnikDTOToKorisnik;
import projekat.tiac.support.KorisnikToKorisnikDTO;

@Controller
@RequestMapping(value = "/api/korisnici")
public class KorisnikController {
	
	@Autowired
	private KorisnikService korisnikService;
	@Autowired
	private KorisnikToKorisnikDTO toDto;
	@Autowired
	private KorisnikDTOToKorisnik toKorisnik;
	
	@RequestMapping(method = RequestMethod.POST,value = "/registration")
	public ResponseEntity<KorisnikDTO> registration(@RequestBody KorisnikDTO dto){
		Korisnik korisnik = toKorisnik.convert(dto);
		if(korisnik==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		List<Korisnik> korisnici= korisnikService.findAll();
		for (Korisnik k : korisnici) {
			if(k.getUsername().equals(korisnik.getUsername())) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		
		Korisnik saved=korisnikService.save(korisnik);
		if(saved==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<KorisnikDTO>(toDto.convert(korisnik), HttpStatus.CREATED);
	}

}
