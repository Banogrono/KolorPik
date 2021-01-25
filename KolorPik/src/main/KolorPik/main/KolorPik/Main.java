package main.KolorPik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.Objects;

public class Main extends Application {

    Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()
                .getClassLoader().getResource("KolorPikGui.fxml")));

        stage.setTitle("Kolor Pik");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.getIcons().add(new Image(String.valueOf(getClass().getClassLoader().getResource("KolorPikIcon.png"))));
        stage.show();
        stage.setOnCloseRequest(e -> {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException ex) {
                ex.printStackTrace();
            }
            stage.close();
        });



    }

    public static void main(String[] args) {
        launch(args);
    }
}
