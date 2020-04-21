package dao;

import domain.deck.Card;
import java.util.ArrayList;

/**
 * Interface for accessing card information in files, databases etc.
 *
 * @author Eemeli
 */
public interface CardsDao {

    /**
     * Gives all the different cards from external source.
     *
     * @return ArrayList of Card-objects
     */
    ArrayList<Card> getAll();
}
