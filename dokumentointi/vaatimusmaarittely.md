# Vaatimusmäärittely

## Sovelluksen tarkoitus

Itse kehitetyn fyysisen korttipohjaisen juomapelin toteutus sovelluksena. 
[kortit](https://drive.google.com/drive/folders/16hBqs6dDaSH-T-GKFYN9Hh7Yt22KrmyP?usp=sharing)

## Käyttäjät

Sovelluksella on ainoastaan yksi käyttäjärooli eli _normaali käyttäjä_.

## Käyttöliittymäluonnos

Sovellus koostuu kolmesta eri näkymästä

![alustavaUI.png](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentointi/alustavaUI.png)

Sovellus aukeaa aloitusnäkymään, jossa käyttäjä voi lisätä pelaajia peliin. Pelaajien lisäämisen jälkeen pelin voi aloittaa, mikä siirtää sovelluksen pelinäkymään, jossa varsinainen pelaaminen tapahtuu. 

Pelinäkymässä näytetään vuorossa oleva pelaaja sekä viimeksi käännetty kortti. Vuorossa olevan pelaajan on mahdollista luovuttaa. Tämä siirtää sovelluksen kolmanteen näkymään.

Kolmannessa näkymässä pelaaja vahvistaa haluavansa luovuttaa, minkä jälkeen sovellus siirtyy takaisin pelinäkymään.

## Perusversion tarjoama toiminnallisuus

### Ennen pelin alkua

- Pelaajan lisääminen **TEHTY**
  - Pelaajanimen tulee olla uniikki jokaisella kyseisen kierroksen pelaajalla ja sisältää vähintään 1 merkki
  - Pelaajia voi lisätä korkeintaan 8
- Pelaajan poistaminen **TEHTY**
  - Pelaajan voi vielä poistaa ennen pelin aloittamista
- Pelin aloittaminen **TEHTY**
  - Pelissä täytyy olla vähintään 3 pelaajaa lisättynä

### Pelin aikana

- Seuraavan kortin kääntäminen
  - Vuoro siirtyy seuraavalle pelaajalle
  - Seuraavan kortin tiedot ilmestyvät näkyviin
- Nopan heittäminen
- Pelaajan luovuttaminen
  - Tupla varmistus ennen pelaajan poistoa

## Jatkokehitysideoita

Perusversion jälkeen järjestelmää täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla

- Eri korttien (46 uniikkia [korttia](https://drive.google.com/drive/folders/16hBqs6dDaSH-T-GKFYN9Hh7Yt22KrmyP?usp=sharing)) ominaisuuksiin liittyvän logiikan implementoinit
  - Korttikategoriat
  - Juomalaskurit pelaajille
  - Korttien kohdistaminen tiettyihin pelaajiin
  - Pelaajien hallussa olevien kyky- ja tiketti-korttien tarkastelu ja käyttäminen
  - Aktiivisena olevien sääntö-korttien tarkastelu ja poistaminen tiketti-korteilla
  - jne.
- Käyttöliittymään neljäs näkymä asetuksille
  - Pelin vaikeusasteen valinta
  - Omavalintaisten korttien jättäminen pois pelistä
  - Uusien korttien lisääminen peliin (*Mahdollisesti liian monimutkainen*)
  - Itselisättyjen korttien hallinnointi ja poistaminen
- Käyttöliittymään viides näkymä pelin ohjeille
