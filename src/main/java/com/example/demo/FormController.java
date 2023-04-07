package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {
    @FXML
    private Button submitBtn;

    @FXML
    TextField nameField;

    @FXML
    Label nameLabel;

    @FXML
    Label resultLabel;

    @FXML
    public void submit() {
        resultLabel.setText(nameField.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText("Name");
        submitBtn.setText("Submit");
    }
}
