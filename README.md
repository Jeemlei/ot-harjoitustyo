# Ohjelmistotekniikan palautusrepositorio

*Repositorio sisältää kurssin [ohjelmistotekniikka kevät 2020](https://github.com/mluukkai/ohjelmistotekniikka-kevat-2020) viikottaiset tehtävät sekä harjoitustyön ja siihen liittyvät dokumentit.*

# Juomapeli

Peli on fyysiseen korttipeliin pohjautuva juomapeli 3-8 pelaajalle.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Releaset

[Viikko 5](https://github.com/Jeemlei/ot-harjoitustyo/releases/tag/viikko5)

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

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html

### Checkstyle

Tiedoston [checkstyle.xml](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Virheraporttia voi tarkastella avaamalla selaimella tiedoston _target/site/checkstyle.html_
