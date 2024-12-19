package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        showScene1();
    }

    public void showScene1() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("first.fxml"));
        Parent root = loader.load();

        // Підключення стилів до першої сцени
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        Scene1Controller controller = loader.getController();
        controller.setMainApp(this);

        primaryStage.setTitle("Контактна книга");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showScene2(Scene1Controller scene1Controller) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
        Parent root = loader.load();


        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        Scene2Controller controller = loader.getController();
        controller.setScene1Controller(scene1Controller);

        Stage stage = new Stage();
        stage.setTitle("Додати контакт");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
