package sample;

import com.tw34kus.lightswitches.LightSwitch;
import com.tw34kus.lightswitches.LightSwitchFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

import static javafx.scene.paint.Color.*;
import static sample.Main.getTag;

public class SimpleController {
    LightSwitch lightSwitch;

    public SimpleController() {
        lightSwitch = LightSwitchFactory.createLightSwitch(getTag());
    }

    @FXML
    private Button button;

    @FXML
    private AnchorPane background;

    @FXML
    private Label label;

    @FXML
    private Ellipse dot;

    @FXML
    private ImageView on;

    @FXML
    private ImageView off;

    @FXML
    private ImageView yellow;

    public void onClick() {
        if (lightSwitch.isOn()) {
            background.setStyle("-fx-background-color: #181818");
            button.setStyle("-fx-background-color: #282828");
            label.setTextFill(WHITE);
            dot.setFill(GREENYELLOW);
            lightSwitch.turnOff();
            off.setVisible(true);
            on.setVisible(false);
            yellow.setVisible(false);
        } else {
            background.setStyle("-fx-background-color: radial-gradient(focus-distance 0% , center 50% 30% , radius 50% , #FFFF00, #000000)");
            //background.setStyle("-fx-background-color: #BEBEBE");
            button.setStyle("-fx-background-color: #FFFFFF");
            label.setTextFill(BLACK);
            dot.setFill(LIGHTSTEELBLUE);
            lightSwitch.turnOn();
            off.setVisible(false);
            on.setVisible(true);
            yellow.setVisible(true);
        }
    }

    public void initialize() {
        label.setText(getTag());
        button.setStyle("-fx-background-color: #282828");
        dot.setFill(GREENYELLOW);
        off.setVisible(true);
        on.setVisible(false);
        yellow.setVisible(false);
    }
}
