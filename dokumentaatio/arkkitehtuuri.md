# Arkkitehtuurikuvaus

## Rakenne

Ohjelman arkkitehtuuri on kolmitasoinen ja näyttää seuraavalta:

![Pakkausrakenne](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/pakkausrakenne.png)

Pakkaus _ui_ sisältää FXML:llä toteutetun käyttöliittymän kontrollerit, _domain_ pelilogiikan ja _dao_ korttitietojen muistista hakemiseen liittyvän koodin.

<!---Viikkoon 4 mennessä toteutetut pelilogiikan kannalta oleelliset luokat:--->

<!---![vk4 luokkakaavio](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/luokkakaavio_vk4.png)--->

<!---GameServicen ja ohjelman muiden osien suhdetta kuvaava luokka/pakkauskaavio:--->

<!---![vk4 pakkausrakenne](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/pakkausrakenne_vk4.png)--->

### Päätoiminnalisuudet



#### Seuraavan kortin kääntäminen

Kun pelinäkymässä klikataan painiketta _nextCardButton_ etenee sovelluksen kontrolli seuraavasti:

![Sekvenssikaavio](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Seuraava_kortti_sekvenssi.png)

Painiketta kuuntelevan FXML-ohjaimen _GameSceneController_ metodia [nextTurn()](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/main/java/ui/controllers/GameSceneController.java#L59) kutsutaan ja tämä edelleen kutsuu sovelluslogiikan _GameServices_ metodia [nextTurn()](https://github.com/Jeemlei/ot-harjoitustyo/blob/d4268909e79de12c0356e652a7596958293e9109/Juomapeli/src/main/java/domain/GameServices.java#L51). Sovelluslogiikka kasvattaa vuorolaskuria ja tarvittaessa nollaa sen. Tämän jälkeen se hakee korttipakasta _Deck_ seuraavan kortin. Suoritus palaa takaisin FXML-ohjaimelle, joka päivittää [_GameScene_](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/main/resources/fxml/GameScene.fxml) näkymän, hakemalla sovelluslogiikalta vuorossa olevan pelaajan ja kortin sekä kortilta sen nimen ja kuvauksen.
