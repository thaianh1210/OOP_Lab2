package hust.soict.dsai.javafx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PaintController {
    @FXML
    private Pane drawingAreaPane;
    private boolean drawingMode = true;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4);
        if (drawingMode) {
            newCircle.setFill(Color.BLACK);
        } else {
            newCircle.setFill(Color.WHITE);
        }
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void toggleEraser() {
        drawingMode = false;
    }

    @FXML
    void togglePen() {
        drawingMode = true;
    }
}
