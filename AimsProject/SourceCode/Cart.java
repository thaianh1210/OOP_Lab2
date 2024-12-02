


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
    for (DigitalVideoDisc disc : dvds) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added successfully.");
        } else {
            System.out.println("Cannot add \"" + disc.getTitle() + "\": Order is full.");
        }
      }
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    if (qtyOrdered < MAX_NUMBERS_ORDERED) {
        itemsOrdered[qtyOrdered] = dvd1;
        qtyOrdered++;
        System.out.println("The disc \"" + dvd1.getTitle() + "\" has been added successfully.");
    } else {
        System.out.println("Cannot add \"" + dvd1.getTitle() + "\": Order is full.");
    }

    if (qtyOrdered < MAX_NUMBERS_ORDERED) {
        itemsOrdered[qtyOrdered] = dvd2;
        qtyOrdered++;
        System.out.println("The disc \"" + dvd2.getTitle() + "\" has been added successfully.");
    } else {
        System.out.println("Cannot add \"" + dvd2.getTitle() + "\": Order is full.");
    }
}


    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed successfully.");
                return;
            }
        }
        System.out.println("The disc \"" + disc.getTitle() + "\" was not found in the order.");
    }

    public float totalCost(){
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
   public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;

        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println((i + 1) + ". DVD - " 
                           + disc.getTitle() + " - " 
                           + disc.getCategory() + " - " 
                           + disc.getDirector() + " - " 
                           + disc.getLength() + ": " 
                           + disc.getCost() + " $");
            totalCost += disc.getCost();
        }

        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }
   public void searchById(String id) {
    boolean found = false;
    int intId = Integer.parseInt(id);
    for (int i = 0; i < qtyOrdered; i++) {
        if (itemsOrdered[i].getId() == intId) {
            System.out.println("Found DVD: " + itemsOrdered[i].toString());
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("No DVD found with ID: " + id);
    }
}

public void searchByTitle(String title) {
    boolean found = false;
    for (int i = 0; i < qtyOrdered; i++) {
        if (itemsOrdered[i].isMatch(title)) { // Sử dụng phương thức isMatch trong DigitalVideoDisc
            System.out.println("Found DVD: " + itemsOrdered[i].toString());
            found = true;
        }
    }
    if (!found) {
        System.out.println("No DVD found with Title containing: " + title);
    }
}

}

