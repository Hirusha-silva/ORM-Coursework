package lk.ijse.project.mentalhealthterapycenter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/userLogin-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("The Serenity Mental Health Therapy Center");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
