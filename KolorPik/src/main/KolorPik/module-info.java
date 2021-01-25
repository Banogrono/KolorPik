module KolorPik {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jnativehook;

    opens main.KolorPik to javafx.fxml;
    exports main.KolorPik;
}