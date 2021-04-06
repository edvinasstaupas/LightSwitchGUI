package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stg;

    static String tag;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (Exception exception) {
            throw new RuntimeException("IO Exception in CommandLine Application", exception);
        }
        primaryStage.setTitle("Light switches");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void changeScene(String fxml, String sentTag) throws IOException {
        tag = sentTag;
        try {
            Parent pane = FXMLLoader.load(getClass().getResource(fxml));
            stg.getScene().setRoot(pane);
        } catch (IOException ex) {
            throw new IOException();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static String getTag () {
        return tag;
    }
}

