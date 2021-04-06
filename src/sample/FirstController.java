package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Locale;

public class FirstController {

    ObservableList<String> choiceBoxList = FXCollections.observableArrayList("Simple light", "Dimmable light", "Double light", "Timed light");

    @FXML
    private Button button;

    @FXML
    private TextField textField;

    @FXML
    private ChoiceBox<String> choiceBox;

    //@FXML

    @FXML
    private void initialize() {
        choiceBox.setValue("Simple light");
        choiceBox.setItems(choiceBoxList);
    }

    @FXML

    public void changeScenery() throws IOException{
        Main m = new Main();
        String source = choiceBox.getValue();
        String tag = textField.getText();
        String fxml = switch (source) {
            case "Simple light" -> "simple.fxml";
            case "Dimmable light" -> "dimmable.fxml";
            case "Double light" -> "double.fxml";
            case "Timed light" -> "timed.fxml";
            default -> "sample.fxml";
        };

        if(tag.equals("")) {
            String tag1 = fxml.substring(1, fxml.length() - 5);
            String tag2 = fxml.substring(0, 1);
            tag = tag2.toUpperCase(Locale.ROOT) + tag1 + " source";
        }
        System.out.println(fxml + " " + tag);
        try {
            m.changeScene(fxml, tag);
        } catch (IOException ioException) {
            throw new RuntimeException("IO Exception in CommandLine Application", ioException);
        }
    }
}
