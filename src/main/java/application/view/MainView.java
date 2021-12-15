package application.view;

import application.helpers.NetworkService;
import application.models.Welcome;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class MainView {
    public static final int HEIGHT = 200;
    public static final int WIDTH = 300;

    private TextField searchField;
    private Scene mainScene;
    private Pane mainPane;
    private Label headLabel;
    private Label headCityLabel;
    private Label headTempLabel;
    private Label headCurWeatherLabel;
    private Label headWeatherDescLabel;
    private Button sendToApiButton;

    private NetworkService networkService = new NetworkService();
    private Welcome weatherObject;

    public MainView() {
        this.mainPane = new Pane();
        this.mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        initContent();
    }

    private void initContent() {
        this.headLabel = new Label();
        this.searchField = new TextField();
        this.sendToApiButton = new Button();
        this.headCityLabel = new Label();
        this.headTempLabel = new Label();
        this.headCurWeatherLabel = new Label();
        this.headWeatherDescLabel = new Label();
        headLabel.setText("Check your weather!");
        headLabel.setLabelFor(searchField);
        headLabel.setTranslateX(20);
        headLabel.setTranslateY(20);
        mainPane.getChildren().add(headLabel);
        searchField.setTranslateX(20);
        searchField.setTranslateY(40);
        mainPane.getChildren().add(searchField);
        sendToApiButton.setTranslateX(190);
        sendToApiButton.setTranslateY(40);
        sendToApiButton.setText("Send");
        sendToApiButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                weatherObject = networkService.getWeather(searchField.getText());
                headCityLabel.setText("City: " + weatherObject.getName());
                headTempLabel.setText("Temperature: " + Double.toString(weatherObject.getMain().getTemp()));
                headCurWeatherLabel.setText("Current weather: " + weatherObject.getWeather().get(0).getMain());
                headWeatherDescLabel.setText("Weather description: " + weatherObject.getWeather().get(0).getDescription());
            }
        });
        headCityLabel.setText("City: ");
        headCityLabel.setTranslateX(20);
        headCityLabel.setTranslateY(80);
        headTempLabel.setText("Temperature: ");
        headTempLabel.setTranslateX(20);
        headTempLabel.setTranslateY(100);
        headCurWeatherLabel.setText("Current weather: ");
        headCurWeatherLabel.setTranslateX(20);
        headCurWeatherLabel.setTranslateY(120);
        headWeatherDescLabel.setText("Weather description: ");
        headWeatherDescLabel.setTranslateX(20);
        headWeatherDescLabel.setTranslateY(140);
        mainPane.getChildren().add(headCityLabel);
        mainPane.getChildren().add(headTempLabel);
        mainPane.getChildren().add(headCurWeatherLabel);
        mainPane.getChildren().add(headWeatherDescLabel);
        mainPane.getChildren().add(sendToApiButton);
    }


    public Scene getMainScene() {
        return mainScene;
    }
}
