package projekat.tiac.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;




@Entity
public class Uloga {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String uloga;
	@ManyToMany
	private List<Korisnik> korisnici= new ArrayList<Korisnik>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUloga() {
		return uloga;
	}
	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
	
	public List<Korisnik> getKorisnici() {
		return korisnici;
	}
	public void setKorisnici(List<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
	public void addKorisnik(Korisnik korisnik) {
		this.korisnici.add(korisnik);
		if(!korisnik.getUloge().contains(this)) {
			korisnik.getUloge().add(this);
		}
	}
	

}
