package domain.deck;

/**
 *
 * @author Eemeli
 */
public interface Card {

    public abstract String getName();

    public abstract String getDescription();
    
    public abstract int getType();
    
    public abstract int getPcsRandom(int palyerCount);
    
    public abstract int getPcsFirst(int palyerCount);
    
    public abstract int getPcsSecond(int palyerCount);
    
    public abstract int getPcsThird(int palyerCount);
    
    public abstract int getPcsFourth(int palyerCount);
}
