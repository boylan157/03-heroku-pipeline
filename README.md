
[![Build Status](https://travis-ci.com/boylan157/pgr301_10021.svg?branch=master)](https://travis-ci.com/boylan157/pgr301_10021)

## Hvordan sette nødvendige hemmeligheter inn i travis
For å sette inn hemmeligheter bruker vi travis til å kryptere variabel navn og filer. for å bruke en IAM service 
for eksempel må man først hente en nøkkel, dette kan man gjør ved å gå på console.cloud.google.com -> IAM & Admin
-> Service account og trykke ADD-KEY. Man kan da laste ned en json-fil som inneholder nøkkelen. Ved bruk av 
"travis encrypt-file --pro <filnavn>.json. Denne kommandoen funket ikke på windows, jeg brukte derfor linux på i
en virituell maskin og kjørte kommandoen derfra som gikk fint, jeg prøvde å gjøre det gjennom docker også men fikk
ikke dette til. Dette vil lage en <filnavn>.json.enc fil i tillegg til en kommando med en nøkkel. Add .enc filen til git og 
sett kommandoen med nøkkelenen inn i travis. Pass på å ikke legge til <filnavn>.json til git. Man kan også legge til 
miljøvariabler ved hjelp av travis encryp for eksempel med kommandoen "travis encrypt --pro SOMEVARIABLE=123"
og derette legge til en miljøvariabel ${SOMEVARIABLE} der det trengs. Vil legge til av man må være logget inn
på travis CLI for at dette skal fungere. Vil også legge til at siden jeg har brukt travis med endepunkt .com kan 
dette feile i travis-ci.org fordi jeg krypterer med --pro.

