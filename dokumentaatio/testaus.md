# Testausdokumentti

## Testikattavuus

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
