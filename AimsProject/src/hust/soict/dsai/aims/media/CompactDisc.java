package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(int id, String title, String category, float cost,
                       String artist, ArrayList<Track> tracks) {
        super(id, title, category, cost);
        this.tracks = tracks;
        this.artist = artist;
        this.setLength(getLength());
    }
    public CompactDisc(int id, String title, String category, float cost){
        super(id, title, category, cost);
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track song){
        if(!tracks.contains(song)){
            tracks.add(song);
            System.out.println("Track added");
        } else{
            System.out.println(song.getTitle() + "is already in the CD");
        }
    }
    public void removeTrack(Track song){
        if(!tracks.contains(song)){
            System.out.println("Track doesn't exist");
        } else{
            tracks.remove(song);
        }
    }
    @Override
    public String toString() {
        return String.format("CD - %s - %s - %s - %s - %s - %s",
                this.getTitle(),
                this.getCategory(),
                this.getCost(),
                this.getDirector(),
                this.getLength(),
                this.getArtist());
    }

    public void play() {
        System.out.println("\nTitle: " + getTitle() + "\nArtist: " + getArtist());
        for (Track track : tracks) {
            track.play();
        }
    }
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

}
