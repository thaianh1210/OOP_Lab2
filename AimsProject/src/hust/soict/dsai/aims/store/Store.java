
package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.cart.Cart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Store {
    private ObservableList<Media> itemsInStore = FXCollections.observableArrayList();
    private Cart cart = new Cart();

    private boolean checkMedia(Media media) {
        for (Media item : itemsInStore) {
            if (item.equals(media)) {
                return true;
            }
        }
        return false;
    }

    public Media findMedia(String title) {
        for (Media item : itemsInStore) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    public void addMedia(Media media) {
        if (checkMedia(media)) {
            System.out.println("The media " + media.getTitle() + " is already in store!");
        } else {
            itemsInStore.add(media);
            System.out.println("The media " + media.getTitle() + " has been added!");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media " + media.getTitle() + " has been removed!");
        } else {
            System.out.println("Could not find " + media.getTitle() + " in store!");
        }
    }

    public void addToCart(Media media) {
        if (cart.findMedia(media.getTitle())==null) {
            cart.addMedia(media);
            System.out.println(media.getTitle() + " has been added to the cart.");
        } else {
            System.out.println(media.getTitle() + " is already in the cart.");
        }
    }

    public void viewCart() {
        System.out.println("\n**********CART**********");
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            cart.printCart();
        }
        System.out.println("************************");
    }
    public ObservableList<Media> getItemsInStore() {
        return itemsInStore;
    }
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("\n**********STORE**********\nItems in the store:\n");
        if (itemsInStore.isEmpty()) {
            string.append("Empty\n");
        } else {
            for (Media item : itemsInStore) {
                string.append(item.toString()).append("\n");
            }
        }
        string.append("***********************");
        return string.toString();
    }
}
