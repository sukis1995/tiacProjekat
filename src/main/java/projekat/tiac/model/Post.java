package projekat.tiac.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private Korisnik korisnik;
	@Column
	private LocalDateTime datumVreme;
	@Column
	private String tekst;
	@Column
	private double srednjaOcena;
	@OneToMany(mappedBy = "post",orphanRemoval = true,cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Komentar> komentari= new ArrayList<Komentar>();
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "post", cascade = CascadeType.ALL)
	private List<Ocena> ocene= new ArrayList<Ocena>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	
	public LocalDateTime getDatumVreme() {
		return datumVreme;
	}
	public void setDatumVreme(LocalDateTime datumVreme) {
		this.datumVreme = datumVreme;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public double getSrednjaOcena() {
		
		double ukupnaOcena=0;
		for (Ocena o : ocene) {
			ukupnaOcena+=o.getVrednost();
		}
		if(ocene.size()!=0) {
			return ukupnaOcena/ocene.size();
		}
		return ukupnaOcena;
	}
	public void setSrednjaOcena(double srednjaOcena) {
		this.srednjaOcena = srednjaOcena;
	}
	public List<Komentar> getKomentari() {
		return komentari;
	}
	public void setKomentari(List<Komentar> komentari) {
		this.komentari = komentari;
	}
	
	
	public List<Ocena> getOcene() {
		return ocene;
	}
	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}
	public void addKomentar(Komentar komentar) {
		this.komentari.add(komentar);
		if(komentar.getPost()!=this) {
			komentar.setPost(this);
		}
	}
	
	public void addOcena(Ocena ocena) {
		this.ocene.add(ocena);
		if(ocena.getPost()!=this) {
			ocena.setPost(this);
		}
	}
	

}
