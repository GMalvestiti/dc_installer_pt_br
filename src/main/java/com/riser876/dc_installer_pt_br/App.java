package com.riser876.dc_installer_pt_br;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("installer.fxml"));

            App.scene = new Scene(root);
            App.scene.getStylesheets().add(getClass().getResource("css/installer.css").toExternalForm());

            App.stage = primaryStage;
            this.prepareStage();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareStage() throws IOException {
        App.stage.setTitle("Instalador - Tradução DawnCraft PT-BR");
        App.stage.getIcons().addAll(new Image(getClass().getResource("img/icon.png").toExternalForm()));
        App.stage.setScene(scene);
        App.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}