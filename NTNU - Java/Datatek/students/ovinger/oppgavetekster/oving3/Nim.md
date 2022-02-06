# Innkapsling - Nim-oppgave

Denne oppgaven handler om en `Nim`-klasse, som implementerer en variant av spillet [Nim](https://en.wikipedia.org/wiki/Nim).

Spillet Nim består av **tre** hauger med brikker. To spillere velger på tur én av haugene, og fjerner så mange brikker som ønskelig, men minimum én brikke. Spillet er over når en av haugene er helt tom for brikker.

`Nim`-klassen har enkel tilstand: En spillomgang består av tre hauger med et antall brikker. `Nim`-klassen må dermed kunne representere hvor mange brikker som er i hver haug, og oppdatere dette ettersom det fjernes brikker. Hvordan dette gjøres er åpent, så lenge det er tilstrekkelig for å oppfylle oppførselen definert for klassen.

`Nim`-klassen har følgende metoder:

- `void removePieces(int number, int targetPile)` - fjerner `number` (>= 1) antall brikker fra haugen `targetPile`. `IllegalArgumentException` utløses hvis targetPile eller number er ugyldig. Siden man ikke kan gjøre trekk etter at spillet er over, må `IllegalStateException` utløses dersom metoden kalles etter det.
- `boolean isValidMove(int number, int targetPile)` - returnerer `true` dersom argumentene representerer et lovlig trekk, og `false` dersom argumentene ikke ville ført til et lovlig trekk. Her skal man kun sjekke om et trekk er lovlig å utføre, ikke faktisk endre på tilstanden. **PS**: Husk at å flytte når et spill er over ikke er et lovlig trekk.
- `boolean isGameOver()` - returnerer `true` dersom en av haugene har 0 brikker.
- `int getPile(int targetPile)` - returnerer antall brikker i haugen targetPile.
- `String toString()` - returnerer en tekststreng som oppsummerer spillets tilstand

Haugene skal identifiseres ved tall, altså at gyldige verdier for `targetPile` er 0, 1 og 2.

`Nim`-klassen skal ha en [konstruktør](https://www.ntnu.no/wiki/display/tdt4100/Klasser+i+java#Klasserijava-constructor) `Nim(int pileSize)` som lar en bestemme hvor mange brikker som skal være i hver haug, og i tillegg en tom konstruktør som initialiserer `Nim`-objektet til å ha 10 brikker i hver haug.

## Oppgave: Java-kode

Skriv `Nim`-klassen, slik at den har ønsket oppførsel og er skikkelig innkapslet.

Testkode for denne oppgaven finner du i [encapsulation/NimTest.java](../../src/test/java/oving3/NimTest.java).
