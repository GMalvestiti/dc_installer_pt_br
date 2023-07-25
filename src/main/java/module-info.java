module com.riser876.dc_installer_pt_br {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.riser876.dc_installer_pt_br to javafx.fxml, com.google.gson;
    opens util to com.google.gson;
    
    exports com.riser876.dc_installer_pt_br;
}
