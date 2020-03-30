package ui.sceneControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private void startGame(ActionEvent event) {
        this.application.setGameScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
