package com.example.xerccherr;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView concertOneButton;

    @FXML
    private ImageView concertTwoButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private Button ticketButton;

    @FXML
    private Button sobitieArtistiButton;

    @FXML
    void initialize() {
        loginSignUpButton.setOnAction(actionEvent -> {
            //прячем первое окно
            loginSignUpButton.getScene().getWindow().hide();
            //отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
            //указываем место расположения нужного файла
            loader.setLocation(getClass().getResource("signUpTwo.fxml"));
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

        sobitieArtistiButton.setOnAction(actionEvent -> {
            //прячем первое окно
            sobitieArtistiButton.getScene().getWindow().hide();
            //отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
            //указываем место расположения нужного файла
            loader.setLocation(getClass().getResource("sobitie.fxml"));
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

        ticketButton.setOnAction(actionEvent -> {
            //прячем первое окно
            ticketButton.getScene().getWindow().hide();
            //отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
            //указываем место расположения нужного файла
            loader.setLocation(getClass().getResource("ticket.fxml"));
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


    };
