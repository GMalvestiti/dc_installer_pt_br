package com.riser876.dc_installer_pt_br;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.riser876.util.CustomAlert;
import com.riser876.data.InstallerData;

import javafx.scene.control.Alert;

public class DataHandler {
    private String dataPath;

    public DataHandler(String path) {
        this.dataPath = path;
    }

    public void writeData(InstallerData data) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Write to a temporary file
        File tempFile;
        try {
            tempFile = File.createTempFile("temp", null);
        } catch (IOException e) {
            new CustomAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
            System.err.println("Failed to create a temporary file.");
            return;
        }

        try (FileWriter writer = new FileWriter(tempFile)) {
            gson.toJson(data, writer);
            System.out.println("JSON data has been successfully written to the temporary file.");
        } catch (IOException e) {
            new CustomAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
            System.err.println("Failed to write JSON data to the temporary file.");
            return;
        }

        // Merge with the existing resource data
        try (InputStream inputStream = getClass().getResourceAsStream(dataPath);
             FileOutputStream outputStream = new FileOutputStream(tempFile)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // Read the data from the temporary file
            try (InputStreamReader reader = new InputStreamReader(new FileInputStream(tempFile), StandardCharsets.UTF_8)) {
                InstallerData existingData = gson.fromJson(reader, InstallerData.class);
                // Merge existingData and data if needed

                // ... (your merging logic or handling of the data)

                // Write back the merged data to the resource
                try (OutputStreamWriter resourceWriter = new OutputStreamWriter(getClass().getResourceAsStream(dataPath), StandardCharsets.UTF_8)) {
                    gson.toJson(existingData, resourceWriter);
                    System.out.println("Merged JSON data has been successfully written to the resource.");
                } catch (IOException ex) {
                    new CustomAlert("Error", ex.getMessage(), Alert.AlertType.ERROR);
                    System.err.println("Failed to write merged JSON data to the resource.");
                }
            } catch (IOException e) {
                new CustomAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
                System.err.println("Failed to read JSON data from the temporary file.");
            }
        } catch (IOException e) {
            new CustomAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
            System.err.println("Failed to read JSON data from the resource.");
        } finally {
            tempFile.delete(); // Delete the temporary file after merging the data with the resource
        }
    }

    public InstallerData loadData() {
        try (InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("data/installer.json"), StandardCharsets.UTF_8)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, InstallerData.class);
        } catch (IOException e) {
            new CustomAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
            return null;
        }
    }
}