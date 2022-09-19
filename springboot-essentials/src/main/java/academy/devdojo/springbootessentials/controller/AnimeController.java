package academy.devdojo.springbootessentials.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.devdojo.springbootessentials.domain.Anime;
import academy.devdojo.springbootessentials.util.DateUtil;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("anime")
@Log4j2
public class AnimeController {

	@Autowired
	private DateUtil dateUtil;
	
	@GetMapping(path = "list")
	public List<Anime> list(){
		log.info(dateUtil.formatLocalDateTimeDatabaseStringStyle(LocalDateTime.now()));
		return List.of(new Anime("DBZ"), new Anime("Naruto"));
	}
}
