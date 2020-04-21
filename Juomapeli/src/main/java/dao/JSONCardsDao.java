package dao;

import domain.deck.BasicCard;
import domain.deck.Card;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Data access object for accessing card info in a JSON file
 *
 * @author Eemeli
 */
public class JSONCardsDao implements CardsDao {

    private JSONObject jsonFile;
    private ArrayList<Card> cards;

    /**
     * Fetches and parses JSON from resources containing card information.
     *
     * @throws IOException error during the access of the JSON
     */
    public JSONCardsDao() throws IOException {
        this.getJSON();
        this.parseCards();
    }

    private void getJSON() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream stream = classLoader.getResourceAsStream("cards.json");
        InputStreamReader isr = new InputStreamReader(stream, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        stream.close();
        this.jsonFile = new JSONObject(sb.toString());
    }

    private void parseCards() {
        this.cards = new ArrayList<>();
        this.parseBasicCards();
    }

    private void parseBasicCards() {
        JSONArray cardArr = this.jsonFile.getJSONArray("basicCards");
        for (int i = 0; i < cardArr.length(); i++) {
            String name = cardArr.getJSONObject(i).getString("name");
            String description = cardArr.getJSONObject(i).getString("description");
            int[] pcs4 = parsePcsArray(cardArr.getJSONObject(i).getJSONArray("max4plrs"));
            int[] pcs8 = parsePcsArray(cardArr.getJSONObject(i).getJSONArray("max8plrs"));
            this.cards.add(new BasicCard(name, description, pcs4, pcs8));
        }
    }

    private int[] parsePcsArray(JSONArray json) {
        int[] arr = new int[json.length()];
        for (int i = 0; i < json.length(); i++) {
            arr[i] = json.getInt(i);
        }
        return arr;
    }

    @Override
    public ArrayList<Card> getAll() {
        return this.cards;
    }
}
