# Ohjelmistotekniikan palautusrepositorio

*Repositorio sisältää kurssin [ohjelmistotekniikka kevät 2020](https://github.com/mluukkai/ohjelmistotekniikka-kevat-2020) viikottaiset tehtävät sekä harjoitustyön ja siihen liittyvät dokumentit.*

# Juomapeli

Peli on fyysiseen korttipeliin pohjautuva juomapeli 3-8 pelaajalle.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

## Toteutetut ominaisuudet

- Logiikka pelaajien lisäämiseen
- JUnit testit logiikalle
  - Pelaajan nimen täytyy sisältää vähintään yksi merkki
  - Saman nimisen pelaajan voi lisätä vain kerran peliin
  - Peliin voi lisätä maksimissaan 8 pelaajaa
- Aloitusnäkymä JavaFX:llä
  - Aloita peli -nappi ei toimi, jos pelissä ei ole vielä tarpeeksi pelaajia
  - Aloita peli -nappi vaihtaa ikkunan pelinäkymään, joka ei vielä sisällä mitään

## Komentorivitoiminnot

### Kääntäminen ja suoritus

Luodaan jar-tiedosto ja käynnistetään ohjelma komennolla
```
mvn compile exec:java -Dexec.mainClass=juomapeli.Main
```

Pelkkä jar-tiedoston generointi onnistuu komennolla

```
mvn package
```

Suoritettava jar-tiedosto _Juomapeli-1.0-SNAPSHOT.jar_ löytyy hakemistosta _target/_

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_
