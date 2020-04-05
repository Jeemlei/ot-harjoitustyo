package juomapeli;

import java.util.HashSet;

/**
 *
 * @author Eemeli
 */
public class GameServices {

    private HashSet<String> players;

    public GameServices() {
        this.players = new HashSet<>();
    }

    public boolean addPlayer(String playerName) {
        if (this.players.contains(playerName)
                || playerName.length() < 1
                || this.players.size() >= 8) {
            return false;
        }
        this.players.add(playerName);
        return true;
    }

    public int getPlayerCount() {
        return this.players.size();
    }
}
