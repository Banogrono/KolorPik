package main.KolorPik;

import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

import java.awt.*;

public class Controller {
    public Label colorLabel;
    public Label RedColorLabel;
    public Label GreenColorLabel;
    public Label BlueColorLabel;
    public Pane previewPane;


//    public void mousePressed(MouseEvent mouseEvent) {
//        double x, y;
//        x = mouseEvent.getX();
//        y = mouseEvent.getY();
//
//        Color color;
//        try {
//            Robot robot = new Robot();
//            color = robot.getPixelColor((int) x, (int) y);
//            // TODO: turn it int html color code
//            RedColorLabel.setText(color.getRed() + "");
//            GreenColorLabel.setText(color.getGreen() + "");
//            BlueColorLabel.setText(color.getBlue() + "");
//
//            colorLabel.setText(color.toString());
//
//            // previewPane.setStyle("-fx-background-color: #454545");
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//    }



    public void mouseMoved(MouseEvent mouseEvent) {
        double x, y;
        x = mouseEvent.getX();
        y = mouseEvent.getY();

        Color color;
        try {
            Robot robot = new Robot();
            color = robot.getPixelColor((int) x, (int) y);
            // TODO: turn it int html color code
            RedColorLabel.setText(color.getRed() + "");
            GreenColorLabel.setText(color.getGreen() + "");
            BlueColorLabel.setText(color.getBlue() + "");

            colorLabel.setText(color.toString());

            // previewPane.setStyle("-fx-background-color: #454545");
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
