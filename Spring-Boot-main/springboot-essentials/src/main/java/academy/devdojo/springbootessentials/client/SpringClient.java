package academy.devdojo.springbootessentials.client;

import org.springframework.web.client.RestTemplate;

import academy.devdojo.springbootessentials.domain.Anime;

public class SpringClient {

	public static void main(String[] args) {

		new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class, 2);
	
		new RestTemplate().getForEntity("http://localhost:8080/animes/all", Anime[].class);

	}

}
