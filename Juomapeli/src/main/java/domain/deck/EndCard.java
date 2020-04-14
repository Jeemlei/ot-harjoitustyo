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
        return 0;
    }

    @Override
    public int getPcsRandom(int palyerCount) {
        return 0;
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
