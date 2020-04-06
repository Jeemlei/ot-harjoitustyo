package logicTests;

import domain.GameServices;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author Eemeli
 */
public class GameServicesTest {

    GameServices game;

    public GameServicesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.game = new GameServices();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addPlayer() {
        this.game.addPlayer("a");
        int playerCount = this.game.getPlayerCount();
        assertThat(playerCount, is(1));
    }

    @Test
    public void addTooManyPlayers() {
        for (int i = 0; i < 9; i++) {
            this.game.addPlayer(Integer.toString(i));
        }
        int playerCount = this.game.getPlayerCount();
        assertThat(playerCount, is(8));
    }

    @Test
    public void addNamelessPlayer() {
        this.game.addPlayer("");
        int playerCount = this.game.getPlayerCount();
        assertThat(playerCount, is(0));
    }

    @Test
    public void addPlayerAlreadyInGame() {
        this.game.addPlayer("a");
        this.game.addPlayer("a");
        int playerCount = this.game.getPlayerCount();
        assertThat(playerCount, is(1));
    }
    
    @Test
    public void removePlayer() {
        this.game.addPlayer("a");
        this.game.removePlayer(0);
        int playerCount = this.game.getPlayerCount();
        assertThat(playerCount, is(0));
    }
    
    @Test
    public void removeRightPlayer() {
        this.game.addPlayer("a");
        this.game.addPlayer("b");
        this.game.addPlayer("c");
        this.game.removePlayer(1);
        String playerA = this.game.getPlayers().get(0);
        assertThat(playerA, is("a"));
        String playerC = this.game.getPlayers().get(1);
        assertThat(playerC, is("c"));
    }
    
    @Test
    public void removePlayerNotExisting() {
        this.game.addPlayer("a");
        this.game.removePlayer(1);
        int playerCount = this.game.getPlayerCount();
        assertThat(playerCount, is(1));
    }
}
