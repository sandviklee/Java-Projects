# Interface - BinaryComputingIterator

Denne oppgaven handler om en meta-iterator som kombinerer par av verdier fra to iteratorer til en ny iterator-sekvens ved hjelp av en gitt binær operasjon.

Meta-iteratorer er iteratorer som bruker andre iteratorer som datakilder. Se lysark om teknikken: [Forelesningslysark om meta-iteratorer](https://docs.google.com/file/d/0B9IltfWcNirndERTb1RnTGM3YWs/preview)

Du skal lage en ny klasse `BinaryComputingIterator`, som er en *implementasjon* av det innebygde `Iterator<Double>`-grensesnittet. Konstruktøren til `BinaryComputingIterator` skal ta inn to iteratorer og en binær operator, samt to valgfrie standardverdier. Når `next()`-metoden til `BinaryComputingIterator` blir kalt, skal en verdi hentes fra hver av de to iteratorene, den binære operasjonen utføres på disse to verdiene og resultatet returneres. Den binære operasjonen skal spesifiseres ved hjelp av det innebygde `BinaryOperator<Double>`-grensesnittet, som har en `apply`-metode som lar en beregne resultatet av den binære operasjonen. Hvordan en kan opprette funksjonelle grensesnitt kan du lese mer om på [wikisiden om dette](https://www.ntnu.no/wiki/display/tdt4100/Lambda-uttrykk+og+funksjonelle+grensesnitt+i+Java+8).

## BinaryComputingIterator

Klassen skal ha to konstruktører, en med og en uten standardverdier.

- `BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator)`
- `BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator)`

hvor `iterator1` og `iterator2` er iteratorene som blir kombinert av `BinaryComputingIterator`, og `default1` og `default2` er standardverdier for de respektive iteratorene. Klassen må ha følgende metoder, begge spesifisert av `Iterator<Double>`-grensesnittet: Hvordan en lager en `BinaryOperator` klasse kan du se mer om lenger ned i oppgaveteksten.

- `boolean hasNext()` - returnerer true dersom det kan beregnes flere verdier, altså hvis begge iteratorene enten har flere verdier eller har en tilhørende standardverdi. Men merk at hasNext() returnerer uansett false, hvis begge iteratorene er tomme.
- `Double next()` - returnerer resultatet av å bruke binæroperasjonen operator på de neste verdiene fra sub-iteratorene, og bruker standardverdier dersom en av iteratorene ikke har flere verdier.

Husk at ved hjelp av Java 8-syntaks kan en implementasjon av BinaryOperator skrives som `(num1, num2) -> <uttrykk>`, der `<uttrykk>` er et Java-uttrykk som brukes `num1` og `num2`. Hvis BinaryComputerIterator henter verdier fra to iteratorer med hhv. verdiene 1, 2, 3 og 3, 4, 5 og den binære operatoren er (num1, num2) -> num1 + num2, så skal sekvensen en får ut være 4, 6, 8.

For å håndtere tilfellet hvor den ene iteratoren gir ut flere verdier enn den andre, så skal det være mulig å gi standardverdier hhv. `default1` og `default2` for `iterator1` og `iterator2`, som vil bli brukt for å fylle inn manglende verdier. Hvis `BinaryComputerIterator` henter verdier fra to iteratorer med hhv. verdiene 6, 3, 0 og 3, 4 og den binære operatoren er `(num1, num2) -> num1 - num2` og `default2` er 2, så skal sekvensen en får ut være 3, -1, -2.

### Eksempel

`BinaryOperator`-implementasjoner kan lett skrive ved hjelp av Java 8 sin funksjonsnotasjon. Dersom man for eksempel vil bruke en addisjonsoperator kan det se slik ut:

```java
Iterator<Double> iterator1 = Arrays.asList(2.0, 3.0).iterator();
Iterator<Double> iterator2 = Arrays.asList(5.0).iterator();

BinaryOperator<Double> addition = (a, b) -> a + b;

// Opprett en ny BinaryComputingIterator som tar inn iterator1 og iterator2 og utfører addisjon på verdiene.
BinaryComputingIterator binaryIterator = new BinaryComputingIterator(iterator1, iterator2, null, 10.0, addition);

binaryIterator.next();   // 7.0
binaryIterator.hasNext() // true
binaryIterator.next()    // 13.0
binaryIterator.hasNext() // false
```

Testkode for BinaryComputingIterator er her: [oving5/BinaryComputingIteratorTest.java](../../src/test/java/oving5/BinaryComputingIteratorTest.java).

**Hjelp / mistanke om bugs**

Ved spørsmål eller behov for hjelp konsulter studassen din i saltiden hans / hennes. Du kan også oppsøke andre studasser på sal eller legge ut et innlegg på Piazza.

**Godkjenning**

Last opp **kildekode** på Blackboard innen den angitte innleveringsfristen. Innlevert kode skal demonstreres for stud.ass innen én uke etter innleveringsfrist. Se for øvrig Blackboard-sidene for informasjon rundt organisering av øvingsopplegget og det tilhørende øvingsreglementet.
