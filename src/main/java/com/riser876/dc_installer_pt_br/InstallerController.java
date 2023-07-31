package com.riser876.dc_installer_pt_br;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

import com.riser876.util.CustomAlert;

import javafx.fxml.FXML;

public class InstallerController {

    @FXML private TextField tfPath;
    @FXML private Button btnSelectDirectory;
    @FXML private Button btnInstall;

    public void initialize() {
        removeFocus();
    }

    private void removeFocus() {
        tfPath.setFocusTraversable(false);
        btnSelectDirectory.setFocusTraversable(false);
        btnInstall.setFocusTraversable(false);
    }

    @FXML
    private void setInitialPath() {
        try {
            
        } catch (Exception e) {
            new CustomAlert("Erro", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void selectDirectory() {
        String version = tfPath.getText();
        tfPath.setText("");
        App.installerData.setVersion(version);
        App.save();
        new CustomAlert("Confirmação", App.installerData.getVersion(), Alert.AlertType.INFORMATION);
    }
}
