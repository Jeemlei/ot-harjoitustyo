package domain.deck;

import dao.CardsDao;
import dao.JSONCardsDao;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Random;

/**
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

    public Deck(int playerCount) {
        this.playerCount = playerCount;
        try {
            CardsDao cardsDao = new JSONCardsDao();
            this.differentCards = cardsDao.getAll();
        } catch (Exception ex) {
            System.out.println("Cards resource missing");
        }
    }

    public void generateNewDeck() {
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
                case 1:
                    this.addBasicCard(card);
            }
        }
    }

    private void addBasicCard(Card card) {
        Random r = new Random();
        for (int i = 0; i < card.getPcsRandom(playerCount); i++) {
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
    }
    
    public void addCardOnTop(Card card) {
        this.deck.addFirst(card);
    }

    public Card nextCard() {
        return this.deck.pollFirst();
    }
}
