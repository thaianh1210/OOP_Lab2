package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public int getLength(){

        return length;
    }
    public String getTitle(){
        return title;
    }
    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }
    public void play(){
        System.out.println("Playing track: "+ this.getTitle());
        System.out.println("Length: "+ this.getLength());
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Track track = (Track) obj;
        return title.equals(track.title) && length == track.length;
    }

}
