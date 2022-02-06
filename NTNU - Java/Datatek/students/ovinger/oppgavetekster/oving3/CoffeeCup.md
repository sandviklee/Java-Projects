# Debugging - CoffeeCup-oppgave

Oppgaven handler om feilsøking i en **CoffeeCup**- og en **CoffeeCupProgram**-klasse ved bruk av [debuggeren i VSCode](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=235996724).

Et **CoffeeCup**-objekt inneholder kapasitet og nåværende volum av kaffe.

- Kapasitet må være et ikke-negativt flyttall, som til enhver tid må være større enn nåværende volum av kaffe.
- Nåværende volum av kaffe er et ikke-negativt flyttall som til enhver tid må være mindre enn kapasiteten til koppen.

**CoffeeCup**-klassen har følgende metoder og konstruktører:

- `void drinkCoffee(double)` og `void fillCoffee(double)`, hvor man henholdsvis drikker og fyller koppen med kaffe. Om man prøver å drikke mer enn det finnes i koppen, eller fyller for mye i koppen blir en `IllegalArgumentException` utløst.
- `void increaseCupSize(double)`, som øker størrelsen på koppen. Om man prøver å gjøre koppen mindre skjer ingenting.
- `CoffeeCup()`, en konstruktør som setter standard initialverdier til 0.0 kapasitet og 0.0 nåværende kaffe i koppen.
- `CoffeeCup(double, double)`, en konstruktør som setter initialverdier til de oppgitte verdiene.
- I tillegg har klassen noen private hjelpefunksjoner som man kan identifisere selv.

**CoffeeCupProgram**-klassen er en hovedprogramklasse som oppretter en instans av **CoffeeCup**, og utfører en sekvens av kall til koppens ulike metoder.

I denne oppgaven blir en implementasjon av **CoffeeCup** sammen med et hovedprogram utdelt, men i implementasjonen av hovedprogrammet har vi plantet noen feil. Det er to oppgaver som må løses.

CoffeeCup-koden finner du i [oving3/debugging/CoffeeCup.Java](../../src/main/java/oving3/debugging/CoffeeCup.java). CoffeeCupProgram finner du i [oving3/debugging/CoffeeCupProgram.java](../../src/main/java/oving3/debugging/CoffeeCupProgram.java).

### Leseliste

- [Debuggeren i VSCode](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=235996724) - Debuggeren er et verktøy som brukes til å analysere kjørende kode, noe som kan være svært nyttig når man vil forstå og evt. rette feil i et program.
- [Hovedprogramklasser](https://www.ntnu.no/wiki/display/tdt4100/Hovedprogramklasser) - Hovedprogramklasser er klasser som aktiveres når programmer starter opp og som initialiserer og kontrollerer/koordinerer de andre objekter i applikasjonen.
- [java.util.Random](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html) - En pseudotilfeldig nummergenerator i Java.

### Del 1

Målet for oppgaven er å finne en feil i funksjonen `part1()` ved hjelp av debuggeren i VSCode. Kjør hovedprogrammet i debug-modus, og bruk dette til å finne hva kapasiteten og nåværende volum av kaffe er like før programmet utløser et unntak.

Finn også ut hvilken metode i **CoffeeCup** som utløser unntaket.

### Del 2

Du fant feilen i oppgave 1, bra! Kommentér ut kallet til `part1()` i hovedprogrammet, så slipper vi å ha mer med det å gjøre.

Du skal nå finne ut hvordan nåverende volum av kaffe endrer seg i `part2()`, før programmet utløser et unntak. Lag en liste over hvilke verdier nivået har. Hvilken metode i **CoffeeCup** utløser et unntak denne gangen? Hvilken type unntak blir utløst?
