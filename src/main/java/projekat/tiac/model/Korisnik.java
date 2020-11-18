package projekat.tiac.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Korisnik {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String username;
	@Column
	private String password;
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "korisnik")
	private List<Ocena> ocene= new ArrayList<Ocena>();
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Uloga> uloge= new ArrayList<Uloga>();
	
	
	public Korisnik () {
		
	}
	
	public Korisnik (Korisnik korisnik) {
		this.id=korisnik.getId();
		this.username=korisnik.getUsername();
		this.password=korisnik.getPassword();
		this.uloge=korisnik.getUloge();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Ocena> getOcene() {
		return ocene;
	}
	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}
	
	public List<Uloga> getUloge() {
		return uloge;
	}

	public void setUloge(List<Uloga> uloge) {
		this.uloge = uloge;
	}

	public void addOcena(Ocena ocena) {
		this.ocene.add(ocena);
		if(ocena.getKorisnik()!=this) {
			ocena.setKorisnik(this);
		}
	}
	public void addUloga(Uloga uloga) {
		this.getUloge().add(uloga);
		if(!uloga.getKorisnici().contains(this)) {
			uloga.getKorisnici().add(this);
		}
	}
}
