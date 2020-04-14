package ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import domain.GameServices;
import domain.deck.Card;
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

    public void start() {
        this.updateCardInfo();
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
        this.application.setForfeitScene();
    }

    @FXML
    private void nextCard(ActionEvent event) {
        this.updateCardInfo();
    }

    @FXML
    private void rollDice(ActionEvent event) {

    }

    private void updateCardInfo() {
        Card card = this.game.nextCard();
        switch (card.getType()) {
            case 0:
                this.endCard();
                break;
            case 1:
                this.basicCard(card);
        }
    }

    private void basicCard(Card card) {
        this.cardName.setText(card.getName());
        this.cardDescription.setText(card.getDescription());
    }

    private void endCard() {
        this.application.setStartScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
