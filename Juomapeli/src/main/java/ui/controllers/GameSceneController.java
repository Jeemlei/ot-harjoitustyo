package ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import domain.GameServices;
import ui.JuomapeliUI;

/**
 * FXML Controller class
 *
 * @author Eemeli
 */
public class GameSceneController implements Initializable {
    
    private GameServices game;
    private JuomapeliUI application;
    
    public void setGameDomain(GameServices gameServices) {
        this.game = gameServices;
    }
    
    public void setApplication(JuomapeliUI application) {
        this.application = application;
    }
    
    @FXML
    private Label playerName;
    
    @FXML
    private Label cardName;
    
    @FXML
    private Label cardDescription;
    
    @FXML
    private Label diceDisplay;

    @FXML
    private void forfeit(ActionEvent event) {
        
    }

    @FXML
    private void nextCard(ActionEvent event) {
        
    }

    @FXML
    private void rollDice(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
