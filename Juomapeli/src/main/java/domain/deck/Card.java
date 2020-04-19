package domain.deck;

/**
 *
 * @author Eemeli
 */
public interface Card {
    
    static final int END_CARD = 0;
    static final int BASIC_CARD = 1;
    
    public abstract int getType();

    public abstract String getName();

    public abstract String getDescription();
    
    public abstract int getPcsRandom(int playerCount);
    
    public abstract int getPcsFirst(int playerCount);
    
    public abstract int getPcsSecond(int playerCount);
    
    public abstract int getPcsThird(int playerCount);
    
    public abstract int getPcsFourth(int playerCount);
}
