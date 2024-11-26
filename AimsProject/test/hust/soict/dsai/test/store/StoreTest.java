public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
            "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
            "Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
            "Aladdin", "Animation", "Guy Ritchie", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(
            "The Avengers", "Action", "Joss Whedon", 143, 22.95f);

        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.addDVD(dvd4);

        System.out.println("\nCurrent store inventory:");
        store.printStore();

        System.out.println("\nRemoving a DVD:");
        store.removeDVD(dvd2); // Xóa DVD "Star Wars"

        System.out.println("\nUpdated store inventory:");
        store.printStore();

        System.out.println("\nTrying to remove a DVD not in store:");
        store.removeDVD(dvd2); 
    }
}

