package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene2Controller {

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    private Scene1Controller scene1Controller;

    public void setScene1Controller(Scene1Controller scene1Controller) {
        this.scene1Controller = scene1Controller;
    }

    @FXML
    private void handleAddButton() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        scene1Controller.addContact(name, phone); // Додаю контакт до Scene1
        clearFields();
        backToScene1(); // Повертаюся до Scene1
    }

    @FXML
    private void handleBackButton() {
        backToScene1(); // Повертаюся до Scene1
    }

    private void clearFields() {
        nameField.clear();
        phoneField.clear();
    }

    private void backToScene1() {
        // Закриваю Scene2
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }
}
