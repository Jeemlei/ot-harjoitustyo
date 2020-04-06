package logicTests;

import domain.GameServices;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
}
