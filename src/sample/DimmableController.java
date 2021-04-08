package sample;

import com.tw34kus.lightswitches.DimmableLightSwitch;
import com.tw34kus.lightswitches.LightSwitch;
import com.tw34kus.lightswitches.LightSwitchFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;

import java.io.IOException;

import static javafx.scene.paint.Color.*;
import static sample.Main.getTag;

public class DimmableController {
    DimmableLightSwitch lightSwitch;

    public DimmableController() {
        lightSwitch = LightSwitchFactory.createDimmableLightSwitch(getTag());
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

    @FXML
    private Slider slider;

    public void onClick() {
        if (lightSwitch.isOn()) {
            background.setStyle("-fx-background-color: #181818");
            button.setStyle("-fx-background-color: #282828");
            dot.setFill(GREENYELLOW);
            lightSwitch.turnOff();
            off.setVisible(true);
            on.setVisible(false);
            yellow.setVisible(false);
            slider.setValue(lightSwitch.getIntensity());
            label.setTextFill(WHITE);
        } else {
            double intensity = slider.getValue() * 100 + 20;
            String style = String.format("-fx-background-color: radial-gradient(focus-distance %d* , center %d* %d* , radius %d* , #FFFF00, #000000)", 0, 50, 30, (int) intensity);
            style = style.replace('*', '%');
            background.setStyle(style);
            //background.setStyle("-fx-background-color: radial-gradient(focus-distance 0% , center 50% 30% , radius 30% , #FFFF00, #000000)");
            //background.setStyle("-fx-background-color: #BEBEBE");
            button.setStyle("-fx-background-color: #FFFFFF");
            dot.setFill(LIGHTSTEELBLUE);
            lightSwitch.turnOn();
            off.setVisible(false);
            on.setVisible(true);
            yellow.setVisible(true);
            if (lightSwitch.getIntensity() > 0.5)
                label.setTextFill(BLACK);
            else
                label.setTextFill(WHITE);
        }
    }

    public void onSliderChange() {
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(
                    ObservableValue<? extends Number> observableValue,
                    Number oldValue,
                    Number newValue) {
                double i = (double) newValue;
                lightSwitch.setIntensity(i);
                if (lightSwitch.isOn()) {
                    i = i * 100 + 20;
                    int intensity = (int) i;
                    String style = String.format("-fx-background-color: radial-gradient(focus-distance 0%% , center 50%% 30%% , radius %d%% , #FFFF00, #000000)", intensity);
                    style = style.replace('*', '%');
                    background.setStyle(style);
                    if (lightSwitch.getIntensity() > 0.5)
                        label.setTextFill(BLACK);
                    else
                        label.setTextFill(WHITE);
                }
            }
        });


    }

    public void initialize() {
        label.setText(getTag());
        label.setTextFill(WHITE);
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