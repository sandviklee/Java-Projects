# Tilstand og oppførsel – LineEditor

Oppgaven handler om en `LineEditor`-klasse, som håndterer data for redigering av en linje med tekst (altså tekst uten linjeskift).

`LineEditor`-klassen holder rede på en `String`-verdi og en tekstinnsettingsposisjon og har metoder for å redigere teksten. Tekstinnsettingsposisjonen er et heltall som angir hvor endringer skjer, tilsvarende en (blinkende) cursor som står mellom tegn. Verdien $`0`$ tilsvarer foran første tegn, og høyeste mulige verdi er lengden på teksten, som tilsvarer at cursoren står bak siste tegn. Tilstanden er altså som følger:

- `text` (en `String`-verdi) - teksten
- `insertionIndex` - heltall som angir hvor i teksten redigeringer vil skje

Klassen har metoder med følgende oppførsel:

- `void left()` - flytter tekstinnsettingsposisjonen ett tegn til venstre (tilsvarende bruk av venstre piltast)
- `void right()` - flytter tekstinnsettingsposisjonen ett tegn til høyre (tilsvarende bruk av høyre piltast)
- `void insertString(String s)` - skyter teksten angitt av argumentet `s` inn i teksten på tekstinnsettingsposisjonen og forskyver tekstinnsettingsposisjonen mot høyre tilsvarende
- `void deleteLeft()` - fjerner tegnet til venstre for tekstinnsettingsposisjonen
- `void deleteRight()` - fjerner tegnet til høyre for tekstinnsettingsposisjonen
- `String getText()` - Returnerer teksten
- `void setText(String)` - oppdaterer teksten til å være den nye teksten
- `int getInsertionIndex` - returnerer hvor i teksten redigeringer nå skjer
- `void setInsertionIndex(int)` - oppdaterer hvor i teksten redigeringer skal skje

## Java-kode

Skriv Java-kode for `LineEditor`-klassen med oppførsel som beskrevet over.

Lag en `toString()`-metode som viser teksten med tegnet `'|'` skutt inn på tekstinnsettingsposisjonen. Lag så en `main`-metode, der du gjennomfører en valgfri sekvens av kall som viser at koden oppfører seg som tenkt. Om du tegnet tilstandsdiagram for denne oppgaven i Del 1, kan du bruk samme sekvens av kall her.

Testkode for oppgaven finner du her: [src/test/java/stateandbehavior/LineEditorTest.java](../../src/test/java/stateandbehavior/LineEditorTest.java).

## Ekstraoppgave - frivillige utvidelser

- Legg til metoden `void insert(Object o)`, som skyter inn en tekstlig representasjon av objektet `o` som gis som argument.
- Legg til metoden `void left(int n)`, som flytter tekstinnsettingsposisjonen $`n`$ tegn til venstre, og skriv om `left()` til å bruke denne. Hva bør skje dersom tekstinnsettingsposisjonen er mindre enn $`n`$?
- Legg til metoden `right(int n)`, som flytter tekstinnsettingsposisjonen $`n`$ tegn til høyre, og skriv om `right()` til å bruke denne. Hva bør skje dersom det er færre enn $`n`$ tegn til høyre for tekstinnsettingsposisjonen?
- Utvid tilstanden og legg til metoder for å håndtere markering av region, tilsvarende bruk av shift og piltaster i en vanlig teksteditor. Husk at også de eksisterende metodene må endres til å håndtere dette riktig.
