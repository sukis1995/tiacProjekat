package projekat.tiac.controller;


import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import projekat.tiac.dto.KomentarDTO;
import projekat.tiac.model.Komentar;
import projekat.tiac.model.Korisnik;
import projekat.tiac.service.KomentarService;
import projekat.tiac.service.KorisnikService;
import projekat.tiac.service.PostService;
import projekat.tiac.support.KomentarDTOToKomentar;
import projekat.tiac.support.KomentarToKomentarDTO;

@Controller
@RequestMapping("/api/komentari")
public class KomentarController {
	@Autowired
	private KomentarService komentarService;
	@Autowired
	private KomentarToKomentarDTO toDto;
	@Autowired
	private KomentarDTOToKomentar toKomentar;
	@Autowired
	private KorisnikService korisnikService;
	@Autowired
	private PostService postService;
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<KomentarDTO> save (@RequestBody KomentarDTO dto,Principal principal){
		Komentar komentar = toKomentar.convert(dto);
		Korisnik korisnik= korisnikService.findByUsername(principal.getName());
		if(komentar==null) {
			return new ResponseEntity<KomentarDTO>(HttpStatus.BAD_REQUEST);
		}
		komentar.setKorisnik(korisnik);
		Komentar saved = komentarService.save(komentar.getPost().getId(), komentar);
		if(saved==null) {
			return new ResponseEntity<KomentarDTO>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<KomentarDTO>(toDto.convert(saved), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{idPost}")
	public ResponseEntity<List<KomentarDTO>> findByPost(@PathVariable("idPost")Long idPost){
			List<Komentar> komentari= komentarService.findByPost(idPost);
			if(komentari==null || komentari.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<List<KomentarDTO>>(toDto.convert(komentari), HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.GET,value = "/komentar/{id}")
	public ResponseEntity<KomentarDTO> findOne(@PathVariable("id") Long id){
		Optional<Komentar> komentar= komentarService.findOne(id);
		if(!komentar.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<KomentarDTO>(toDto.convert(komentar.get()),HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	public ResponseEntity<KomentarDTO> delete(@PathVariable("id") Long id,
											Principal principal){
		Optional<Komentar> komentar = komentarService.findOne(id);
		Korisnik korisnik= korisnikService.findByUsername(principal.getName());
		
		if(!komentar.isPresent() || !komentar.get().getKorisnik().equals(korisnik)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Komentar deleted= komentarService.delete(id);
		
		if(deleted==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<KomentarDTO>(toDto.convert(deleted),HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.PUT,value = "/{id}")
	public ResponseEntity<KomentarDTO> update(@RequestBody KomentarDTO dto,@PathVariable ("id") Long id,
												Principal principal){
		Korisnik korisnik= korisnikService.findByUsername(principal.getName());
		Komentar komentar= toKomentar.convert(dto);
		
		if(komentar==null || !komentar.getId().equals(id) || !komentar.getKorisnik().equals(korisnik) || ((LocalDateTime.now().getMinute()-komentar.getDatumVreme().getMinute())>5)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Komentar saved = komentarService.save(komentar.getPost().getId(), komentar);
		if(saved==null) {
			return new ResponseEntity<KomentarDTO>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<KomentarDTO>(toDto.convert(saved), HttpStatus.ACCEPTED);
		
													
}
	}
