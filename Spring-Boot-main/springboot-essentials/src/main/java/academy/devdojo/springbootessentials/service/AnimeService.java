package academy.devdojo.springbootessentials.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import academy.devdojo.springbootessentials.domain.Anime;
import academy.devdojo.springbootessentials.exceptions.BadRequestException;
import academy.devdojo.springbootessentials.repository.AnimeRepository;

@Service
public class AnimeService {

	// @Autowired
	private final AnimeRepository animeRepository;		
	
	public AnimeService(AnimeRepository animeRepository) {
		super();
		this.animeRepository = animeRepository;
	}
	
	public Page<Anime> list(Pageable pageable) {
		return animeRepository.findAll(pageable);
	}

	public List<Anime> listAll(){
		return animeRepository.findAll();
	}
	
	public Anime findByIdOrThrowBadRequestException(Long id){
		return animeRepository.findById(id)
							  .orElseThrow(() -> new BadRequestException("Anime ID not found"));
	}

	public List<Anime> findByName(String name){
		return animeRepository.findByName(name);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Anime save(Anime anime) {
		anime.setId(null);
		Anime save = animeRepository.save(anime);
		
		// if(true) throw new RuntimeException("Teste");
		
		return save;
	}

	public void delete(Long id) {
		animeRepository.delete(findByIdOrThrowBadRequestException(id));
	}

	public void replace(Anime anime) {
		animeRepository.save(anime);
	}
	
}
