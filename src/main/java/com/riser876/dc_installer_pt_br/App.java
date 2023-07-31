package com.riser876.dc_installer_pt_br;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.riser876.data.InstallerData;

public class App extends Application {

    private static Scene scene;
    private static Stage stage;
    private static DataHandler dataHandler;
    public static InstallerData installerData;

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("installer.fxml"));

            App.scene = new Scene(root);
            App.scene.getStylesheets().add(this.getPath("css/installer.css"));

            App.stage = primaryStage;
            this.prepareStage();
            this.handler();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareStage() throws IOException {
        App.stage.setTitle("Instalador - Tradução DawnCraft PT-BR");
        App.stage.getIcons().addAll(new Image(this.getPath("img/icon.png")));
        App.stage.setScene(scene);
        App.stage.show();
    }

    private String getPath(String path) {
        return getClass().getResource(path).toExternalForm();
    }

    private void handler() {
        App.dataHandler = new DataHandler("data/installer.json");
        App.installerData = App.dataHandler.loadData();
    }

    public static void save() {
        App.dataHandler.writeData(installerData);
        App.dataHandler.loadData();
    }

    public static void main(String[] args) {
        launch();
    }
}