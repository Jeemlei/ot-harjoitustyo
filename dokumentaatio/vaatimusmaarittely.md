# Vaatimusmäärittely

## Sovelluksen tarkoitus

Itse kehitetyn fyysisen korttipohjaisen juomapelin toteutus sovelluksena. 
[kortit](https://drive.google.com/drive/folders/16hBqs6dDaSH-T-GKFYN9Hh7Yt22KrmyP?usp=sharing)

## Käyttäjät

Sovelluksella on ainoastaan yksi käyttäjärooli eli ns. _normaali käyttäjä_.

## Käyttöliittymäluonnos

Sovellus koostuu neljästä eri näkymästä

![UI.PNG](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/UI.PNG)

Sovellus aukeaa aloitusnäkymään, jossa käyttäjä voi lisätä pelaajia peliin. Pelaajien lisäämisen jälkeen pelin voi aloittaa, mikä siirtää sovelluksen pelinäkymään, jossa varsinainen pelaaminen tapahtuu. 

Pelinäkymässä näytetään vuorossa oleva pelaaja sekä viimeksi käännetty kortti ja voimassa olevat sääntökortit. Vuorossa olevan pelaajan on mahdollista luovuttaa. Tämä siirtää sovelluksen luovutusnäkymään.

Luovutusnäkymässä pelaaja vahvistaa haluavansa luovuttaa, minkä jälkeen sovellus siirtyy takaisin pelinäkymään.

Jos pelissä on enää yksi pelaaja tai kortit loppuvat, sovellus siirtyy lopetusnäkymään. Lopetusnäkymässä sovelluksen sulkea tai valita uuden pelin, mikä siirtää sovelluksen takaisin aloitusnäkymään.

## Perusversion tarjoama toiminnallisuus

**Perusversion kaikki ominaisuudet toteutettu!**

### Ennen pelin alkua

- [x] Pelaajan lisääminen
  - Pelaajanimen tulee olla uniikki jokaisella kyseisen kierroksen pelaajalla ja sisältää vähintään 1 merkki
  - Pelaajia voi lisätä korkeintaan 8
- [x] Pelaajan poistaminen
  - Pelaajan voi vielä poistaa ennen pelin aloittamista
- [x] Pelin aloittaminen
  - Pelissä täytyy olla vähintään 3 pelaajaa lisättynä

### Pelin alkaessa

- [x] Ohjelma hakee kortit muistista
  - Korttien tiedot on tallennettuna JSON-tiedostoon
- [x] Ohjelma luo korteista pakan
  - Kortit laitetaan pakkaan satunnaiseen järjestykseen
  - Pakan koko riippuu pelaajien lukumäärästä

### Pelin aikana

- [x] Seuraavan kortin kääntäminen
  - Vuoro siirtyy seuraavalle pelaajalle
  - Seuraavan kortin tiedot ilmestyvät näkyviin
- [x] Aktiivisena olevien sääntö-korttien tarkastelu
- [x] Nopan heittäminen
- [x] Pelaajan luovuttaminen
  - Tupla varmistus ennen pelaajan poistoa
  
### Pelin päätyttyä

- [x] Siirtyminen lopetusnäkymään
  - Pelin loppuessa siirrytään lopetusnäkymään, jossa on mahdollista aloittaa uusi peli tai sulkea sovellus

## Jatkokehitysideoita

Kurssin jälkeen peliä voi harrastuksena laajentaa esim. seuraavilla toiminnallisuuksilla

- Eri korttien ominaisuuksiin liittyvän logiikan implementoinnit
  - Korttikategoriat (vaatii todennäköisesti suuria muutoksia käyttöliittymään)
  - Korttien kohdistaminen tiettyihin pelaajiin
  - Pelaajien hallussa olevien kyky- ja tiketti-korttien tarkastelu ja käyttäminen
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
- Android- ja selain-version kehittäminen
- Online/etäpelimahdollisuus
