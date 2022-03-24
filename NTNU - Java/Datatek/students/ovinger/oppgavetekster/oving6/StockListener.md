# Observatør-observert-teknikken - StockListener-oppgave

Denne oppgaven handler om å bruke observatør-observert-teknikken for å holde en aksjeindeks (**StockIndex**) informert om endringer i én eller flere aksjer (**Stock**).

Observatør-observert-teknikken går ut på at det observerte objektet sier ifra til én eller flere observatører om at tilstanden er endret. I vårt tilfelle skal vi ta utgangspunkt i at aksjer (**Stock**) har en pris, og at personer eller institusjoner (**StockListener**) ønsker å holde seg oppdatert på aksjepriser.

Alle filene i denne oppgaven skal lages i [oving6/observable](../../src/main/java/oving6/observable)

## Del 1: Stock-klassen og StockListener-grensesnittet

Du skal implementere en klasse **Stock** med følgende funksjonalitet:

- `Stock(String, double)` - en konstruktør som tar inn en aksjekode (ticker) og en aksjepris.
- `void setPrice(double)` - endringsmetode for aksjeprisen. Dersom aksjepris er negativ eller lik null, skal metoden utløse en **IllegalArgumentException**.
- `String getTicker()` - metode for å hente aksjekoden.
- `double getPrice()` - metode for å hente aksjeprisen.

Du skal videre definere et lyttergrensesnitt kalt **StockListener**, som observatørene må implementere. Grensesnittet skal inneholde én metode:

- `void stockPriceChanged(Stock stock, double oldValue, double newValue)` - lyttermetode for å holde lytteren oppdatert på aksjeprisen. Metoden skal ta inn et **Stock**-objekt, samt gammel og ny pris. Alle lyttere må implementere denne metoden.

Foreløpig er **Stock** ikke observerbar. For at observatører skal kunne holdes oppdatert, må **Stock**-objekter administrere en liste med lyttere. Derfor må **Stock**-klassen i tillegg ha følgende metoder:

- `void addStockListener(StockListener)` - metode for å legge til nye observatører.
- `void removeStockListener(StockListener)` - metode for å fjerne observatører.

Observatørene skal holdes oppdatert på prisendringer. Derfor må lyttermetoden kalles hos alle registrerte observatører når aksjeprisen endres med **setPrice**-metoden.

Testkode for denne oppgaven finner du her: [oving6/observable/StockTest.java](../../src/test/java/oving6/observable/StockTest.java).

## Del 2: StockIndex implements StockListener

Vi skal nå lage en veldig forenklet versjon av en aksjeindeks. I korte trekk bruker man en aksjeindeks til å måle utviklingen av et utvalg aksjer. Vår enkle, fiktive aksjeindeks **StockIndex** har et navn (**String**), indeks (**double**) og en liste med **Stock**-objektene som er inkludert i indeksen. Indeksen beregnes ut i fra aksjeprisene den "observerer", og vil være lik summen av disse. Når en av aksjeprisene øker eller synker, må tilstanden til **StockIndex**-objektet holdes konsistent med denne utviklingen. Dette lar seg gjøre ved at **StockIndex** observerer én eller flere **Stock**-objekter. Klassen skal ha følgende metoder:

- `StockIndex(String, Stock... )` - konstruktør som tar inn ingen, én eller flere aksjer (**Stock**-objekter). **Stock**-parameteret defineres som et såkalt [varargs-parameter](https://www.ntnu.no/wiki/display/tdt4100/Varargs+-+variabelt+antall+argumenter). NB: **StockIndex**-objektet skal holdes oppdatert på aksjeprisene allerede fra det er instansiert. Dersom en indeks instansieres uten **Stock**-objekter, skal aksjeindeksen være 0.
- `void addStock(Stock)` - metode for å legge til en aksjepris i indeksen.
- `void removeStock(Stock)` - metode for å fjerne en aksjepris fra indeksen.
- `double getIndex()` - hentemetode for indeksen.

I tillegg må **StockIndex**-klassen selvsagt implementere **StockListener** og dermed også lyttermetoden **stockPriceChanged**, slik at indeksen kan holdes oppdatert.

Testkode for denne oppgaven finner du her: [oving6/observable/StockIndexTest.java](../../src/test/java/oving6/observable/StockIndexTest.java).

## Ekstraoppgaver

I en del sammenhenger vil du ikke være interessert i alle småendringer i en aksjepris, men interessert i endringer utenfor et visst område eller av en viss størrelse. Kanskje vil du kjøpe aksjer hvis det er billig nok, ønsker å selge dersom prisen blir høy nok eller ønsker å vite om større endringer som kan være signal om viktige prisendringer. Så for å unngå å sende ut mange uinteressante prisoppdateringer, er det aktuelt med to typer utvidelser av **Stock**-klassen. I begge tilfellene bruker men en egen **addStockListener**-metode for å registrere lytteren og hva slags endring man er interessert i. Implementér utvidelsen(e) i en subklasse som du kaller **SmartStock**. Merk at denne utvidelsen av **Stock** ikke er så relevant å bruke sammen med **StockIndex**, siden den da vil miste noen oppdateringer og dermed kunne risikere å være inkonsistent innimellom.

### Pris*intervall*

I denne utvidelsen skal du støtte lyttere som ønsker å få beskjed kun dersom **Stock**-objektets pris settes utenfor et gitt intervall. Følgende metode må implementeres:

- `void addStockListener(StockListener, double min, double max)` - metode som legger til lyttere med krav til prisintervall.

Lyttere som er registrert med denne metoden skal bare varsles dersom **Stock**-objektets pris endres til en verdi utenfor det angitte intervallet. Hint: Bruk en eller flere **Map<StockListener, Double>**-felt til å holde oversikt over intervallene, evt. definér en hjelpeklasse som har felt for **StockListener** og minimum- og maksimumsverdiene.

### Pris*differanse*

I denne utvidelsen skal du støtte lyttere som ønsker å få beskjed kun når akkumulerte endringer av **Stock**-objektets pris er større enn en gitt differanse. Følgende metode må implementeres:

- `void addStockListener(StockListener, double difference)` - metode som legger til lyttere med krav til prisdifferanse.

Et viktig poeng med denne er varianter er hvilke tidligere verdien som skal gis til lyttermetoden **stockPriceChanged** sitt andre argument. Denne verdien skal være den forrige verdien som ble rapportert, som kan være en annen enn den forrige prisverdien. Anta f.eks. at en lytter registreres med **10** som prisdifferanse og at aksjeprisen starter som **110** og så endres til **118** og videre til **121**. Da skal lyttermetoden **stockPriceChanged** kalles med **110** som gammel verdi og **121** som ny verdi, fordi dette sett fra lytterens perspektiv er forrige verdi den fikk vite om. En annen lytter som var registrert med prisdifferansen **5**, ville fått beskjed allerede ved første endring og da med **110** som gammel verdi og **118** som ny, men den ville ikke få beskjed om endringen fra **118** til **121**, fordi differansen da er for liten. Dersom prisen endrer seg videre til **124**, vil lytteren få beskjed og da med **118** som gammel verdi.

Testkode for denne oppgaven finner du her: [oving6/observable/SmartStockTest.java](../../src/test/java/oving6/observable/SmartStockTest.java).
