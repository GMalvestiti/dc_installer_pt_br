package com.riser876.dc_installer_pt_br;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.riser876.util.CustomAlert;
import com.riser876.data.InstallerData;

import javafx.scene.control.Alert;

public class DataHandler {
    private String dataPath;

    public DataHandler(String path) {
        this.dataPath = path.substring(6);
    }

    public void writeData(InstallerData data) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File outputFile = new File(dataPath);

        try (FileWriter writer = new FileWriter(outputFile)) {
            gson.toJson(data, writer);
            System.out.println("JSON data has been successfully written to the file.");
        } catch (IOException e) {
            new CustomAlert("Erro", e.getMessage(), Alert.AlertType.ERROR);
            System.err.println("Failed to write JSON data to the file.");
        }
    }

    public InstallerData loadData() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dataPath), StandardCharsets.UTF_8))) {
            Gson gson = new Gson();
            return gson.fromJson(reader, InstallerData.class);
        } catch (IOException e) {
            new CustomAlert("Erro", e.getMessage(), Alert.AlertType.ERROR);
            return null;
        }
    }
}