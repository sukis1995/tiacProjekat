package projekat.tiac.service;

import projekat.tiac.model.Uloga;

public interface UlogaService {
	
	public Uloga save(Uloga uloga);
	public Uloga findByNaziv(String uloga);

}
