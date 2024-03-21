package com.example.xerccherr;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TicketController {

    @FXML
    private Button buyButton;

    @FXML
    private TextField cost;

    @FXML
    private Button nazadButton;

    @FXML
    private TextField place;

    @FXML
    private TextField data;

    @FXML
    private ChoiceBox<String> sobitie;
    @FXML
    void initialize() {
        sobitie.getItems().addAll("Lida", "pyrokinesis");
            sobitie.setOnAction(event -> {
                String selectedOption = sobitie.getValue();
                if ("Lida".equals(selectedOption)) {
                    cost.setText("1400");
                    place.setText("Кроп Арена");
                    data.setText("30 марта 2024, 17:00");
                } else if ("pyrokinesis".equals(selectedOption)) {
                    cost.setText("2000");
                    place.setText("Кроп Арена");
                    data.setText("1 апреля, 19:00");
                }
            });

            buyButton.setOnAction(actionEvent -> {
                buyButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("sobitie.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));

                Label eventLabel = (Label) root.lookup("#eventLabel");
                eventLabel.setText(sobitie.getValue());

                Label placeLabel = (Label) root.lookup("#placeLabel");
                placeLabel.setText(place.getText());

                Label costLabel = (Label) root.lookup("#costLabel");
                costLabel.setText(cost.getText());

                Label dataLabel = (Label) root.lookup("#dataLabel");
                dataLabel.setText(data.getText());

                stage.showAndWait();
            });

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
            stage.show();

        });
    }

}
