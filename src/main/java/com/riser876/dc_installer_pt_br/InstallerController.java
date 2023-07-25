package com.riser876.dc_installer_pt_br;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
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
}
