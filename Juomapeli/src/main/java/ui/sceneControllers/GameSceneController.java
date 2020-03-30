package ui.sceneControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import juomapeli.GameDomain;
import ui.JuomapeliUI;

/**
 * FXML Controller class
 *
 * @author Eemeli
 */
public class GameSceneController implements Initializable {
    
    private GameDomain game;
    private JuomapeliUI application;
    
    public void setGameDomain(GameDomain gameDomain) {
        this.game = gameDomain;
    }
    
    public void setApplication(JuomapeliUI application) {
        this.application = application;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
