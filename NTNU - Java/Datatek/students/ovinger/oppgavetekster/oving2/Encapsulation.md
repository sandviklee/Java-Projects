# Innkapsling og gyldig tilstand - Oppgave om innkapsling og validering av klasser

I denne oppgaven skal du velge tre oppgaver som du har gjort i øving 1 fra listen nedenfor, og innkapsle og validere disse klassene.

Skriv svar (stikkord/få, korte setninger) på spørsmål 1-4 (fra del 1 nedenfor) som kommentarer i koden din.

**Oppgaver**:

- [Digit-oppgave](../oving1/Digit.md) (Lett)
- [UpOrDownCounter-oppgave](../oving1/UpOrDownCounter.md) (Lett)
- [Location-oppgave](../oving1/Location.md) (Lett)
- [StopWatch-oppgave](../oving1/Stopwatch.md) (Medium)
- [LineEditor-oppgave med fri peker](LineEditor.md) (Vanskelig)

Merk at spesifikasjonen for [LineEditor](../oving1/LineEditor.md) er litt utvidet for denne oppgaven. Se [LineEditor-oppgave med fri peker](LineEditor.md).

## Del 1: Innkapsling og validering - Teori

Ta utgangspunkt i (koden for) den originale klassen og besvar følgende spørsmål:

- Hvordan skal private og public brukes for at denne klassen skal være korrekt innkapslet?
- Hva slags validering bør legges til for å sikre gyldig tilstand?
- Hvilke metoder må evt. legges til?
- Vil du karakterisere denne klassen som data-orientert eller tjeneste-orientert. Begrunn svaret!

## Del 2: Java-kode

Implementer endringene foreslått i punktene 1-3 og prøv ut klassene. Husk å kopiere koden din fra mappen i øving 1 til [`ovinger/src/main/java/oving2`](../../src/main/java/oving2) (husk package oving2)!

Testkoder for denne oppgaven finner du her:

- [oving2/DigitTest.java](../../src/test/java/oving2/DigitTest.java)
- [oving2/UpOrDownCounterTest.java](../../src/test/java/oving2/UpOrDownCounterTest.java)
- [oving2/LocationTest.java](../../src/test/java/oving2/LocationTest.java)
- [oving2/StopWatchTest.java](../../src/test/java/oving2/StopWatchTest.java)
- [oving2/LineEditorTest.java](../../src/test/java/oving2/LineEditorTest.java)

Testkodene viser om du har innkapslet på samme måte som fagstaben har gjort. Din kode kan fungere selv om testene feiler, dersom du har valgt en løsere/strammere innkapsling iht. argumentasjonen i 1-3. Er du enig med hvordan fagstaben har gjort det?
