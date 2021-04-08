package sample;

import com.tw34kus.lightswitches.LightSwitch;
import com.tw34kus.lightswitches.LightSwitchFactory;
import com.tw34kus.lightswitches.TimerLightSwitch;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import static javafx.scene.paint.Color.*;
import static sample.Main.getTag;

public class TimedController {
    TimerLightSwitch lightSwitch;

    public TimedController() {
        lightSwitch = LightSwitchFactory.createTimerLightSwitch(getTag());
    }

    @FXML
    private Button button;

    @FXML
    private AnchorPane background;

    @FXML
    public Label label;

    @FXML
    private Ellipse dot;

    @FXML
    private ImageView on;

    @FXML
    private ImageView off;

    @FXML
    private ImageView yellow;

    @FXML
    private TextField textField;

    Timer timer = new Timer();
    long number = 0;

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
            String input = textField.getText();
            if (input.matches("[0-9]+") && input.length() < 8) {
                number = Long.parseLong(input);
            } else
                textField.setText("");

            lightSwitch.setTimeout(number);

            background.setStyle("-fx-background-color: radial-gradient(focus-distance 0% , center 50% 30% , radius 50% , #FFFF00, #000000)");
            button.setStyle("-fx-background-color: #FFFFFF");
            label.setTextFill(BLACK);
            dot.setFill(LIGHTSTEELBLUE);
            lightSwitch.turnOn();
            off.setVisible(false);
            on.setVisible(true);
            yellow.setVisible(true);

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    //someday
                    //label.setText("a");
                    if (lightSwitch.getSecsUntilTimeout() == 0) {
                        onClick();
                    }
                }
            }, 0, 1000);
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

    public void changeScenery() throws IOException {
        Main m = new Main();
        try {
            m.changeScene("sample.fxml", "sample");
        } catch (IOException ioException) {
            throw new RuntimeException("IO Exception in CommandLine Application", ioException);
        }
    }
}
