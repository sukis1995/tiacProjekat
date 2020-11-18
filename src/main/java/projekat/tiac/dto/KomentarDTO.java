package projekat.tiac.dto;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;


public class KomentarDTO {
	
	private Long id;
	private String tekst;
	private String datumVreme;
	private Long idPost;
	private Long idKorisnik;
	private String imeKorisnik;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	
	
	public String getDatumVreme() {
		return datumVreme;
	}
	public void setDatumVreme(String datumVreme) {
		this.datumVreme = datumVreme;
	}
	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}
	public Long getIdKorisnik() {
		return idKorisnik;
	}
	public void setIdKorisnik(Long idKorisnik) {
		this.idKorisnik = idKorisnik;
	}
	public String getImeKorisnik() {
		return imeKorisnik;
	}
	public void setImeKorisnik(String imeKorisnik) {
		this.imeKorisnik = imeKorisnik;
	}
	
	
	

}
