package domain.deck;

/**
 * Representation of the end card type. Used as a flag for the end of the game.
 * Every method returns a zero or an empty string.
 *
 * @author Eemeli
 */
public class EndCard implements Card {

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public int getType() {
        return Card.END_CARD;
    }

    @Override
    public int getPcsRandom(int playerCount) {
        return 0;
    }

    @Override
    public int getPcsFirst(int playerCount) {
        return 0;
    }

    @Override
    public int getPcsSecond(int playerCount) {
        return 0;
    }

    @Override
    public int getPcsThird(int playerCount) {
        return 0;
    }

    @Override
    public int getPcsFourth(int playerCount) {
        return 0;
    }
}
