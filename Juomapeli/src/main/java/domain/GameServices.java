package domain;

import domain.deck.Card;
import domain.deck.Deck;
import domain.deck.EndCard;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Eemeli
 */
public class GameServices {

    private ArrayList<String> players;
    private Deck deck;
    private int turn;
    private Card cardInTurn;

    public GameServices() {
        this.players = new ArrayList<>();
    }

    public String addPlayer(String playerName) {
        playerName = playerName.trim();
        if (this.players.contains(playerName)) {
            return "Pelaaja on jo lisätty!";
        } else if (playerName.length() < 1) {
            return "Kirjoita pelaajan nimi!";
        } else if (this.players.size() >= 8) {
            return "Peli on täynnä!";
        }
        this.players.add(playerName);
        return "";
    }

    public String removePlayer(int playerNo) {
        if (playerNo >= this.players.size() || playerNo < 0) {
            return "Pelaajan poistaminen epäonnistui!";
        }
        this.players.remove(playerNo);
        return "";
    }

    public void initGame() {
        this.deck = new Deck(this.getPlayerCount());
        this.deck.generateNewDeck();
        this.cardInTurn = this.deck.nextCard();
    }

    public void nextTurn() {
        this.turn++;
        if (this.turn >= this.getPlayerCount()) {
            this.turn = 0;
        }
        this.cardInTurn = this.deck.nextCard();
    }

    public int rollDice(int faces) {
        return new Random().nextInt(faces) + 1;
    }

    public void forfeitPlayerInTurn() {
        this.removePlayer(this.turn);
        if (this.getPlayerCount() <= 1) {
            this.deck.addCardOnTop(new EndCard());
        }
        this.turn--;
        this.nextTurn();
    }

    public int getPlayerCount() {
        return this.players.size();
    }

    public ArrayList<String> getPlayers() {
        return this.players;
    }

    public Card getCardInTurn() {
        return this.cardInTurn;
    }

    public String getPlayerInTurn() {
        return this.players.get(this.turn);
    }
}
