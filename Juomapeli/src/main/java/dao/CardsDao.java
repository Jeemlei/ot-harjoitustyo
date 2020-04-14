package dao;

import domain.deck.Card;
import java.util.ArrayList;

/**
 *
 * @author Eemeli
 */
public interface CardsDao {

    ArrayList<Card> getAll() throws Exception;
}
