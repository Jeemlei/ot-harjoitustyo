package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import domain.GameServices;
import ui.controllers.StartSceneController;
import ui.controllers.GameSceneController;
import ui.controllers.ForfeitSceneController;

/**
 *
 * @author Eemeli
 */
public class JuomapeliUI extends Application {

    private Stage stage;
    private GameServices game;
    private Scene startScene;
    private Scene gameScene;
    private GameSceneController gameSceneController;
    private Scene forfeitScene;

    @Override
    public void init() throws Exception {
        this.game = new GameServices();
        
        FXMLLoader startSceneLoader = new FXMLLoader(getClass().getResource("/fxml/StartScene.fxml"));
        Parent startPane = startSceneLoader.load();
        StartSceneController startSceneController = startSceneLoader.getController();
        startSceneController.setGameDomain(this.game);
        startSceneController.setApplication(this);
        this.startScene = new Scene(startPane);

        FXMLLoader gameSceneLoader = new FXMLLoader(getClass().getResource("/fxml/GameScene.fxml"));
        Parent gamePane = gameSceneLoader.load();
        this.gameSceneController = gameSceneLoader.getController();
        this.gameSceneController.setGameDomain(this.game);
        this.gameSceneController.setApplication(this);
        this.gameScene = new Scene(gamePane);

        FXMLLoader forfeitSceneLoader = new FXMLLoader(getClass().getResource("/fxml/ForfeitScene.fxml"));
        Parent forfeitPane = forfeitSceneLoader.load();
        ForfeitSceneController forfeitSceneController = forfeitSceneLoader.getController();
        forfeitSceneController.setGameDomain(this.game);
        forfeitSceneController.setApplication(this);
        this.forfeitScene = new Scene(forfeitPane);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        stage.setTitle("Juomapeli");
        this.setStartScene();
        stage.show();
    }
    
    public void startNewGame() {
        this.setGameScene();
        this.gameSceneController.start();
    }

    public void setStartScene() {
        this.stage.setScene(this.startScene);
    }

    public void setGameScene() {
        this.stage.setScene(this.gameScene);
    }
    
    public void setForfeitScene() {
        this.stage.setScene(this.forfeitScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
