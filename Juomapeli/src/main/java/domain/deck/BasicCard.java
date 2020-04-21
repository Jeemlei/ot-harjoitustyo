package domain.deck;

/**
 * Representation of the basic card type.
 *
 * @author Eemeli
 */
public class BasicCard implements Card {

    private final String name;
    private final String description;
    private final int[] pcs4;
    private final int[] pcs8;

    /**
     * Basic card object.
     *
     * @param name name of the card
     *
     * @param description description of the card
     *
     * @param pcs4 occurrences in the different parts of the deck in a game with
     * a maximum of four (4) players
     *
     * @param pcs8 occurrences in the different parts of the deck in a game with
     * a maximum of eight (8) players
     */
    public BasicCard(String name, String description, int[] pcs4, int[] pcs8) {
        this.name = name;
        this.description = description;
        this.pcs4 = pcs4;
        this.pcs8 = pcs8;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getType() {
        return Card.BASIC_CARD;
    }

    @Override
    public int getPcsRandom(int playerCount) {
        if (playerCount <= 4) {
            return this.pcs4[0];
        }
        return this.pcs8[0];
    }

    @Override
    public int getPcsFirst(int playerCount) {
        if (playerCount <= 4) {
            return this.pcs4[1];
        }
        return this.pcs8[1];
    }

    @Override
    public int getPcsSecond(int playerCount) {
        if (playerCount <= 4) {
            return this.pcs4[2];
        }
        return this.pcs8[2];
    }

    @Override
    public int getPcsThird(int playerCount) {
        if (playerCount <= 4) {
            return this.pcs4[3];
        }
        return this.pcs8[3];
    }

    @Override
    public int getPcsFourth(int playerCount) {
        if (playerCount <= 4) {
            return this.pcs4[4];
        }
        return this.pcs8[4];
    }
}
