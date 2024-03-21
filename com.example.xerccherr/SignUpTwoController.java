package com.example.xerccherr;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.stage.Stage;
import java.io.IOException;


public class SignUpTwoController extends Configs {
    private Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    @FXML
    private Button nazadButton;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpLogTwo;

    @FXML
    private TextField signUpNameTwo;

    @FXML
    private PasswordField signUpPassTwo;

    @FXML
    void initialize() {
        signUpButton.setOnAction(event -> {
            String loginText = signUpLogTwo.getText().trim();
            String loginPassword = signUpPassTwo.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals("")) {
                signUpNewUser();
                signUpButton.getScene().getWindow().hide();
                openNewScene("polzovatel.fxml");
            } else {
                System.out.println("Login and password is empty");
            }
        });

        nazadButton.setOnAction(actionEvent -> {
            nazadButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("hello-view.fxml"));
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

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String name = signUpNameTwo.getText();
        String login = signUpLogTwo.getText();
        String password = signUpPassTwo.getText();
        User user = new User(name, login, password);
        dbHandler.signUpUser(user);
    };


    public ResultSet getUser(User user) {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_NAME + "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getName());
            prSt.setString(2, user.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resSet;
    }

    private void openNewScene(String fxmlFile) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        try {
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User(signUpNameTwo.getText(), signUpLogTwo.getText(), signUpPassTwo.getText());
        user.setName(loginText);
        user.setPassword(loginPassword);
        dbHandler.signUpUser(user);
    }

}
