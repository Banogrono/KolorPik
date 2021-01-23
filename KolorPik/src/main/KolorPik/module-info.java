module KolorPik {
    requires javafx.controls;
    requires javafx.fxml;

    opens main.KolorPik to javafx.fxml;
    exports main.KolorPik;
}