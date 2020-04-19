package logicTests;

import dao.JSONCardsDao;
import domain.deck.Card;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author Eemeli
 */
public class DaoTest {

    JSONCardsDao jsonDao;

    public DaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        this.jsonDao = new JSONCardsDao();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAtleastOneCardInArrayList() {
        ArrayList<Card> c = this.jsonDao.getAll();
        assertThat(c.size() > 0, is(true));
    }
}
