package sample;

import com.tw34kus.lightswitches.DoubleLightSwitch;
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

public class DoubleController {
    DoubleLightSwitch lightSwitch;

    public DoubleController() {
        lightSwitch = LightSwitchFactory.createDoubleLightSwitch(getTag());
    }


    @FXML
    private AnchorPane background;

    @FXML
    private Label label;

    @FXML
    private Button button;

    @FXML
    private Ellipse dot;

    @FXML
    private ImageView on;

    @FXML
    private ImageView off;

    @FXML
    private ImageView yellow;



    @FXML
    private AnchorPane background1;

    @FXML
    private Button button1;

    @FXML
    private Ellipse dot1;

    @FXML
    private ImageView on1;

    @FXML
    private ImageView off1;

    @FXML
    private ImageView yellow1;


    public void onClick() {
        if (lightSwitch.isOutput1On()) {
            background.setStyle("-fx-background-color: #181818");
            label.setTextFill(WHITE);
            button.setStyle("-fx-background-color: #282828");
            dot.setFill(GREENYELLOW);
            lightSwitch.turnOffOutput1();
            off.setVisible(true);
            on.setVisible(false);
            yellow.setVisible(false);
        } else {
            background.setStyle("-fx-background-color: radial-gradient(focus-distance 0% , center 30% 30% , radius 100% , #FFFF00, #000000)");
            if(lightSwitch.isOutput2On())
                label.setTextFill(BLACK);
            else
                label.setTextFill(WHITE);
            //background.setStyle("-fx-background-color: #BEBEBE");
            button.setStyle("-fx-background-color: #FFFFFF");
            dot.setFill(LIGHTSTEELBLUE);
            lightSwitch.turnOnOutput1();
            off.setVisible(false);
            on.setVisible(true);
            yellow.setVisible(true);
        }
    }

    public void onClick1() {
        if (lightSwitch.isOutput2On()) {
            background1.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10;");
            //background1.setStyle("-fx-background-color: #181818");
            label.setTextFill(WHITE);
            button1.setStyle("-fx-background-color: #282828");
            dot1.setFill(GREENYELLOW);
            lightSwitch.turnOffOutput2();
            off1.setVisible(true);
            on1.setVisible(false);
            yellow1.setVisible(false);
        } else {
            background1.setStyle("-fx-background-color: radial-gradient(focus-distance 0% , center 70% 30% , radius 100% , #FFFF00, #000000)");
            if(lightSwitch.isOutput1On())
                label.setTextFill(BLACK);
            else
                label.setTextFill(WHITE);
            //background.setStyle("-fx-background-color: #BEBEBE");
            button1.setStyle("-fx-background-color: #FFFFFF");
            dot1.setFill(LIGHTSTEELBLUE);
            lightSwitch.turnOnOutput2();
            off1.setVisible(false);
            on1.setVisible(true);
            yellow1.setVisible(true);
        }
    }

    public void initialize() {
        label.setText(getTag());
        button.setStyle("-fx-background-color: #282828");
        dot.setFill(GREENYELLOW);
        off.setVisible(true);
        on.setVisible(false);
        yellow.setVisible(false);
        button1.setStyle("-fx-background-color: #282828");
        dot1.setFill(GREENYELLOW);
        off1.setVisible(true);
        on1.setVisible(false);
        yellow1.setVisible(false);
    }
}
