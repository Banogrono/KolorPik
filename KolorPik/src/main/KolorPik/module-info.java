module KolorPik {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens main.KolorPik to javafx.fxml;
    exports main.KolorPik;
}