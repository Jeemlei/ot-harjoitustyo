package domain.deck;

/**
 *
 * @author Eemeli
 */
public class BasicCard implements Card {
    
    private final String name;
    private final String description;
    private final int[] pcs4;
    private final int[] pcs8;

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
        return 1;
    }

    @Override
    public int getPcsRandom(int palyerCount) {
        if (palyerCount<=4) {
            return this.pcs4[0];
        }
        return this.pcs8[0];
    }

    @Override
    public int getPcsFirst(int palyerCount) {
        return 0;
    }

    @Override
    public int getPcsSecond(int palyerCount) {
        return 0;
    }

    @Override
    public int getPcsThird(int palyerCount) {
        return 0;
    }

    @Override
    public int getPcsFourth(int palyerCount) {
        return 0;
    }
}
