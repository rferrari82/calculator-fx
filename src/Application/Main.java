package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override // Implement abstract start method
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
        //primaryStage is the "Stage" - Main Window where every component or widget exists
        primaryStage.setTitle("");
        //Scene laid on top of stage where you then put widgets
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    //calls javafx constructor which calls start method.
    public static void main(String[] args) {
        launch(args);
    }
}
