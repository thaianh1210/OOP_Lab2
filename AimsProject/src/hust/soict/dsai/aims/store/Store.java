public class Store {
    private static final int MAX_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The disc \"" + dvd.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("Cannot add \"" + dvd.getTitle() + "\": Store is full.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The disc \"" + dvd.getTitle() + "\" has been removed from the store.");
                return;
            }
        }
        System.out.println("The disc \"" + dvd.getTitle() + "\" was not found in the store.");
    }

    // In danh sách DVD trong cửa hàng
    public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Available Items:");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("***************************************************");
    }
}
