# Käyttöohje

Lataa tiedosto [Juomapeli.jar](https://github.com/Jeemlei/ot-harjoitustyo/releases/tag/viikko7)

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla

```
java -jar Juomapeli.jar
```

## Pelin aloitus

Peli käynnistyy aloitusnäkymään

![Aloitusnäkymä](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/Aloitusnakyma.PNG)

Peliin tulee lisätä 3-8 pelaajaa. Pelaajan lisääminen onnistuu kirjoittamalla pelaajan nimi tekstikenttään ja painamalla "Lisää pelaaja"-nappia tai Enter⏎-näppäintä. 

Kun pelissä on terpeeksi pelaajia, pelin aloitus onnistuu "Aloita peli"-nappia painamalla.

## Pelaaminen

Pelinäkymässä näkyy vuorossa olevan pelaajan nimi sekä avatun kortin nimi ja kuvaus.

![Pelinäkymä](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/Pelinakyma.PNG)

Vuoro siirtyy seuraavalle pelaajalle "Seuraava kortti"-nappia painamalla.

Muutamat kortit vaativat nopan heittoa, jota varten on "Heitä"-nappi näkymän alalaidassa.

Oikeassa laidassa näkyvät voimassa olevien sääntökorttien nimet.

## Luovuttaminen

Vuorossa oleva pelaaja voi luovuttaa painamalla "Luovuta"-nappia, mikä siirtää pelin luovutusnäkymään.

![Luovutusnäkymä](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/Luovutusnakyma.PNG)

Luovutusnäkymässä pelaaja voi varmistaa haluavansa luovuttaa tai muuttaa vielä mieltään ja jatkaa peliä.

## Pelin lopetus

Peli päättyy, kun kaikki kortit on käännetty tai pelissä on enää yksi pelaaja.

![Lopetusnäkymä](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/Lopetusnakyma.PNG)

Lopetusnäkymässä on mahdollista siirtyä aloitusnäkymään "Uusi peli"-nappia painamalla tai sulkea sovellus "Sulje peli"-napilla.
