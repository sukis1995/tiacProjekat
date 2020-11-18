package projekat.tiac.support;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;

import antlr.collections.List;
import projekat.tiac.dto.KomentarDTO;
import projekat.tiac.model.Komentar;
@Component
public class KomentarToKomentarDTO implements Converter<Komentar, KomentarDTO> {
	public static DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
	@Override
	public KomentarDTO convert(Komentar komentar) {
		KomentarDTO dto= new KomentarDTO();
		dto.setDatumVreme(dtf.format(komentar.getDatumVreme()));
		dto.setId(komentar.getId());
		dto.setIdKorisnik(komentar.getKorisnik().getId());
		dto.setIdPost(komentar.getPost().getId());
		dto.setImeKorisnik(komentar.getKorisnik().getUsername());
		dto.setTekst(komentar.getTekst());
		return dto;
	}
	
	public java.util.List<KomentarDTO> convert(java.util.List<Komentar> komentari){
		java.util.List<KomentarDTO> dtos= new ArrayList<KomentarDTO>();
		for (Komentar komentar : komentari) {
			KomentarDTO dto= convert(komentar);
			dtos.add(dto);
		}
		
		return dtos;
	}

}
