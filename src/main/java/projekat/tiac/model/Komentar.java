package projekat.tiac.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Komentar {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private Korisnik korisnik;
	@Column
	private LocalDateTime datumVreme;
	@ManyToOne(fetch = FetchType.LAZY)
	private Post post;
	@Column
	private String tekst;
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
	public Post getPost() {
		return post;
	}
	
	
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public void setPost(Post post) {
		this.post = post;
		if(!post.getKomentari().contains(this)) {
			post.getKomentari().add(this);
		}
	}
	
	

}
