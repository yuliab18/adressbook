package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OtherLabsController {

    @FXML
    private CheckBox ChBSklad;

    @FXML
    private CheckBox ChBPogod;

    @FXML
    private CheckBox ChBGnuch;

    @FXML
    private CheckBox ChBDruz;

    @FXML
    private Label IbITrueAnswer;

    @FXML
    private Label IbITrueAnswers;

    @FXML
    private Label IbITrueAnswerss;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private RadioButton radioLay;

    @FXML
    private RadioButton radioCode;

    @FXML
    private RadioButton radioHier;

    @FXML
    private RadioButton radioProp;

    @FXML
    private Label lblRadio;

    private ToggleGroup radiotoggleGroup;

    @FXML
    public void initialize() {
        // Ініціалізація ChoiceBox
        choiceBox.getItems().addAll("опис графічного інтерфейсу", "всю логіку програми", "за обробку подій");

        // Ініціалізація ComboBox
        comboBox.getItems().addAll("BorderPane", "AnchorPane", "VBox", "HBox");

        radiotoggleGroup = new ToggleGroup();

        // Прив'язуємо кожну кнопку до групи
        radioProp.setToggleGroup(radiotoggleGroup);
        radioLay.setToggleGroup(radiotoggleGroup);
        radioHier.setToggleGroup(radiotoggleGroup);
        radioCode.setToggleGroup(radiotoggleGroup);

        // Встановлюємо початковий текст на лейблі
        lblRadio.setText("Оберіть один із варіантів.");

        // Встановлення початкових значень
        IbITrueAnswer.setText("");
    }

    @FXML
    void checkBoxAnswer(ActionEvent event) {
        String correctAnswer = "гнучкість"; // Правильна відповідь
        StringBuilder selectedAnswers = new StringBuilder("Ваша відповідь:");
        boolean isCorrect = false;

        if (ChBPogod.isSelected())
            selectedAnswers.append("\nпогодженість");
        if (ChBGnuch.isSelected()) {
            selectedAnswers.append("\nгнучкість");
            isCorrect = true; // Враховуємо правильну відповідь
        }
        if (ChBDruz.isSelected())
            selectedAnswers.append("\nдружність");
        if (ChBSklad.isSelected())
            selectedAnswers.append("\nскладність");

        if (isCorrect) {
            IbITrueAnswer.setText(selectedAnswers + "\nВідповідь правильна!");
        } else {
            IbITrueAnswer.setText(selectedAnswers + "\nВідповідь невірна.");
        }
    }

    @FXML
    private void handleChoiceBoxAction() {
        String selected = choiceBox.getValue();
        String correctAnswer = "всю логіку програми"; // Правильна відповідь

        if (selected != null) {
            if (selected.equals(correctAnswer)) {
                IbITrueAnswers.setText("Ви обрали: " + selected + "\nВідповідь правильна!");
            } else {
                IbITrueAnswers.setText("Ви обрали: " + selected + "\nВідповідь невірна.");
            }
        } else {
            IbITrueAnswers.setText("Будь ласка, оберіть значення у ChoiceBox.");
        }
    }

    @FXML
    private void handleComboBoxAction() {
        String selected = comboBox.getValue();
        String correctAnswer = "VBox"; // Правильна відповідь

        if (selected != null) {
            if (selected.equals(correctAnswer)) {
                IbITrueAnswerss.setText("Відповідь: " + selected + "\nВідповідь правильна!");
            } else {
                IbITrueAnswerss.setText("Відповідь: " + selected + "\nВідповідь невірна.");
            }
        } else {
            IbITrueAnswerss.setText("Будь ласка, оберіть значення у ComboBox.");
        }
    }

    @FXML
    void RadioAnswer(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) radiotoggleGroup.getSelectedToggle();
        String correctAnswer = "Properties"; // Правильна відповідь

        if (selectedRadioButton != null) {
            String selectedText = selectedRadioButton.getText();

            if (selectedText.equals(correctAnswer)) {
                lblRadio.setText("Відповідь: " + selectedText + "\nВідповідь правильна!");
            } else {
                lblRadio.setText("Відповідь: " + selectedText + "\nВідповідь невірна.");
            }
        } else {
            lblRadio.setText("Будь ласка, оберіть один із варіантів.");
        }
    }
}

