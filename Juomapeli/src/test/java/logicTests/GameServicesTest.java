package logicTests;

import domain.GameServices;
import domain.deck.Card;
import domain.deck.EndCard;
import domain.deck.RuleCard;
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
    
    private void addPlayers(int count) {
        String p = "Player";
        for (int i = 0; i < count; i++) {
            this.game.addPlayer(p + i);
        }
    }

    @Test
    public void addPlayer() {
        this.addPlayers(1);
        int playerCount = this.game.getPlayerCount();
        assertThat(playerCount, is(1));
    }

    @Test
    public void addTooManyPlayers() {
        this.addPlayers(9);
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
        this.addPlayers(1);
        this.addPlayers(1);
        int playerCount = this.game.getPlayerCount();
        assertThat(playerCount, is(1));
    }
    
    @Test
    public void removePlayer() {
        this.addPlayers(1);
        this.game.removePlayer(0);
        int playerCount = this.game.getPlayerCount();
        assertThat(playerCount, is(0));
    }
    
    @Test
    public void removeRightPlayer() {
        this.addPlayers(3);
        this.game.removePlayer(1);
        String player1 = this.game.getPlayers().get(0);
        assertThat(player1, is("Player0"));
        String player3 = this.game.getPlayers().get(1);
        assertThat(player3, is("Player2"));
    }
    
    @Test
    public void removePlayerNotExisting() {
        this.addPlayers(1);
        this.game.removePlayer(1);
        this.game.removePlayer(-1);
        int playerCount = this.game.getPlayerCount();
        assertThat(playerCount, is(1));
    }
    
    @Test
    public void rollDiceGivesNumber() {
        int n = this.game.rollDice(1);
        assertThat(n, is(1));
    }
    
    @Test
    public void initializeGameDeckWithMinPlayers() {
        this.addPlayers(3);
        this.game.initGame();
        assertThat(this.game.getCardInTurn(), instanceOf(Card.class));
    }
    
    @Test
    public void initializeGameDeckWithMaxPlayers() {
        this.addPlayers(8);
        this.game.initGame();
        assertThat(this.game.getCardInTurn(), instanceOf(Card.class));
    }
    
    @Test
    public void nextTurnLoops() {
        this.addPlayers(3);
        this.game.initGame();
        for (int i = 0; i < 5; i++) {
            this.game.nextTurn();
        }
        assertThat(this.game.getPlayerInTurn(), is("Player2"));
    }
    
    @Test
    public void firstAddedPlayerForfeits() {
        this.addPlayers(3);
        this.game.initGame();
        this.game.forfeitPlayerInTurn();
        assertThat(this.game.getPlayerCount(), is(2));
        assertThat(this.game.getPlayerInTurn(), is("Player1"));
    }
    
    @Test
    public void lastAddedPlayerForfeits() {
        this.addPlayers(3);
        this.game.initGame();
        this.game.nextTurn();
        this.game.nextTurn();
        this.game.forfeitPlayerInTurn();
        assertThat(this.game.getPlayerCount(), is(2));
        assertThat(this.game.getPlayerInTurn(), is("Player0"));
    }
    
    @Test
    public void endCardAddedWhenOnlyOnePlayerLeft() {
        this.addPlayers(3);
        this.game.initGame();
        this.game.forfeitPlayerInTurn();
        this.game.forfeitPlayerInTurn();
        assertThat(this.game.getCardInTurn(), instanceOf(EndCard.class));
    }
    
    @Test
    public void editableRuleCanBeEdited() {
        RuleCard card = new RuleCard("", "", new int[0], new int[0]);
        card.setRule("A", "A");
        assertThat(card.getDescription(), is("A"));
    }
    
    @Test
    public void uneditableRuleCanNotBeEdited() {
        RuleCard card = new RuleCard("A", "", new int[0], new int[0]);
        card.setRule("A", "A");
        assertThat(card.getDescription(), is(""));
    }
}
