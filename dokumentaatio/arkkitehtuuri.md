# Arkkitehtuurikuvaus

## Rakenne

Ohjelman arkkitehtuuri on kolmitasoinen ja näyttää seuraavalta:

![Pakkausrakenne](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/pakkausrakenne.png)

Pakkaus _ui_ sisältää FXML:llä toteutetun käyttöliittymän kontrollerit, _domain_ pelilogiikan ja _dao_ korttitietojen muistista hakemiseen liittyvän koodin.

## Käyttöliittymä

Käyttöliittymä sisältää neljä erillistä näkymää

- pelaajien lisääminen
- pelinäkymä
- luovuttaminen
- lopetusnäkymä

jokainen näistä on toteutettu omana [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html)-oliona.  Näkymistä yksi kerrallaan on näkyvänä eli sijoitettuna sovelluksen [stageen](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html). Käyttöliittymä on rakennettu [.fxml-dokumenteilla](https://github.com/Jeemlei/ot-harjoitustyo/tree/master/Juomapeli/src/main/resources/fxml) ja näkymiä ohjataan pakkauksesta [ui.controllers](https://github.com/Jeemlei/ot-harjoitustyo/tree/master/Juomapeli/src/main/java/ui/controllers) löytyvillä FXML-ohjaimilla.

Käyttöliittymä on pyritty eristämään täysin pelilogiikasta ja se ainoastaan kutsuu sopivin parametrein pelilogiikan toteuttavien olioiden metodeja.

Kun pelissä tapahtuu muutoksia, kutsutaan näkyvillä olevan näkymän FXML-ohjaimen metodia update(), joka päivittää näkymän tiedot. Lopetusnäkymän ohjaimella ei ole metodia update(), sillä lopetusnäkymä ei sisällä muuttuvia tietoja.

## Pelilogiikka

Alla olevassa kaaviossa on kuvattu pelilogiikan kannalta tärkeät luokat ja niiden suhteet toisiinsa.

![Luokkakaavio](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/Luokkakaavio.PNG)

Peliä kontrolloidaan [_GameServices_](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/main/java/domain/GameServices.java) luokan kautta ja kaavioon on merkattu muutama sen tärkeimmistä metodeista. _GameServices_ sisältää pelissä olevat pelaajat sekä [_Card_](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/main/java/domain/deck/Card.java)-rajapinnan toteuttavia kortteja sisältävän korttipakan [_Deck_](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/main/java/domain/deck/Deck.java).

_Deck_ pääsee käsiksi korttien tietoihin [_CardsDao_](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/main/java/dao/CardsDao.java)-rajapinnan toteuttavan luokan kautta.

Sovelluksen eri osien suhteita kuvaava luokka/pakkauskaavio:

![luokka/pakkauskaavio](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/luokat%26pakkaukset.png)

## Päätoiminnalisuudet



### Seuraavan kortin kääntäminen

Kun pelinäkymässä klikataan painiketta _nextCardButton_ etenee sovelluksen kontrolli seuraavasti:

![Sekvenssikaavio](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/Seuraava_kortti_sekvenssi.png)

Painiketta kuuntelevan FXML-ohjaimen _GameSceneController_ metodia [nextTurn()](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/main/java/ui/controllers/GameSceneController.java#L59) kutsutaan ja tämä edelleen kutsuu sovelluslogiikan _GameServices_ metodia [nextTurn()](https://github.com/Jeemlei/ot-harjoitustyo/blob/d4268909e79de12c0356e652a7596958293e9109/Juomapeli/src/main/java/domain/GameServices.java#L51). Sovelluslogiikka kasvattaa vuorolaskuria ja tarvittaessa nollaa sen. Tämän jälkeen se hakee korttipakasta _Deck_ seuraavan kortin. Suoritus palaa takaisin FXML-ohjaimelle, joka päivittää [_GameScene_](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/main/resources/fxml/GameScene.fxml) näkymän, hakemalla sovelluslogiikalta vuorossa olevan pelaajan ja kortin sekä kortilta sen nimen ja kuvauksen.
