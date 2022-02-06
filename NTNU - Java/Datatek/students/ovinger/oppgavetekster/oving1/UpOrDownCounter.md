# Tilstand og oppførsel – UpOrDownCounter

I denne oppgaven skal du programmere en teller, ikke ulik den som er beskrevet i [Tilstand og oppførsel](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=65937373) og kodet i [Tilstand og oppførsel - Java-kode for Counter-eksempel](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=65937823), som også skal håndtere tilfellet hvor slutt-verdien er lavere enn start-verdien ved å telle nedover.

## Java-kode

`UpOrDownCounter`-klassen skal altså ha de samme konstruktørene/metodene:

- `UpOrDownCounter(int start, int end)` - initialiserer objektet med angitte start- og slutt-verdier, hvor altså slutt kan være større eller mindre enn start, slik at telleren teller henholdsvis opp eller ned. Lik start og slutt-verdi skal utløse unntak av typen `IllegalArgumentException` (se [Koding av valideringsmetoder](https://www.ntnu.no/wiki/display/tdt4100/Koding+av+valideringsmetoder)).
- `int getCounter()` - returnerer telleren
- `boolean count()` - beveger telleren i retning av slutt-verdien og returnerer true så lenge den ikke har nådd den, altså om telleren har mer igjen, og false ellers.

Testkode for oppgaven finner du her: [src/test/java/stateandbehavior/UpOrDownCounterTest.java](../../src/test/java/stateandbehavior/UpOrDownCounterTest.java)
