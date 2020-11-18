package projekat.tiac.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import projekat.tiac.dto.OcenaDTO;
import projekat.tiac.model.Korisnik;
import projekat.tiac.model.Ocena;
import projekat.tiac.service.KorisnikService;
import projekat.tiac.service.OcenaService;
import projekat.tiac.support.OcenaDTOToOcena;
import projekat.tiac.support.OcenaToOcenaDTO;

@Controller
@RequestMapping("/api/ocene")
public class OcenaController {
	@Autowired
	private OcenaService ocenaService;
	@Autowired
	private OcenaToOcenaDTO toDto;
	@Autowired
	private OcenaDTOToOcena toOcena;
	@Autowired
	private KorisnikService korisnikService;
	@RequestMapping(method = RequestMethod.POST, value = "/{idPost}")
	public ResponseEntity<OcenaDTO> save (@PathVariable("idPost") Long idPost,@RequestBody OcenaDTO dto, Principal principal){
		Ocena ocena = toOcena.convert(dto);
		Korisnik korisnik= korisnikService.findByUsername(principal.getName());
		if(ocena == null ) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		for (Ocena o : korisnik.getOcene()) {
			if(o.getPost().equals(ocena.getPost())) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		ocena.setKorisnik(korisnik);
		Ocena saved = ocenaService.save(idPost,ocena);
		if(saved == null ) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<OcenaDTO>(toDto.convert( saved), HttpStatus.CREATED);
	}

}
