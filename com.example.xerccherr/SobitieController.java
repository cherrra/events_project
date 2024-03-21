package com.example.xerccherr;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class SobitieController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label costLabel;

    @FXML
    private Label dataLabel;

    @FXML
    private Label eventLabel;

    @FXML
    private Button nazadButton;

    @FXML
    private Label placeLabel;


    @FXML
    void initialize() {
        nazadButton.setOnAction(actionEvent -> {
            //прячем первое окно
            nazadButton.getScene().getWindow().hide();
            //отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
            //указываем место расположения нужного файла
            loader.setLocation(getClass().getResource("hello-view.fxml"));
            //загружаем файл для дальнейшего отображения
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });

    };


}
