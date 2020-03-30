package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.sceneControllers.*;

/**
 *
 * @author Eemeli
 */
public class JuomapeliUI extends Application {

    private Stage stage;
    private Scene startScene;
    private Scene gameScene;

    @Override
    public void init() throws Exception {
        FXMLLoader startSceneLoader = new FXMLLoader(getClass().getResource("/fxml/StartScene.fxml"));
        Parent startPane = startSceneLoader.load();
        StartSceneController startSceneController = startSceneLoader.getController();
        startSceneController.setApplication(this);
        this.startScene = new Scene(startPane);

        FXMLLoader gameSceneLoader = new FXMLLoader(getClass().getResource("/fxml/GameScene.fxml"));
        Parent gamePane = gameSceneLoader.load();
        GameSceneController gameSceneController = gameSceneLoader.getController();
        gameSceneController.setApplication(this);
        this.gameScene = new Scene(gamePane);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        stage.setTitle("Juomapeli");
        this.setStartScene();
        stage.show();
    }

    public void setStartScene() {
        this.stage.setScene(this.startScene);
    }

    public void setGameScene() {
        this.stage.setScene(this.gameScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
