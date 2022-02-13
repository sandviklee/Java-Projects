# Objektstrukturer - StopWatchManager-oppgave

Denne oppgaven handler om en `StopWatchManager`-klasse som inneholder flere `StopWatch`-objekter. Oppgaven bygger på klassen lagd i [StopWatch-oppgaven](../oving1/Stopwatch.md) fra "tilstand og oppførsel".

I mange sammenhenger vil objekter av en klasse inneholde eller "eie" objekter av andre klasser. Når en klasse er assosiert med én instans av en (annen) klasse er dette en [1-1-assosiasjon](https://www.ntnu.no/wiki/display/tdt4100/Koding+av+1-1-assosiasjoner) og når en klasse er assosiert med flere instanser av en annen klasse er dette en [1-n-assosiasjon](https://www.ntnu.no/wiki/display/tdt4100/Koding+av+1-n-assosiasjoner).

I denne oppgaven skal du implementere en `StopWatchManager`-klasse som kan holde styr på flere stoppeklokker. Ved hjelp av `StopWatchManager` skal man enkelt kunne holde styr på flere stoppeklokker og sørge for at alle stoppeklokker får beskjed om tiden som går. Dette kan være nyttig hvis man f.eks. ønsker å holde styr på flere løpere i et skirenn der ikke alle starter og fullfører samtidig, men hvor allikevel klokken må gå for alle.

Det skal være mulig å opprette nye stoppeklokker med et tilhørende navn (streng). Navnet skal man senere kunne bruke til å hente stoppeklokken igjen eller fjerne stoppeklokken fra `StopWatchManager`. For å få til dette kan det være lurt å se litt på `Map` fra [Collection-rammeverket](https://www.ntnu.no/wiki/display/tdt4100/Collection-rammeverket).

`StopWatchManager` skal ha følgende endringsmetoder:

- `StopWatch newStopWatch(String name)` - Oppretter en ny stoppeklokke knyttet til navnet `name`. Returnerer den nye stoppeklokken.
- `void removeStopWatch(String name)` - Fjerner stoppeklokken tilknyttet navnet `name`.
- `void tick(int ticks)` - Informerer alle stoppeklokkene om at ticks tikk har gått.

`StopWatchManager` skal ha følgende lesemetoder:

- `StopWatch getStopWatch(String name)` - returnerer stoppeklokken tilknyttet navnet `name`.
- `Collection<StopWatch> getAllWatches()` - returnerer alle stoppeklokkene.
- `Collection<StopWatch> getStartedWatches()` - returnerer alle stoppeklokkene som er startet.
- `Collection<StopWatch> getStoppedWatches()` - returnerer alle stoppeklokkene som er stoppet.

**Merk**: Det er viktig at de metodene som returnerer en samling av stoppeklokker returnerer nye samlinger. De som får en samling må kunne endre på den (f.eks. fjerne elementer) uten at dette forstyrrer `StopWatchManager` eller andre som har fått samlinger tidligere.

**Java-kode**

Kopier `StopWatch` fra `stateandbehaviour`-pakken (øving 1) og lag `StopWatchManager` som beskrevet over. Test klassen med selvlagde main-metoder og ved å kjøre JUnit-testene.

Testkode for denne oppgaven finner du her: [oving4/StopWatchTest.java](../../src/test/java/oving4/StopWatchTest.java) og [oving4/StopWatchManagerTest.java](../../src/test/java/oving4/StopWatchManagerTest.java).
