package ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import domain.GameServices;
import domain.deck.Card;
import domain.deck.RuleCard;
import java.util.ArrayList;
import ui.JuomapeliUI;

/**
 * FXML Controller class for the game scene.
 *
 * @author Eemeli
 */
public class GameSceneController implements Initializable {

    private GameServices game;
    private JuomapeliUI application;

    /**
     * Sets the game logic used by this controller.
     *
     * @param gameServices object with the game services
     */
    public void setGameDomain(GameServices gameServices) {
        this.game = gameServices;
    }

    /**
     * Sets the main UI-class used by this controller.
     *
     * @param application UI with a scene controlled by this controller
     */
    public void setApplication(JuomapeliUI application) {
        this.application = application;
    }

    /**
     * Updates the game scene.
     */
    public void update() {
        this.updatePlayerInTurn();
        this.updateCardInfo();
        this.updateActiveRules();
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
    private Label ruleCard1;

    @FXML
    private Label ruleCard2;

    @FXML
    private Label ruleCard3;

    private Label[] ruleCardLabels;

    @FXML
    private void forfeit(ActionEvent event) {
        this.application.setForfeitScene();
    }

    @FXML
    private void nextTurn(ActionEvent event) {
        this.game.nextTurn();
        this.update();
    }

    @FXML
    private void rollDice(ActionEvent event) {
        this.diceDisplay.setText("" + this.game.rollDice(6));
    }

    private void updatePlayerInTurn() {
        this.playerName.setText(this.game.getPlayerInTurn());
    }

    private void updateCardInfo() {
        Card card = this.game.getCardInTurn();
        switch (card.getType()) {
            case Card.END_CARD:
                this.endCard();
                break;
            case Card.BASIC_CARD:
                this.basicCard(card);
                break;
            case Card.RULE_CARD:
                this.ruleCard(card);
                break;
        }
    }

    private void updateActiveRules() {
        ArrayList<RuleCard> rules = this.game.getActiveRules();
        for (int i = 0; i < rules.size(); i++) {
            this.ruleCardLabels[i].setText(rules.get(i).getName());
        }
        for (int i = rules.size(); i < 3; i++) {
            this.ruleCardLabels[i].setText("");
        }
    }

    private void endCard() {
        this.application.setEndScene();
    }

    private void basicCard(Card card) {
        this.cardName.setText(card.getName());
        this.cardDescription.setText(card.getDescription());
    }
    
    private void ruleCard(Card card) {
        this.cardName.setText(card.getName());
        this.cardDescription.setText(card.getDescription());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Label[] labels = {this.ruleCard1, this.ruleCard2, this.ruleCard3};
        this.ruleCardLabels = labels;
    }
}
