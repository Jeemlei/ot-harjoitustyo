package ui.sceneControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import ui.JuomapeliUI;

/**
 * FXML Controller class
 *
 * @author Eemeli
 */
public class StartSceneController implements Initializable {
    
    private JuomapeliUI application;
    
    public void setApplication(JuomapeliUI application) {
        this.application = application;
    }

    @FXML
    private TextField playerTextField;

    @FXML
    private Label player1;

    @FXML
    private Label player2;

    @FXML
    private Label player3;

    @FXML
    private Label player4;

    @FXML
    private Label player5;

    @FXML
    private Label player6;

    @FXML
    private Label player7;

    @FXML
    private Label player8;
    
    @FXML
    private void addPlayer(ActionEvent event) {
        
    }
    
    @FXML
    private void startGame(ActionEvent event) {
        this.application.setGameScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
