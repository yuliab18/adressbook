package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller {
    public void openOtherLabs() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("other_labs.fxml"));
            Parent root = loader.load(); // Завантаження FXML

            Stage stage = new Stage(); // Створення нового вікна
            stage.setScene(new Scene(root)); // Встановлення сцени
            stage.setTitle("Other Labs");
            stage.show(); // Показ вікна
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private TableView<Contact> tableView;

    @FXML
    private TableColumn<Contact, String> nameColumn;

    @FXML
    private TableColumn<Contact, String> phoneColumn;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchField;

    private ObservableList<Contact> contactList = FXCollections.observableArrayList();
    private FilteredList<Contact> filteredContacts;

    private Main mainApp;

    @FXML
    private void initialize() {
        // Ініціалізація колонок таблиці
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        // Ініціалізація списку контактів
        filteredContacts = new FilteredList<>(contactList, p -> true);
        tableView.setItems(filteredContacts);
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleAddButton() {
        try {
            mainApp.showScene2(this); // Відкриваю scene2
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addContact(String name, String phone) {
        contactList.add(new Contact(name, phone)); // Додаю новий контакт
    }

    @FXML
    private void handleDeleteButton() {
        contactList.clear(); // Очищую список контактів
        tableView.setItems(contactList); // Оновлюю таблицю
    }

    @FXML
    private void handleSearchButton() {
        String searchText = searchField.getText().toLowerCase();
        filteredContacts.setPredicate(contact -> {
            if (searchText.isEmpty()) {
                return true; // Якщо поле пошуку порожнє, показую всі контакти
            }
            return contact.getName().toLowerCase().contains(searchText) ||
                    contact.getPhone().toLowerCase().contains(searchText);
        });
    }
}
