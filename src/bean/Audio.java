	package bean;

public class Audio extends MediaItem {
	private String artist;
	public Audio() {
		//System.out.println("Audio------------------------------");
	}
	public Audio(String artist) {
		super();
		this.artist = artist;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	@Override
	public String toString() {
		return super.toString()+"Audio [artist=" + artist + "]"+"\n";
	}
}
