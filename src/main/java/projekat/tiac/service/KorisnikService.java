package projekat.tiac.service;

import java.util.List;

import projekat.tiac.model.Korisnik;

public interface KorisnikService {
	
	public List<Korisnik> findAll();
	public Korisnik save (Korisnik korisnik);
	public Korisnik findOne(Long id);
	public Korisnik findByUsername(String username);

}
