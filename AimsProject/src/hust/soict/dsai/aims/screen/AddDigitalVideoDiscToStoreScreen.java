package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
    }

    @Override
    protected VBox createForm() {
        VBox form = new VBox(10);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));

        Label header = new Label("Add Digital Video Disc to Store");
        header.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField titleField = new TextField();
        titleField.setPromptText("Title");

        TextField categoryField = new TextField();
        categoryField.setPromptText("Category");

        TextField directorField = new TextField();
        directorField.setPromptText("Director");

        TextField lengthField = new TextField();
        lengthField.setPromptText("Length (minutes)");

        TextField costField = new TextField();
        costField.setPromptText("Cost");

        Button addButton = new Button("Add DVD");
        addButton.setOnAction(e -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            String director = directorField.getText();
            String lengthText = lengthField.getText();
            String costText = costField.getText();

            // Kiểm tra nếu có trường nào bị để trống
            if (title.isEmpty() || category.isEmpty() || director.isEmpty() || lengthText.isEmpty() || costText.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields.");
                alert.showAndWait();
                return;
            }

            int length = 0;
            float cost = 0.0f;

            // Kiểm tra nếu `length` không hợp lệ
            try {
                length = Integer.parseInt(lengthText);
                if (length <= 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Input Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Length must be a positive integer.");
                    alert.showAndWait();
                    return;
                }
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Length must be an integer.");
                alert.showAndWait();
                return;
            }

            try {
                cost = Float.parseFloat(costText);
                if (cost <= 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Input Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Cost must be a positive number.");
                    alert.showAndWait();
                    return;
                }
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Cost must be a number.");
                alert.showAndWait();
                return;
            }
        });

        form.getChildren().addAll(header, titleField, categoryField, directorField, lengthField, costField, addButton);
        return form;
    }
}
