package domain.deck;

/**
 * Interface for different types of cards.
 *
 * @author Eemeli
 */
public interface Card {

    /**
     * The card type constant for EndCard
     */
    static final int END_CARD = 0;
    /**
     * The card type constant for BasicCard
     */
    static final int BASIC_CARD = 1;

    /**
     * Tells the type of the card.
     *
     * @return the card type constant for this card
     */
    public abstract int getType();

    /**
     * Tells the name of the card.
     *
     * @return the name of the card
     */
    public abstract String getName();

    /**
     * Tells the description of the card.
     *
     * @return the description of the card
     */
    public abstract String getDescription();

    /**
     * Tells how many times at least this card can occur anywhere in the deck.
     *
     * @param playerCount the number of players in the game
     *
     * @return occurrences anywhere in the deck
     */
    public abstract int getPcsRandom(int playerCount);

    /**
     * Tells how many times at least this card can occur in the first quarter of
     * the deck.
     *
     * @param playerCount the number of players in the game
     *
     * @return occurrences in the first quarter of the deck
     */
    public abstract int getPcsFirst(int playerCount);

    /**
     * Tells how many times at least this card can occur in the second quarter
     * of the deck.
     *
     * @param playerCount the number of players in the game
     *
     * @return occurrences in the second quarter of the deck
     */
    public abstract int getPcsSecond(int playerCount);

    /**
     * Tells how many times at least this card can occur in the third quarter of
     * the deck.
     *
     * @param playerCount the number of players in the game
     *
     * @return occurrences in the third quarter of the deck
     */
    public abstract int getPcsThird(int playerCount);

    /**
     * Tells how many times at least this card can occur in the fourth quarter
     * of the deck.
     *
     * @param playerCount the number of players in the game
     *
     * @return occurrences in the fourth quarter of the deck
     */
    public abstract int getPcsFourth(int playerCount);
}
