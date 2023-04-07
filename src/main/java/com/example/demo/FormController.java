package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class FormController implements Initializable {
    @FXML
    TextField note1Field;
    @FXML
    TextField note2Field;
    @FXML
    TextField coef1Field;;
    @FXML
    TextField coef2Field;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // If note1 and coef1 are not empty, then calculate the note /20
        if (!note1Field.getText().isEmpty() && !coef1Field.getText().isEmpty()) {
            coef2Field.setText("20");
        }
    }

    @FXML
    public void calculate() {
        if (note1Field.getText().isEmpty() || coef1Field.getText().isEmpty()) {
            return;
        }

        if (!note1Field.getText().matches("[0-9]+") || !coef1Field.getText().matches("[0-9]+")) {
            return;
        }

        int note1 = parseInt(note1Field.getText());
        int coef1 = parseInt(coef1Field.getText());

        if (coef1 == 0) {
            return;
        }

        // Calculate the note /20
        int note2 = (note1 * 20) / coef1;

        coef2Field.setText("20");
        note2Field.setText(String.valueOf(note2));
    }
}
