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
 * Main class for controlling the UI.
 *
 * @author Eemeli
 */
public class JuomapeliUI extends Application {

    private Stage stage;
    private GameServices game;
    private Scene startScene;
    private StartSceneController startSceneController;
    private Scene gameScene;
    private GameSceneController gameSceneController;
    private Scene forfeitScene;
    private ForfeitSceneController forfeitSceneController;

    /**
     * Injects game logic dependencies to the UI-controllers
     *
     * @throws Exception error with the FXML-resources
     */
    @Override
    public void init() throws Exception {
        this.game = new GameServices();

        FXMLLoader startSceneLoader = new FXMLLoader(getClass().getResource("/fxml/StartScene.fxml"));
        Parent startPane = startSceneLoader.load();
        this.startSceneController = startSceneLoader.getController();
        this.startSceneController.setGameDomain(this.game);
        this.startSceneController.setApplication(this);
        this.startScene = new Scene(startPane);

        FXMLLoader gameSceneLoader = new FXMLLoader(getClass().getResource("/fxml/GameScene.fxml"));
        Parent gamePane = gameSceneLoader.load();
        this.gameSceneController = gameSceneLoader.getController();
        this.gameSceneController.setGameDomain(this.game);
        this.gameSceneController.setApplication(this);
        this.gameScene = new Scene(gamePane);

        FXMLLoader forfeitSceneLoader = new FXMLLoader(getClass().getResource("/fxml/ForfeitScene.fxml"));
        Parent forfeitPane = forfeitSceneLoader.load();
        this.forfeitSceneController = forfeitSceneLoader.getController();
        this.forfeitSceneController.setGameDomain(this.game);
        this.forfeitSceneController.setApplication(this);
        this.forfeitScene = new Scene(forfeitPane);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        stage.setTitle("Juomapeli");
        this.setStartScene();
        stage.show();
    }

    /**
     * Sets the start scene on the stage and calls the controller to update the
     * scene.
     *
     * @see ui.controllers.StartSceneController#update()
     */
    public void setStartScene() {
        this.stage.setScene(this.startScene);
        this.startSceneController.update();
    }

    /**
     * Sets the game scene on the stage and calls the controller to update the
     * scene.
     *
     * @see ui.controllers.GameSceneController#update()
     */
    public void setGameScene() {
        this.stage.setScene(this.gameScene);
        this.gameSceneController.update();
    }

    /**
     * Sets the forfeit scene on the stage and calls the controller to update
     * the playerName label.
     *
     * @see ui.controllers.ForfeitSceneController#updatePlayer()
     */
    public void setForfeitScene() {
        this.stage.setScene(this.forfeitScene);
        this.forfeitSceneController.updatePlayer();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
