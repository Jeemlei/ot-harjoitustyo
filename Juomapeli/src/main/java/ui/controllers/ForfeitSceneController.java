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
 * FXML Controller class
 *
 * @author Eemeli
 */
public class ForfeitSceneController implements Initializable {

    private GameServices game;
    private JuomapeliUI application;

    public void setGameDomain(GameServices gameServices) {
        this.game = gameServices;
    }

    public void setApplication(JuomapeliUI application) {
        this.application = application;
    }
    
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
