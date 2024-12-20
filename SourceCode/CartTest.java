public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new DVD objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Test the print method
        cart.printCart();

        // To-do: Test the search methods here
        System.out.println("\nSearch by ID:");
        cart.searchById("2"); // Kết quả: Tìm thấy Star Wars
        cart.searchById("5"); // Kết quả: Không tìm thấy

        // Tìm kiếm theo tiêu đề
        System.out.println("\nSearch by Title:");
        cart.searchByTitle("Star"); // Kết quả: Tìm thấy Star Wars
        cart.searchByTitle("King"); // Kết quả: Tìm thấy The Lion King
        cart.searchByTitle("Avengers"); // Kết quả: Không tìm thấy
    }
}