package ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import domain.GameServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ui.JuomapeliUI;

/**
 * FXML Controller class for the forfeit scene.
 *
 * @author Eemeli
 */
public class ForfeitSceneController implements Initializable {

    private GameServices game;
    private JuomapeliUI application;

    /**
     * Sets the game logic used by this controller.
     *
     * @param gameServices object with the game services
     */
    public void setGameDomain(GameServices gameServices) {
        this.game = gameServices;
    }

    /**
     * Sets the main UI-class used by this controller.
     *
     * @param application UI with a scene controlled by this controller
     */
    public void setApplication(JuomapeliUI application) {
        this.application = application;
    }

    /**
     * Updates the playerName-Label with the name of the player currently in
     * turn.
     */
    public void updatePlayer() {
        this.playerName.setText(this.game.getPlayerInTurn());
    }

    @FXML
    private Label playerName;

    @FXML
    private void forfeit(ActionEvent event) {
        this.game.forfeitPlayerInTurn();
        this.application.setGameScene();
    }

    @FXML
    private void cancel(ActionEvent event) {
        this.application.setGameScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
