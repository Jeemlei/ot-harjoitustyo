# Testausdokumentti

## Yksikkö- ja intergraatiotestaus

### Pelilogiikka

[GameServicesTest.java](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/test/java/logicTests/GameServicesTest.java) testaa kaikki pelilogiikan toiminnallisuudet.

[_GameServices_](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/main/java/domain/GameServices.java)-luokka käyttää toiminnassaan kaikkia pakkauksen [domain.deck](https://github.com/Jeemlei/ot-harjoitustyo/tree/master/Juomapeli/src/main/java/domain/deck) luokkia ja välillisesti myös [DAO-luokkia](https://github.com/Jeemlei/ot-harjoitustyo/tree/master/Juomapeli/src/main/java/dao), joten myös näiden toiminta tulee testatuksi pelilogiikan yhteydessä.

### DAO

[DaoTest.java](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/test/java/logicTests/DaoTest.java) testaa, että [_JSONCardsDao_](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/main/java/dao/JSONCardsDao.java) lukee korttien tiedot sisältävän JSON-tiedoston onnistuneesti.

### Testikattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 95% ja haarautumakattavuus 93%

![rivikattavuus](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/rivikattavuus.PNG)

Testaamatta jäivät muutamat [_Card_](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/main/java/domain/deck/Card.java)-rajapinnan toteuttavien luokkien metodit, joita kyseisessä toteutuksessa ei hyödynnetä. Lisäksi jacoco tulkitsi switch-case ehtolauseiden switch-rivin läpikäymättömäksi haaraksi.

![rivikattavuus](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/switch-case.PNG)

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Peli on ladattu ja sitä on testattu [käyttöohjeen](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/ohje.md) kuvaamalla tavalla sekä Windows- että Linux-ympäristössä.

### Toiminnallisuudet

Kaikki [määrittelydokumentin](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md#perusversion-tarjoama-toiminnallisuus) ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi. Pelaajien lisäämisen yhteydessä on syötekenttää yritetty täyttää myös virheellisillä arvoilla kuten tyhjällä ja jo pelissä olevan pelaajan nimellä. Pelaajia on myös yritetty lisätä liikaa ja pelin aikaisia toimintoja on kokeiltu eri järjestyksissä, eri vaiheissa peliä sekä erilaisilla pelaajamäärillä.
