package domain.deck;

import dao.CardsDao;
import dao.JSONCardsDao;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Random;

/**
 * Deck for handling cards.
 *
 * @author Eemeli
 */
public class Deck {

    private int playerCount;
    private ArrayList<Card> differentCards;
    private ArrayList<Card> pcsFirst;
    private ArrayList<Card> pcsSecond;
    private ArrayList<Card> pcsThird;
    private ArrayList<Card> pcsFourth;
    private Deque<Card> deck;

    /**
     * Fetches the different kind of cards with a DAO.
     */
    public Deck() {
        try {
            CardsDao cardsDao = new JSONCardsDao();
            this.differentCards = cardsDao.getAll();
        } catch (Exception ex) {
            System.out.println("Cards resource missing");
        }
    }

    /**
     * Generates and shuffles a new deck, based on the number of players in the
     * game.
     *
     * @param playerCount the number of players in the game
     */
    public void generateNewDeck(int playerCount) {
        this.playerCount = playerCount;
        this.deck = new ArrayDeque<>();

        this.generateNewQuarters();

        Collections.shuffle(pcsFirst);
        Collections.shuffle(pcsSecond);
        Collections.shuffle(pcsThird);
        Collections.shuffle(pcsFourth);

        pcsFirst.forEach((card) -> {
            this.deck.addLast(card);
        });
        pcsSecond.forEach((card) -> {
            this.deck.addLast(card);
        });
        pcsThird.forEach((card) -> {
            this.deck.addLast(card);
        });
        pcsFourth.forEach((card) -> {
            this.deck.addLast(card);
        });
        this.deck.addLast(new EndCard());
    }

    private void generateNewQuarters() {
        this.pcsFirst = new ArrayList<>();
        this.pcsSecond = new ArrayList<>();
        this.pcsThird = new ArrayList<>();
        this.pcsFourth = new ArrayList<>();
        for (int i = 0; i < this.differentCards.size(); i++) {
            Card card = this.differentCards.get(i);
            switch (card.getType()) {
                case Card.BASIC_CARD:
                    this.addBasicCard(card);
                    break;
                case Card.RULE_CARD:
                    this.addRuleCard(card);
                    break;
            }
        }
    }

    private void addBasicCard(Card card) {
        Random r = new Random();
        for (int i = 0; i < card.getPcsRandom(this.playerCount); i++) {
            switch (r.nextInt(4)) {
                case 0:
                    this.pcsFirst.add(new BasicCard(card.getName(), card.getDescription(), new int[0], new int[0]));
                    break;
                case 1:
                    this.pcsSecond.add(new BasicCard(card.getName(), card.getDescription(), new int[0], new int[0]));
                    break;
                case 2:
                    this.pcsThird.add(new BasicCard(card.getName(), card.getDescription(), new int[0], new int[0]));
                    break;
                case 3:
                    this.pcsFourth.add(new BasicCard(card.getName(), card.getDescription(), new int[0], new int[0]));
                    break;
            }
        }
        for (int i = 0; i < card.getPcsFirst(this.playerCount); i++) {
            this.pcsFirst.add(new BasicCard(card.getName(), card.getDescription(), new int[0], new int[0]));
        }
        for (int i = 0; i < card.getPcsSecond(this.playerCount); i++) {
            this.pcsSecond.add(new BasicCard(card.getName(), card.getDescription(), new int[0], new int[0]));
        }
        for (int i = 0; i < card.getPcsThird(this.playerCount); i++) {
            this.pcsThird.add(new BasicCard(card.getName(), card.getDescription(), new int[0], new int[0]));
        }
        for (int i = 0; i < card.getPcsFourth(this.playerCount); i++) {
            this.pcsFourth.add(new BasicCard(card.getName(), card.getDescription(), new int[0], new int[0]));
        }
    }

    private void addRuleCard(Card card) {
        Random r = new Random();
        for (int i = 0; i < card.getPcsRandom(this.playerCount); i++) {
            switch (r.nextInt(3)) {
                case 0:
                    this.pcsFirst.add(new RuleCard(card.getName(), card.getDescription(), new int[0], new int[0]));
                    break;
                case 1:
                    this.pcsSecond.add(new RuleCard(card.getName(), card.getDescription(), new int[0], new int[0]));
                    break;
                case 2:
                    this.pcsThird.add(new RuleCard(card.getName(), card.getDescription(), new int[0], new int[0]));
                    break;
            }
        }
    }

    /**
     * Adds a card on top of the deck.
     *
     * @param card the card to be added
     */
    public void addCardOnTop(Card card) {
        this.deck.addFirst(card);
    }

    /**
     * Pulls out the card on top of the deck.
     *
     * @return Card-object from the top of the deck
     */
    public Card nextCard() {
        if (this.deck.isEmpty()) {
            return new EndCard();
        }
        return this.deck.pollFirst();
    }
}
