# Testausdokumentti

## Testikattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 95% ja haarautumakattavuus 93%

![rivikattavuus](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/rivikattavuus.PNG)

Testaamatta jäivät muutamat [_Card_](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/Juomapeli/src/main/java/domain/deck/Card.java)-rajapinnan toteuttavien luokkien metodit, joita kyseisessä toteutuksessa ei hyödynnetä. Lisäksi jacoco tulkitsi switch-case ehtolauseiden switch-rivin läpikäymättömäksi haaraksi.

![rivikattavuus](https://github.com/Jeemlei/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/switch-case.PNG)
