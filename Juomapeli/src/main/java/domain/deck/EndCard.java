package domain.deck;

/**
 *
 * @author Eemeli
 */
public class EndCard implements Card {
    
    @Override
    public String getName() {
        return "Viimeinen kortti!";
    }

    @Override
    public String getDescription() {
        return "Peli on ohi!";
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
