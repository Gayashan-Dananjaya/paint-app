package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL mainFormUrl = this.getClass().getResource("/view/MainForm.fxml");
        FXMLLoader mainFormFxml = new FXMLLoader(mainFormUrl);
        AnchorPane root = mainFormFxml.load();

        Scene scene = new Scene(root);
        primaryStage.setTitle("Paint App");
        primaryStage.setWidth(1600);
        primaryStage.setHeight(920);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
//        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
