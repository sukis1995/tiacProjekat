package projekat.tiac;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import projekat.tiac.model.Komentar;
import projekat.tiac.model.Korisnik;
import projekat.tiac.model.Post;
import projekat.tiac.model.Uloga;
import projekat.tiac.service.KomentarService;
import projekat.tiac.service.KorisnikService;
import projekat.tiac.service.PostService;
import projekat.tiac.service.UlogaService;

@Component
public class TestData {
	@Autowired
	private PostService postService;
	@Autowired
	private KorisnikService korisnikService;
	@Autowired
	private PasswordEncoder bcryp;
	@Autowired
	private UlogaService ulogaService;
	@Autowired
	private KomentarService komentarService;
	@PostConstruct
	public void init() {
		
		Uloga uloga= new Uloga();
		uloga.setUloga("USER");
		ulogaService.save(uloga);
		Korisnik korisnik = new Korisnik();
		korisnik.setUsername("suki");
		korisnik.setPassword(bcryp.encode("1234"));
		Korisnik korisnik1 = new Korisnik();
		korisnik1.setUsername("tica");
		korisnik1.setPassword(bcryp.encode("1234"));
		korisnikService.save(korisnik1);
		korisnikService.save(korisnik);
		
		
		korisnik.addUloga(uloga);
		korisnik.addUloga(uloga);
		
		Post post =new Post();
		post.setDatumVreme(LocalDateTime.now());
		post.setTekst("Nesto o postu");
		postService.save(post);
		post.setKorisnik(korisnik);
		Post post1 =new Post();
		post1.setDatumVreme(LocalDateTime.now());
		post1.setTekst("Nesto o postu1");
		postService.save(post1);
		post1.setKorisnik(korisnik1);
		
		korisnikService.save(korisnik);
		korisnikService.save(korisnik1);
		ulogaService.save(uloga);
		postService.save(post);
		postService.save(post1);
		
		
		Komentar komentar= new Komentar();
		komentar.setKorisnik(korisnik1);
		komentar.setPost(post);
		komentar.setDatumVreme(LocalDateTime.now());
		komentar.setTekst("Nista ne valja ovaj post");
		komentarService.save(post.getId(), komentar);
		korisnikService.save(korisnik1);
		
	}

}
