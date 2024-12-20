package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Arrays;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart);
    }

    @Override
    protected VBox createForm() {
        VBox form = new VBox(10);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));

        Label header = new Label("Add Book to Store");
        header.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField titleField = new TextField();
        titleField.setPromptText("Title");

        TextField categoryField = new TextField(); // Note: Thêm trường nhập cho category
        categoryField.setPromptText("Category");

        TextField costField = new TextField();
        costField.setPromptText("Cost");

        TextField authorField = new TextField(); // Note: Thêm trường nhập cho authors
        authorField.setPromptText("Authors (comma-separated)");

        Button addButton = new Button("Add Book");
        addButton.setOnAction(e -> {
            String title = titleField.getText();
            String costText = costField.getText();
            String category = categoryField.getText(); // Note: Lấy giá trị category
            String authorsText = authorField.getText(); // Note: Lấy giá trị authors

            if (title.isEmpty() || costText.isEmpty() || category.isEmpty() || authorsText.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields.");
                alert.showAndWait();
                return;
            }

            try {
                float cost = Float.parseFloat(costText);

                // Note: Chuyển authors từ chuỗi sang danh sách
                String[] authorsArray = authorsText.split(",");
                for (int i = 0; i < authorsArray.length; i++) {
                    authorsArray[i] = authorsArray[i].trim();
                }

                int id = store.getItemsInStore().size() + 1;
                Book book = new Book(id, title, category, cost, Arrays.asList(authorsArray));
                store.addMedia(book);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Book added to store successfully!");
                alert.showAndWait();

                // Clear fields after adding
                titleField.clear();
                categoryField.clear(); // Note: Clear category field
                costField.clear();
                authorField.clear(); // Note: Clear authors field
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid number for cost.");
                alert.showAndWait();
            }
        });

        // Note: Thêm categoryField và authorField vào form
        form.getChildren().addAll(header, titleField, categoryField, costField, authorField, addButton);
        return form;
    }
}
