# Tilstand og oppførsel – Stopwatch

Oppgaven handler om en `StopWatch`-klasse, som implementerer en stoppeklokke med funksjoner for å starte, ta rundetider og stoppe.

Klassen skal implementere logikken ofte funnet på stoppeklokker på smarttelefoner.

<img alt="Stopwatch" src="fig/stopwatch.gif" width="250px" style="float: right" />

For å holde styr på tiden som går vil `StopWatch`-klassen bli kalt utenfra (altså noe du slipper å implementere i denne oppgaven) på en `tick(int)`-metode. I dataverdenen er et tick (tikk på norsk) minste målbare diskret tidsenhet. I denne oppgaven er 1 tikk = 1 millisekund. F.eks. vil et kall `tick(3)` fortelle en `StopWatch`-instans at $`3`$ tikk har gått siden sist gang `tick()` ble kalt.

StopWatch skal fungere på følgende måte:

- Klokken startes når man ønsker å starte tidtakningen.
- Alle tikk etter at klokken har blitt startet skal medregnes i tidtakningen.
- Klokken stoppes når man ønsker å stoppe tidtakningen. Da er tidtakningen helt ferdig. Det er ikke en pause i tidtakningen - klokken skal ikke startes igjen.
- Det skal være mulig å ta rundetider.
- Første rundetid startes når klokken starter.
- Under tidtakningen kan man starte en ny rundetid, og dermed implisitt avslutte den nåværende.
- Siste rundetid avsluttes når klokken stoppes.

`StopWatch`-klassen må ha metoder for å spørre om tilstanden og metoder for å endre tilstanden.

Klassen skal ha følgende spørremetoder:

- `boolean isStarted()` - returnerer `true` om klokken har blitt startet eller `false` om den ikke har blitt startet
- `boolean isStopped()` - returnerer `true` om klokken har blitt stoppet eller `false` om den ikke har blitt stoppet. Merk at her snakker vi om at klokken har blitt stoppet minst én gang, ikke om klokken går eller ikke.
- `int getTicks()` - returnerer det totale antall tikk (millisekunder) som har gått i levetiden til klokken uavhengig om klokken har vært startet eller stoppet.
- `int getTime()` - returnerer antall tikk som har gått under tidtakningen. Hvis tidtakningen ikke har startet returner $`-1`$. Merk at hvis klokken er startet, men ikke stoppet, skal metoden returnere antall tikk som har gått siden klokken ble startet til nå. Hvis klokken er stoppet skal metoden returnere antall tikk som har gått fra klokken ble startet til klokken ble stoppet.
- `int getLapTime()` - returnerer antall tikk som har gått under nåværende rundetid til nå. Hvis tidtakningen ikke har startet returner $`-1`$.
- `int getLastLapTime()` - returnerer lengden på forrige avsluttede rundetid. Hvis det ikke er noen tidligere rundetider returner $`-1`$.

Klassen skal ha følgende metoder for å endre tilstanden:

- `void tick(int ticks)` - forteller klokken at `ticks` antall tikk har gått.
- `void start()` - starter klokken.
- `void lap()` - avslutter nåværende rundetid og starter en ny.
- `void stop()` - stopper klokken.

## Java-kode

Skriv Java-kode for `StopWatch`-klassen med oppførsel som er beskrevet over.

Lag en passende `toString()`-metode og en `main`-metode, der du gjennomfører en valgfri sekvens av kall som viser at koden oppfører seg som tenkt. Om du tegnet tilstandsdiagram for denne oppgaven i Del 1, kan du bruk samme sekvens av kall her.

Testkode for denne oppgaven finner du her: [src/test/java/stateandbehavior/StopWatchTest.java](../../src/test/java/stateandbehavior/StopWatchTest.java).
