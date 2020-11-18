package projekat.tiac.support;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.tiac.dto.KomentarDTO;
import projekat.tiac.model.Komentar;
import projekat.tiac.service.KomentarService;
import projekat.tiac.service.KorisnikService;
import projekat.tiac.service.PostService;
@Component
public class KomentarDTOToKomentar implements Converter<KomentarDTO, Komentar> {
	@Autowired
	private PostService postService;
	@Autowired
	private KomentarService komentarService;
	@Autowired
	private KorisnikService korisnikService;
	
	@Override
	public Komentar convert(KomentarDTO dto) {
		Komentar komentar;
		if(dto.getId()!=null) {
			komentar=  komentarService.findOne(dto.getId()).get();
		}else {
			komentar=new Komentar();
			komentar.setDatumVreme(LocalDateTime.now());
		}
		
		komentar.setPost(postService.findOne(dto.getIdPost()).get());
		komentar.setTekst(dto.getTekst());
		return komentar;
	}

}
