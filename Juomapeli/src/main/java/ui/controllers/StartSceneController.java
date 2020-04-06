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
public class StartSceneController implements Initializable {

    private GameServices game;
    private JuomapeliUI application;

    public void setGameDomain(GameServices gameServices) {
        this.game = gameServices;
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

    private Label[] playerLabels;

    @FXML
    private void addPlayer(ActionEvent event) {
        String playerName = this.playerTextField.getText();
        if (this.game.addPlayer(playerName)) {
            this.warningLabel.setText("");
            this.playerTextField.setText("");
            int playerNo = this.game.getPlayerCount() - 1;
            this.playerLabels[playerNo].setText(playerName);
        } else {
            this.warningLabel.setText("Pelaajan lisääminen epäonnistui!");
        }
    }

    @FXML
    private void startGame(ActionEvent event) {
        int playerCount = this.game.getPlayerCount();
        if (playerCount >= 3) {
            this.application.setGameScene();
        } else {
            this.warningLabel.setText("Liian vähän pelaajia!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Label[] labels = {this.player1, this.player2, this.player3, this.player4,
            this.player5, this.player6, this.player7, this.player8};
        this.playerLabels = labels;
    }
}
