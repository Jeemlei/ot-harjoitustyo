package ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import domain.GameServices;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
