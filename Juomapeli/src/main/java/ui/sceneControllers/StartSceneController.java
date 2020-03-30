package ui.sceneControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import juomapeli.GameDomain;
import ui.JuomapeliUI;

/**
 * FXML Controller class
 *
 * @author Eemeli
 */
public class StartSceneController implements Initializable {

    private GameDomain game;
    private JuomapeliUI application;

    public void setGameDomain(GameDomain gameDomain) {
        this.game = gameDomain;
    }

    public void setApplication(JuomapeliUI application) {
        this.application = application;
    }

    @FXML
    private TextField playerTextField;

    @FXML
    private Label warningLabel;

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
        String playerName = this.playerTextField.getText();
        if (this.game.addPlayer(playerName)) {
            this.warningLabel.setText("");
            this.playerTextField.setText("");
            int playerNo = this.game.getPlayerCount();
            switch (playerNo) {
                case 1:
                    this.player1.setText(playerName);
                    break;
                case 2:
                    this.player2.setText(playerName);
                    break;
                case 3:
                    this.player3.setText(playerName);
                    break;
                case 4:
                    this.player4.setText(playerName);
                    break;
                case 5:
                    this.player5.setText(playerName);
                    break;
                case 6:
                    this.player6.setText(playerName);
                    break;
                case 7:
                    this.player7.setText(playerName);
                    break;
                case 8:
                    this.player8.setText(playerName);
                    break;
            }
        } else {
            this.warningLabel.setText("Pelaajan lisääminen epäonnistui!");
        }
    }

    @FXML
    private void startGame(ActionEvent event) {
        this.application.setGameScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
