package domain.deck;

/**
 * Representation of the rule card type.
 *
 * @author Eemeli
 */
public class RuleCard implements Card {

    private String name;
    private String description;
    private final int[] pcs4;
    private final int[] pcs8;
    private boolean editable;

    /**
     * Rule card object.
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
    public RuleCard(String name, String description, int[] pcs4, int[] pcs8) {
        this.name = name;
        this.description = description;
        this.pcs4 = pcs4;
        this.pcs8 = pcs8;
        this.editable = name.isEmpty();
    }

    @Override
    public int getType() {
        return Card.RULE_CARD;
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

    /**
     * Tells if rule is editable.
     * 
     * @return true if rule is editable, otherwise false
     */
    public boolean isEditable() {
        return this.editable;
    }
    
    /**
     * Changes the name and the description of the RuleCard if editable.
     * 
     * @param name name of the rule
     * 
     * @param description description of the rule
     */
    public void setRule(String name, String description) {
        if (this.editable) {
            this.name = name;
            this.description = description;
            this.editable = false;
        }
    }
}
