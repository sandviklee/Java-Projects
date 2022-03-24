# Øving 06: Observatør-Observert og Delegering
**Øvingsmål**
* Lære hva observatør-observert-teknikken er, dens bruksområder og fordeler
* Lære bruk av delegering for å utføre oppgaver i en klasse

**Øvingskrav**
* Kunne definere og implementere et observatørgrensesnitt
* Kunne la en observert klasse fortelle dens observatører om endringer
* Kunne la en klasse delegere utførelsen av oppgaver til interne objekter

## Dette må du gjøre

### Del 1: Programmering

Denne øvingen omfatter både [delegeringsteknikken](https://www.ntnu.no/wiki/display/tdt4100/Delegeringsteknikken) og
[observatør-observert-teknikken](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=66879660). Gjør **minst én** av de fire oppgavene under. For å få 2 poeng må det gjøres **minst én** oppgave
fra **hvert av de to temaene**. Dette anbefales uansett på det *sterkeste*, siden dette må til for å dekke hele pensum.

Gjennomfør enten *minst én* av oppgavene om delegering:
* [The Office (ovinger/src/oving6.delegation.office)](./Office.md) (anbefalt)
* [Logger (ovinger/src/oving6.delegation)](./Logger.md)

ELLER *minst én* av oppgavene om observatør-observert-teknikken:
* [StockListener (ovinger/src/oving6.observable)](./StockListener.md)
* [Highscore (ovinger/src/oving6.observable)](./HighscoreList.md)

Oppgavene skal lagres i mappene som er spesifisert i parentes etter oppgavene.

**I tillegg til oppgaven(e) ovenfor skal du levere en tekstfil hvor du gjør kort rede for delegeringsteknikken og observatør-observert-teknikken.**

### Del 2: Objektdiagram
For en av oppgavene du gjorde i del 1:

Lag en sekvens av kall i main-funksjonen. Denne sekvensen må benytte seg av den passende teknikken fra del 1. Tegn deretter et [objektdiagram](https://www.ntnu.no/wiki/display/tdt4100/Objektdiagrammer) som viser tilstanden til hvert objekt ved slutten av main-funksjonen.

### Hjelp / mistanke om bugs
Ved spørsmål eller behov for hjelp konsulter studassen din i saltiden hans / hennes. Du kan også oppsøke andre studasser på sal eller legge ut et innlegg på [Piazza](https://piazza.com/).

### Godkjenning
Last opp kildekode på Blackboard innen den angitte innleveringsfristen. Innlevert kode skal demonstreres for en læringsassistent innen én uke etter innleveringsfrist. Se for øvrig Blackboard-sidene for informasjon rundt organisering av øvingsopplegget og det tilhørende øvingsreglementet.
