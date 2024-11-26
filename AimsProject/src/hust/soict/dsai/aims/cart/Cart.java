
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
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

}


