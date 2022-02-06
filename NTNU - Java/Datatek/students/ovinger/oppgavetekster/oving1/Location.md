# Tilstand og oppførsel – Location

Oppgaven handler om en `Location`-klasse, som holder rede på $`(x,y)`$-posisjonen til en figur som beveger seg i et rutenett.

`Location`-klassen har følgende metoder:

- `up()` - beveger figuren en rute opp
- `down()` - beveger figuren en rute ned
- `left()` - beveger figuren en rute til venstre
- `right()` - beveger figuren en rute til høyre
- `getX()` - returnerer x-posisjonen til figuren
- `getY()` - returnerer y-posisjonen til figuren

Merk at konvensjonen innen datagrafikk og rutenettbaserte spill er at $`x`$ øker mot høyre (som i matte) og $`y`$ nedover (altså motsatt av i matte).

![Koordinatsystem](fig/location/coordinate.png)

## Java-kode

Skriv Java-kode for `Location`-klassen med oppførsel som beskrevet over.

Lag en passende `toString()`-metode og en `main`-metode, der du gjennomfører en valgfri sekvens av kall som viser at koden oppfører seg som tenkt. Om du tegnet tilstandsdiagram for denne oppgaven i Del 1, kan du bruk samme sekvens av kall her.

Testkode for oppgaven finner du her: [src/test/java/stateandbehavior/LocationTest.java](../../src/test/java/stateandbehavior/LocationTest.java).
