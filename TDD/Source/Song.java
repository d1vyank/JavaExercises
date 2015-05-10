public class Song {
	private String artist;
	private String title;
	private double length;
	
	public Song(String artist, String title, double length) {
		this.artist = artist;
		this.title = title;
		this.length = length;
	}

	public String getArtist() {
		return artist;
	}

	public String getTitle() {
		return title;
	}

	public double getLength() {
		return length;
	}

	public boolean isArtist(String artist) {
		if (this.artist.equalsIgnoreCase(artist))
			return true;
		else
			return false;
	}

	public boolean isTitle(String title) {
		if (this.title.equalsIgnoreCase(title))
			return true;
		else
			return false;
	}
	public boolean equals(Song s) {
		if(s.isArtist(artist) && s.isTitle(title) && s.getLength() == length)
			return true;
		else
			return false;
	}
}
