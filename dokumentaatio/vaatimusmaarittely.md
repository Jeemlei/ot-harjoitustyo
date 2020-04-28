# Vaatimusmäärittely

## Sovelluksen tarkoitus

Itse kehitetyn fyysisen korttipohjaisen juomapelin toteutus sovelluksena. 
[kortit](https://drive.google.com/drive/folders/16hBqs6dDaSH-T-GKFYN9Hh7Yt22KrmyP?usp=sharing)

## Käyttäjät

Sovelluksella on ainoastaan yksi käyttäjärooli eli _normaali käyttäjä_.

## Käyttöliittymäluonnos

Sovellus koostuu kolmesta eri näkymästä

![alustavaUI.png](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/alustavaUI.png)

Sovellus aukeaa aloitusnäkymään, jossa käyttäjä voi lisätä pelaajia peliin. Pelaajien lisäämisen jälkeen pelin voi aloittaa, mikä siirtää sovelluksen pelinäkymään, jossa varsinainen pelaaminen tapahtuu. 

Pelinäkymässä näytetään vuorossa oleva pelaaja sekä viimeksi käännetty kortti. Vuorossa olevan pelaajan on mahdollista luovuttaa. Tämä siirtää sovelluksen kolmanteen näkymään.

Kolmannessa näkymässä pelaaja vahvistaa haluavansa luovuttaa, minkä jälkeen sovellus siirtyy takaisin pelinäkymään.

## Perusversion tarjoama toiminnallisuus

**Perusversion kaikki ominaisuudet toteutettu!**

### Ennen pelin alkua

- [x] Pelaajan lisääminen **TEHTY**
  - Pelaajanimen tulee olla uniikki jokaisella kyseisen kierroksen pelaajalla ja sisältää vähintään 1 merkki
  - Pelaajia voi lisätä korkeintaan 8
- [x] Pelaajan poistaminen **TEHTY**
  - Pelaajan voi vielä poistaa ennen pelin aloittamista
- [x] Pelin aloittaminen **TEHTY**
  - Pelissä täytyy olla vähintään 3 pelaajaa lisättynä

### Pelin alkaessa

- [x] Ohjelma hakee kortit muistista **TEHTY**
  - Korttien tiedot on tallennettuna tiedostoon tai tietokantaan
- [x] Ohjelma luo korteista pakan **TEHTY**
  - Kortit laitetaan pakkaan satunnaiseen järjestykseen
  - Pakan koko riippuu pelaajien lukumäärästä

### Pelin aikana

- [x] Seuraavan kortin kääntäminen **TEHTY**
  - Vuoro siirtyy seuraavalle pelaajalle
  - Seuraavan kortin tiedot ilmestyvät näkyviin
- [x] Nopan heittäminen **TEHTY**
- [x] Pelaajan luovuttaminen **TEHTY**
  - Tupla varmistus ennen pelaajan poistoa

## Jatkokehitysideoita

Perusversion jälkeen järjestelmää täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla

- [x] Lopetusnäkymä
  - Pelin loppuessa siirrytään lopetusnäkymään, jossa on mahdollista aloittaa uusi peli tai sulkea sovellus
- Eri korttien ominaisuuksiin liittyvän logiikan implementoinit
  - Korttikategoriat (vaatii todennäköisesti suuria muutoksia käyttöliittymään)
  - Korttien kohdistaminen tiettyihin pelaajiin
  - Pelaajien hallussa olevien kyky- ja tiketti-korttien tarkastelu ja käyttäminen
  - [x] Aktiivisena olevien sääntö-korttien tarkastelu **TEHTY**
  - Aktiivisena olevien sääntö-korttien poistaminen tiketti-korteilla
  - jne.
- Juomalaskurit pelaajille
- Ohjenäkymä
  - Aloitusnäkymästä pääsee siirtymään ohjenäkymään, jossa on lyhyt kuvaus pelistä ja tiiviit ohjeet sen pelaamiseen
- Käyttöliittymään näkymä asetuksille
  - Pelin vaikeusasteen valinta
  - Omavalintaisten korttien jättäminen pois pelistä
  - Uusien korttien lisääminen peliin (*Mahdollisesti liian monimutkainen*)
  - Itselisättyjen korttien hallinnointi ja poistaminen
- Käyttöliittymään viides näkymä pelin ohjeille
