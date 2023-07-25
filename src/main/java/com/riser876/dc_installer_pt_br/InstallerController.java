package com.riser876.dc_installer_pt_br;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.fxml.FXML;

import util.CustomAlert;

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
        setInitialPath();
    }
}
