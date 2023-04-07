package com.example.demo.Controller;

import com.example.demo.Model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.json.*;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class FormController implements Initializable {
    @FXML
    TextField note1Field;
    @FXML
    TextField note2Field;
    @FXML
    TextField coef1Field;
    ;
    @FXML
    TextField coef2Field;

    @FXML
    VBox vBoxList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // If note1 and coef1 are not empty, then calculate the note /20
        if (!note1Field.getText().isEmpty() && !coef1Field.getText().isEmpty()) {
            coef2Field.setText("20");
        }
        // At the beginning of the program, we add to the vBoxList a new list of elements of the file Example.json
        if (vBoxList.getChildren().isEmpty()) {
            addList();
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

    @FXML
    public void addList() {
        String students;
        try {
            students = new String(Files.readAllBytes(java.nio.file.Paths.get("Example.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Create a new list of students
        ObservableList<Student> studentList = FXCollections.observableArrayList();

        // Add the students to the list
        JSONArray jsonArray = new JSONArray(students);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("name");
            boolean isStudent = jsonObject.getBoolean("student");
            int age = jsonObject.getInt("age");
            String school = jsonObject.getString("school");

            // Create a new Student object
            Student student = new Student(name, isStudent, age, school);
            studentList.add(student);
        }

        // Create a ListView control and set its items to the studentList
        ListView<Student> listView = new ListView<>();
        listView.setItems(studentList);

        // Add the column headers
        HBox columnHeaders = new HBox();
        columnHeaders.setSpacing(40);

        Label nameLabel = new Label("Name");
        Label studentLabel = new Label("Is Student");
        Label ageLabel = new Label("Age");
        Label schoolLabel = new Label("School");

        HBox.setMargin(nameLabel, new Insets(0, 100, 0, 0));
        HBox.setMargin(studentLabel, new Insets(0, 100, 0, 0));
        HBox.setMargin(ageLabel, new Insets(0, 100, 0, 0));

        columnHeaders.getChildren().addAll(nameLabel, studentLabel, ageLabel, schoolLabel);

        listView.setCellFactory(list -> new ListCell<Student>() {
            @Override
            protected void updateItem(Student item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    // Add padding to each column in the cell content
                    HBox cellContent = new HBox();
                    cellContent.setSpacing(130);
                    Label name = new Label(item.getName());
                    Label isStudent = new Label(String.valueOf(item.isStudent()));
                    Label age = new Label(String.valueOf(item.getAge()));
                    Label school = new Label(item.getSchool());
                    cellContent.getChildren().addAll(name, isStudent, age, school);
                    setGraphic(cellContent);
                }
            }
        });

        // Add the ListView and the column headers to the vBoxList
        vBoxList.getChildren().addAll(columnHeaders, listView);
    }
}