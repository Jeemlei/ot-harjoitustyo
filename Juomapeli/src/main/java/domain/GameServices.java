package domain;

import java.util.ArrayList;

/**
 *
 * @author Eemeli
 */
public class GameServices {

    private ArrayList<String> players;

    public GameServices() {
        this.players = new ArrayList<>();
    }

    public String addPlayer(String playerName) {
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

    public int getPlayerCount() {
        return this.players.size();
    }
    
    public ArrayList<String> getPlayers() {
        return this.players;
    }

    public String removePlayer(int playerNo) {
        if (playerNo >= this.players.size()) {
            return "Pelaajan poistaminen epäonnistui!";
        }
        this.players.remove(playerNo);
        return "";
    }
}
