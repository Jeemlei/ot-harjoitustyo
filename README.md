# Ohjelmistotekniikan palautusrepositorio

*Repositorio sisältää kurssin [ohjelmistotekniikka kevät 2020](https://github.com/mluukkai/ohjelmistotekniikka-kevat-2020) viikottaiset tehtävät sekä harjoitustyön ja siihen liittyvät dokumentit.*

# Juomapeli

Peli on fyysiseen korttipeliin pohjautuva juomapeli 3-8 pelaajalle.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

## Komentorivitoiminnot

### Kääntäminen ja suoritus

Luodaan jar-tiedosto ja käynnistetään ohjelma komennolla
```
mvn compile exec:java -Dexec.mainClass=ui.Main
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

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedoston _target/site/jacoco/index.html_

### Checkstyle

Tiedoston [checkstyle.xml](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Virheraporttia voi tarkastella avaamalla selaimella tiedoston _target/site/checkstyle.html_
