package domain;

import domain.deck.Card;
import domain.deck.Deck;
import domain.deck.EndCard;
import java.util.ArrayList;
import java.util.Random;

/**
 * All the different game services used to initialize and control the flow of
 * the game.
 *
 * @author Eemeli
 */
public class GameServices {

    private ArrayList<String> players;
    private Deck deck;
    private int turn;
    private Card cardInTurn;

    /**
     * Creates new game platform.
     */
    public GameServices() {
        this.players = new ArrayList<>();
    }

    /**
     * Adds a new player in the game.
     *
     * @param playerName name of the player to be added
     *
     * @return possible error message
     */
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

    /**
     * Removes a player from the game.
     *
     * @param playerNo index of the player to be removed
     *
     * @return possible error message
     */
    public String removePlayer(int playerNo) {
        if (playerNo >= this.players.size() || playerNo < 0) {
            return "Pelaajan poistaminen epäonnistui!";
        }
        this.players.remove(playerNo);
        return "";
    }

    /**
     * Creates new Deck, based on the number of players in the game.
     */
    public void initGame() {
        this.deck = new Deck();
        this.deck.generateNewDeck(this.getPlayerCount());
        this.cardInTurn = this.deck.nextCard();
    }

    /**
     * Passes the turn to the next player and flips open a new card.
     */
    public void nextTurn() {
        this.turn++;
        if (this.turn >= this.getPlayerCount()) {
            this.turn = 0;
        }
        this.cardInTurn = this.deck.nextCard();
    }

    /**
     * Rolls a dice.
     *
     * @param faces the number of faces in the dice
     *
     * @return the rolled value
     */
    public int rollDice(int faces) {
        return new Random().nextInt(faces) + 1;
    }

    /**
     * Removes the player currently in turn and calls the .nextTurn() method
     *
     * @see domain.GameServices#nextTurn()
     */
    public void forfeitPlayerInTurn() {
        this.removePlayer(this.turn);
        if (this.getPlayerCount() <= 1) {
            this.deck.addCardOnTop(new EndCard());
        }
        this.turn--;
        this.nextTurn();
    }

    /**
     * Tells the number of players in the game.
     *
     * @return number of players in the game
     */
    public int getPlayerCount() {
        return this.players.size();
    }

    /**
     * Tells the names of the players in the game.
     *
     * @return ArrayList of the names of the players
     */
    public ArrayList<String> getPlayers() {
        return this.players;
    }

    /**
     * Tells the card currently flipped open.
     *
     * @return Card-object currently on top of the deck
     *
     * @see domain.GameServices#nextTurn()
     */
    public Card getCardInTurn() {
        return this.cardInTurn;
    }

    /**
     * Tells the player currently in turn.
     *
     * @return name of the player currently in turn
     */
    public String getPlayerInTurn() {
        return this.players.get(this.turn);
    }
}
