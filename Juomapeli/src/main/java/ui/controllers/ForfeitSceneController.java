package ui.controllers;

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
public class ForfeitSceneController implements Initializable {

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
