# Øving 4: Objektstrukturer

**Øvingsmål**

- Lære hva assosiasjoner er og hvordan dette brukes i OO
- Lære hvordan man sikrer konsistent oppførsel mellom assosierte objekter

**Øvingskrav**

- Kunne implementere klasser som har assosiasjoner til én eller flere andre klasser
- Kunne sikre at disse assosiasjon er konsistente i enkle objektstrukturer
- Kunne implementere metoder som oppretter, oppdaterer og fjerner slike assosiasjoner

## Dette må du gjøre

### Del 1: Programmering

I denne øvingen skal du velge og gjennomføre ENTEN både Partner- og Card del 2-oppgavene ELLER minst én av Twitter-, Stopwatch- og Person-oppgavene.
Merk at **noen av oppgavene i neste øving (øving 5), bygger videre på noen av oppgavene under**, disse er uthevet med **fet skrift**.
Det er ikke et krav at man gjør de uthevede oppgavene, men de gir flere oppgaver å velge mellom i øving 6.

**Gjør enten _begge_ disse:**

- [Partner](./Partner.md) (lett)
- **[Card del 2](./Card.md)** (lett)

**Eller _minst én_ av følgende oppgaver:**

- **[Twitter](./Twitter.md)** (medium, men lang)
- [Stopwatch](./Stopwatch.md) (medium)
- [Person](./Person.md) (medium/vanskelig)

Oppgavene for denne øvingen skal du lagre i `ovinger/src/main/java/oving4`. Test-filene ligger i `ovinger/src/test/java/oving4`.

Alle oppgavene ovenfor er høyst eksamensrelevante og det anbefales å ta en titt på alle sammen.

### Del 2: Klassediagram

- Lag et [klassediagram](https://www.ntnu.no/wiki/display/tdt4100/Klassediagrammer) for en av oppgavene du velger. Husk å få med relasjonene mellom klassene. Dersom du gjorde bare Partner og Card må du tegne diagram for Card.

Diagrammet kan for eksempel skrives på papir eller tegnes/lages i et valgfritt program. Du trenger ikke levere inn diagrammene, men de skal vises til studass under godkjenning av øvingen.

### Del 3: Testing

Skriv kode som tester oppførselen til `CoffeeCup`-klassen, dvs. at du skal teste om metodene i listen under har rett oppførsel og returnerer det de skal, i tillegg til at du skal teste konstruktørene. Det er ikke nødvendig å teste absolutt alle mulige tilfeller, men det kreves at du tester den grunnleggende funksjonaliteten. Basert på resultatene dine, drøft om klassen er implementert på en fornuftig måte.

- `getCapacity`
- `getCurrentVolume`
- `increaseCupSize`
- `drinkCoffee`
- `fillCoffee`

Du finner `CoffeeCup`-klassen under `ovinger/src/main/java/oving4/testing`.

Her er det anbefalt å bruke [JUnit](https://www.ntnu.no/wiki/display/tdt4100/Enhetstesting+med+JUnit),
men det er lov å teste vha. main-metoden også. Dersom du bruker JUnit må du opprette testen i `oving/src/test/java/oving4/testing`.

### Hjelp / mistanke om bugs

Ved spørsmål eller behov for hjelp konsulter studassen din i saltiden hans / hennes. Du kan også oppsøke andre studasser på sal eller legge ut et innlegg på [Piazza](https://piazza.com/).

### Godkjenning

Last opp kildekode på Blackboard innen den angitte innleveringsfristen. Innlevert kode skal demonstreres for en læringsassistent innen én uke etter innleveringsfrist. Se for øvrig Blackboard-sidene for informasjon rundt organisering av øvingsopplegget og det tilhørende øvingsreglementet.
