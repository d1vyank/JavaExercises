import java.util.ArrayList;


@SuppressWarnings("serial")
public class Playlist<E extends Song> extends java.util.Vector<E> {
	private String title;

	public Playlist(String title) {
		this.title = title;
	}
    
	@SuppressWarnings("unchecked")
	public boolean addtoPlist(Song song) {
		if (song == null)
			return false;
		else if (this.contains(song))
			return false;
		else {
			this.add((E) song);
			return true;
		}
	}

	public String getTitle() {
		return title;
	}

	public boolean removeFromPlist(Song s) {
		java.util.Iterator<E> itr = this.iterator();
	    Song s1;
	    if( s==null)
	    	return false;
		while (itr.hasNext()) {
			s1 = itr.next();
			if(s1.isArtist(s.getArtist()) && s1.isTitle(s.getTitle()) && s1.getLength() == s.getLength()) {
				itr.remove();
				return true;
			}

		}
		return false;
	}

	public Song getSong(int i) {
		return this.elementAt(i);
	}

	public boolean hasTitle(String string) {
	    if(string.equalsIgnoreCase(title))
	    	return true;
	    return false;
	}

	public boolean hasArtist(String string) {
	    java.util.Iterator<E> itr = this.iterator();
		while(itr.hasNext()) {
			if(itr.next().isArtist(string))
				return true;
		}
		return false;
	}

	public int numberOfSongs() {
		return this.size();
	}

	public int numberOfArtists() {
	    java.util.Iterator<E> itr = this.iterator();
		ArrayList<String> artists = new ArrayList<String>();
		String artist;
		while(itr.hasNext()) {
			artist = itr.next().getArtist();
			if(!artists.contains(artist))
				artists.add(artist);
		}
		return artists.size();
	}

	public int numberOfTitles() {
	    java.util.Iterator<E> itr = this.iterator();
		ArrayList<String> titles = new ArrayList<String>();
		String title;
		while(itr.hasNext()) {
			title = itr.next().getTitle();
			if(!titles.contains(title))
				titles.add(title);
		}
		return titles.size();
	}

	public double playTime() {
	    java.util.Iterator<E> itr = this.iterator();
		double playtime = 0;
		while(itr.hasNext()) {
			playtime = playtime + itr.next().getLength();
		}
			
		return playtime;
	}

	public int findSong(Song song) {
		if (!super.contains(song))
			return -1;
		else
			return this.indexOf(song);
	}
	public boolean contains(Song s) {
	    java.util.Iterator<E> itr = this.iterator();
	    Song s1;
		while (itr.hasNext()) {
			s1 = itr.next();
			if(s1.isArtist(s.getArtist()) && s1.isTitle(s.getTitle()) && s1.getLength() == s.getLength())
				return true;
		}
		return false;	
	}

	public void sortByArtist() {
	
	}

	public void sortByTitle() {
		// TODO Auto-generated method stub
		
	}

	
}
