package main.KolorPik;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, NativeMouseListener {
    public Label colorLabel;
    public Label RedColorLabel;
    public Label GreenColorLabel;
    public Label BlueColorLabel;
    public Pane previewPane;

    private void getMousePointColor(int x, int y) {
        System.out.println(x + " " + y);
        final Color[] color = new Color[1];

            Platform.runLater(() -> {
                try {

                Robot robot = new Robot();
                color[0] = robot.getPixelColor(x, y);

                int RGBr = color[0].getRed();
                int RGBg = color[0].getGreen();
                int RGBb = color[0].getBlue();

                String hex = String.format("#%02x%02x%02x", RGBr, RGBg, RGBb);

                RedColorLabel.setText(RGBr + "");
                GreenColorLabel.setText(RGBg + "");
                BlueColorLabel.setText(RGBb + "");
                colorLabel.setText(hex);
                previewPane.setStyle("-fx-background-color: " + hex);
                } catch (AWTException e) {
                    e.printStackTrace();
                }
            });




    }

    private void createHook() {
        try {
            GlobalScreen.registerNativeHook();

        } catch (NativeHookException ex) {
            ex.printStackTrace();
        }
        GlobalScreen.addNativeMouseListener(this);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createHook();
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
        getMousePointColor(nativeMouseEvent.getX(), nativeMouseEvent.getY());
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {

    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {

    }
}
