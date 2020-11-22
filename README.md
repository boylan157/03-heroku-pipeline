# Kontinuerlig deployment til Heroku Pipeline med Travis

Målet med oppgaven er at Travis skal gjøre kontinuerlig deployment av applikasjonen fra master branch- men at endringen ikke skal gå "live" før du selv velger å promotrere applikasjonen som er i "staging". 

Vi har etter denne øvelsen tre viktige ting på plass

* Versjonskontroll - Github passer på koden !
* CI - kontinuerlig integrasjon. Travis passer på at Master branch er i en konstang god tilstand. Koden kompilerer alltid, tester er alltid "grønne"
* Travis passer deployer kontinuerlig siste versjon av Master til  et "staging" miljøe, som vi typisk tester i. Travis deployer hver pull request
til en egen "review app".
* Vi kan manuelt "promotere" staging -> live. Live er det miljøet som brukere opplever.

## Lag en ny app

* Pass på at du har et GitHub repo med en enkel Spring boot app - Du kan alternativt lage en fork av dette repoet
* Sett opp Travis integrasjon for repoet
* Sett opp en Heroku app - som kjører spring boot applikasjonen. 

## Lag en pipeline

- Lag en Heroku pipeline https://devcenter.heroku.com/articles/pipelines - NB! *stopp ved "Pipelines ownership and transfer"*
Når du har fulgt instruksjonene, skal dere sørge for at deres egen Spring Boot applikasjon er deployet i Heroku pipelinen dere lager
- Slå på "Review apps" https://devcenter.heroku.com/articles/github-integration-review-apps

## La Travis deploye til Heroku 

Følg instruksene her; 
https://docs.travis-ci.com/user/deployment/heroku/

Legg spesielt merke til hvordan Heroku håndterer Hemmeligheter som password og API tokens

## Test følgende

- Lag en Pull request i repoet. Bygger Travis pull request? Lager Heroku en review app?
- Merge pull requesten til master.
- Gjør en manuelt push av master branch til heroku (git push heroku master). Se at "Staging" applikasjonen endrer seg
- Promoter staging applikasjonen til prod
- Se at prod applikasjonen oppdaterer seg.


## Nyttige lenker
 
- for å lage et nytt Spring-prosjekt raskt - https://start.spring.io/  
- Heroku, Java & Spring boot deployment - https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku 
- Travis & Java - https://docs.travis-ci.com/user/languages/java/
- Travis Deployment til Heroku -  https://docs.travis-ci.com/user/deployment/heroku/


## Bonusoppgaver

* Begynn å se på feature toggles -Quick start guide er her; https://www.togglz.org/
* Begynn å se på Terraform - https://www.terraform.io/
