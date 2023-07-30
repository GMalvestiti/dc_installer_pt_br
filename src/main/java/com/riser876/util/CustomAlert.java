package com.riser876.util;

import javafx.scene.control.Alert;

public class CustomAlert {

    public CustomAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}