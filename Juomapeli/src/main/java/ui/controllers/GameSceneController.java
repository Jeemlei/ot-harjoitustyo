package ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import juomapeli.GameServices;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
