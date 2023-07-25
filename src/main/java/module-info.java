module com.riser876.dc_installer_pt_br {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.riser876.dc_installer_pt_br to javafx.fxml;
    exports com.riser876.dc_installer_pt_br;
}
