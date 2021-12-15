package application;

import application.view.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    Pane appRoot = new Pane();
    Scene mainScene = new Scene(appRoot);

    @Override
    public void start(Stage stage) throws Exception {
        MainView mv = new MainView();
        stage.setScene(mv.getMainScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
