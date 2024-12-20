package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;
import java.util.*;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;


public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu(scan, store, cart);
    }

    public static void showMenu(Scanner scanner, Store store, Cart cart) {
        while (true) {
            System.out.println(
                    """             
                            AIMS:
                            --------------------------------
                            1. View store
                            2. Update store
                            3. See current cart
                            0. Exit
                            --------------------------------
                            Please choose a number: 0-1-2-3
                                     """);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0: {
                    System.out.println("Thank you for using our service.");
                    scanner.close();
                    System.exit(0);
                }
                case 1 : storeMenu(scanner, store, cart); break;
                case 2 : updateStoreMenu(scanner, store); break;
                case 3 : {
                    cart.displayCart();
                    cartMenu(scanner,cart);
                    break;
                }
            }
        }
    }

    public static void storeMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println(store);
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 : mediaDetailsMenu(scanner, store, cart); break;
                case 0 : return;
                case 2 : {
                    System.out.print("Enter the title of media: ");
                    String title = scanner.nextLine();
                    Media item = store.findMedia(title);
                    if (item != null) {
                        cart.addMedia(item);
                    } else {
                        System.out.println("No media found !");
                    }
                } break;
                case 3 : {
                    System.out.print("Enter the title of media: ");
                    String title = scanner.nextLine();
                    Media item = store.findMedia(title);
                    if (item == null) {
                        System.out.println("No media found !");
                    } else {
                        if (item.getClass().getSimpleName().equals("Book")) {
                            System.out.println("This media is unplayable");
                        } else {
                            try {
                                if (item instanceof DigitalVideoDisc dvd) {
                                    dvd.play();
                                }
                                if (item instanceof CompactDisc cd) {
                                    cd.play();
                                }
                            } catch (PlayerException e) {
                                System.out.println("Exception occurred while playing media:");
                                System.out.println(e.getMessage());
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Error: " + e.getMessage(),
                                        "Player Exception",
                                        JOptionPane.ERROR_MESSAGE
                                );
                            }
                        }
                    }
                } break;
                case 4 : {
                    cart.displayCart();
                    cartMenu(scanner,cart);
                } break;
            }
        }
    }

    public static void updateStoreMenu(Scanner scanner, Store store) {
        System.out.println("""
                ==========================
                1. Add Media
                2. Delete Media
                3. Update Media in Store
                0. Back
                ==========================
                Option: """);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 : {
                System.out.println("""
                        1. DigitalVideoDisc
                        2. CompactDisc
                        3. Book
                        -------
                        Enter your type:""");
                int choice2 = scanner.nextInt();
                System.out.print("Enter id: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter cost: ");
                float cost = scanner.nextFloat();
                scanner.nextLine();
                switch (choice2) {
                    case 1 : {
                        System.out.print("Enter director's name: ");
                        String director = scanner.nextLine();
                        System.out.print("Enter dvd's length: ");
                        int length = scanner.nextInt();
                        scanner.nextLine();
                        store.addMedia(new DigitalVideoDisc(id,title,category,cost,director,length));
                    } break;
                    case 2 : {
                        System.out.print("Enter artist's name: ");
                        String artist = scanner.nextLine();
                        System.out.print("Enter the number of tracks: ");
                        int numsTrack = scanner.nextInt();
                        scanner.nextLine();
                        ArrayList<Track> tracks = new ArrayList<Track>();
                        for (int i = 0; i < numsTrack; i++) {
                            System.out.print("Enter the name of Track [" + i + "]: ");
                            String trackName = scanner.nextLine();
                            System.out.print("Enter the length of Track [" + i + "]: ");
                            int length = scanner.nextInt();
                            scanner.nextLine();
                            tracks.add(new Track(trackName, length));
                        }
                        store.addMedia(new CompactDisc(id,title,category,cost,artist,tracks));
                    } break;
                    case 3 : {
                        System.out.print("Enter author's name: ");
                        ArrayList<String> authors = new ArrayList<>();
                        while (true) {
                            String author = scanner.nextLine();
                            if (author.isEmpty()) break;
                            authors.add(author);
                        }
                        store.addMedia(new Book(id,title,category,cost,authors));
                    } break;
                }
            } break;
            case 2 : {
                System.out.println("Enter item's title: ");
                scanner.nextLine();
                String title = scanner.nextLine();
                Iterator<Media> iter = store.getItemsInStore().iterator();
                while (iter.hasNext()) {
                    Media item = iter.next();
                    if (item.getTitle().equals(title)) {
                        iter.remove();
                        System.out.println(item.getClass().getSimpleName() + " " + item.getTitle() + " has been deleted from the store!");
                    }
                }
            } break;
            case 3 : {
                System.out.println("Enter item's id: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter cost: ");
                float cost = scanner.nextFloat();
                Media item = store.getItemsInStore().get(id);
                if (item != null) {
                    item.setTitle(title);
                    item.setCategory(category);
                    item.setCost(cost);
                }
            } break;
        }
    }

    public static void mediaDetailsMenu(Scanner scanner, Store store, Cart cart) {
        System.out.print("Enter media's title: ");
        String title = scanner.nextLine();
        Media item = store.findMedia(title);
        if (item == null) {
            System.out.println("No media found!");
            return;
        }
        System.out.println(item);
        while (true) {
            System.out.println("""
                            Options:
                            --------------------------------
                            1. Add to cart
                            2. Play
                            0. Back
                            --------------------------------
                            Please choose a number: 0-1-2""");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> cart.addMedia(item);
                case 2 -> {
                    if (item.getClass().getSimpleName().equals("Book")) {
                        System.out.println("This media is unplayable");
                    } else {
                        try {
                            if (item instanceof DigitalVideoDisc dvd) {
                                dvd.play();
                            }
                            if (item instanceof CompactDisc cd) {
                                cd.play();
                            }
                        } catch (PlayerException e) {
                            System.out.println("Exception occurred while playing media:");
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Error: " + e.getMessage(),
                                    "Player Exception",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }
                }
                case 0 -> {
                    return;
                }
            }
        }
    }

    public static void cartMenu(Scanner scanner, Cart cart) {
        while (true) {
            System.out.println("""
                    Options:
                    --------------------------------
                    1. Filter medias in cart
                    2. Sort medias in cart
                    3. Remove media from cart
                    4. Play a media
                    5. Place order
                    0. Back
                    --------------------------------  
                    Please choose a number: 0-1-2-3-4-5""");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    System.out.println("""
                            1. Filter by title
                            2. Filter by id
                            ----------------
                            Your option:
                            """);
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    if (choice2 == 1) {
                        int id = scanner.nextInt();
                        cart.searchById(id);
                    } else {
                        String title = scanner.nextLine();
                        cart.searchByTitle(title);
                    }
                }
                case 2 -> {
                    System.out.println("""
                            1. Sort by title cost
                            2. Sort by cost title
                            ----------------
                            Your option:
                            """);
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    if (choice2 == 1) {
                        cart.sortByTitleCost();
                        cart.displayCart();
                    } else {
                        cart.sortByCostTitle();
                        cart.displayCart();
                    }
                }
                case 3 -> {
                    System.out.print("Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = cart.findMedia(title);
                    if (item == null) {
                        System.out.println("There is no such media!");
                    } else {
                        cart.removeMedia(item);
                    }
                }
                case 4 -> {
                    System.out.print("Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = cart.findMedia(title);
                    if (item == null) {
                        System.out.println("There is no such media!");
                    } else {
                        if (item.getClass().getSimpleName().equals("Book")) {
                            System.out.println("This media is unplayable");
                        } else {
                            try {
                                if (item instanceof DigitalVideoDisc dvd) {
                                    dvd.play();
                                }
                                if (item instanceof CompactDisc cd) {
                                    cd.play();
                                }
                            } catch (PlayerException e) {
                                System.out.println("Exception occurred while playing media:");
                                System.out.println(e.getMessage());
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Error: " + e.getMessage(),
                                        "Player Exception",
                                        JOptionPane.ERROR_MESSAGE
                                );
                            }
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Your cart has been paid\nThanks for using our service");
                    cart.emptyCart();
                }
            }
        }
    }
}
