package academy.devdojo.springbootessentials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springbootessentials.domain.Anime;
import academy.devdojo.springbootessentials.repository.AnimeRepository;
import academy.devdojo.springbootessentials.request.AnimePostRequestBody;

@Service
public class AnimeService {

	@Autowired
	private AnimeRepository animeRepository;	
	
	public List<Anime> listAll(){
		return animeRepository.findAll();
	}
	
	public Anime findByIdOrThrowBadRequestException(Long id){
		return animeRepository.findById(id)
							  .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime ID not found"));
	}

	public Anime save(Anime anime) {
		anime.setId(null);
		return animeRepository.save(anime);
	}

	public void delete(Long id) {
		animeRepository.delete(findByIdOrThrowBadRequestException(id));
	}

	public void replace(Anime anime) {
		animeRepository.save(anime);
	}
	
}
