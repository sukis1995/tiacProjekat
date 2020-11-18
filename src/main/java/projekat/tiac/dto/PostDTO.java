package projekat.tiac.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class PostDTO {
	
	private Long id;
	private Long idKorsnik;
	private String imeKorisnik;
	private String datumVreme;
	private String tekst;
	private double srednjaOcena;
	private int brojKomentara;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdKorsnik() {
		return idKorsnik;
	}
	public void setIdKorsnik(Long idKorsnik) {
		this.idKorsnik = idKorsnik;
	}
	public String getImeKorisnik() {
		return imeKorisnik;
	}
	public void setImeKorisnik(String imeKorisnik) {
		this.imeKorisnik = imeKorisnik;
	}
	
	
	
	public String getDatumVreme() {
		return datumVreme;
	}
	public void setDatumVreme(String datumVreme) {
		this.datumVreme = datumVreme;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public double getSrednjaOcena() {
		return srednjaOcena;
	}
	public void setSrednjaOcena(double srednjaOcena) {
		this.srednjaOcena = srednjaOcena;
	}
	public int getBrojKomentara() {
		return brojKomentara;
	}
	public void setBrojKomentara(int brojKomentara) {
		this.brojKomentara = brojKomentara;
	}
	
	
	

}
