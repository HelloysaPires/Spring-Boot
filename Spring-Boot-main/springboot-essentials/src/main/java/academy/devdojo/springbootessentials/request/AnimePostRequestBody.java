package academy.devdojo.springbootessentials.request;

import java.util.Objects;

public class AnimePostRequestBody {
	
	private String name;

	public AnimePostRequestBody(String name) {
		super();
		this.name = name;
	}
	
	public AnimePostRequestBody( ) {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnimePostRequestBody other = (AnimePostRequestBody) obj;
		return Objects.equals(name, other.name);
	}
	
	
	
	
}
