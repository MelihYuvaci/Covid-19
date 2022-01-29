package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {
    @FXML
    protected Button getDataButton;
    @FXML
    protected TextField urlTextField;

    @FXML
    protected void onGetDataClicked() throws IOException {
        String url =urlTextField.getText();
    }
}
