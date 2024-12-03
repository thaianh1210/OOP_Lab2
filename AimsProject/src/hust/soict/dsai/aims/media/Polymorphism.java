package hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Polymorphism {
    public static void main(String[] args) {
        List<Media> media = new ArrayList<Media>();
        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("Track 1", 1));
        tracks.add(new Track("Track 2", 2));
        CompactDisc cd = new CompactDisc(1, "Tinh em nhu dai duong", "Bolero", 15.0f, "Artist", tracks);
        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "She's a 10 but..", "Rap", 17.0f, "Artist", 120);
        Book book = new Book(3, "Book", "Book", 5.0f, List.of("Author 1", "Author 2"));
        media.add(cd);
        media.add(dvd);
        media.add(book);
        for (Media m : media) {
            System.out.println(m.toString());
        }
    }
}
