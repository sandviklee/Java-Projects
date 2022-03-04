# Interface - StringGrid-oppgave

Denne oppgaven handler om et grensnitt (interface) for rutenett som holder strenger (StringGrid), hvordan slike implementeres og hvordan en kan iterere gjennom et slikt rutenett ved hjelp av en [Iterator](https://www.ntnu.no/wiki/display/tdt4100/Iterasjon+med+Iterator+og+Iterable).

I denne oppgaven tar vi utgangspunkt i et **StringGrid**-grensesnitt som definerer metodene til et rutenett som holder strenger. Et rutenett er firkantet og består av et antall rader og kolonner. Det skal være mulig å spørre rutenettet hvilken streng som er på angitt rad og kolonne i tillegg til å endre strengen på angitt rad og kolonne. Denne oppførselen er oppsummert i det definerte **StringGrid**-grensesnittet under:

```java
package oving5;

/*
An interface with methods for managing the content of a String grid.
The grid has a number of rows (the grid's height) and columns (the grid's width).
In each cell in the grid there is a String that can be set with the setElement method and read with the getElement method.
*/
 public interface StringGrid {

    // Returns the number of rows in this StringGrid
    public int getRowCount();
    // Returns the number of columns in this StringGrid
    public int getColumnCount();

    // Returns the String at the given row and column. Throws an IllegalArgumentException if the row or column is out of range
    public String getElement(int row, int column);
    // Sets the String at the given row and column. Throws an IllegalArgumentException if the row or column is out of range
    public void setElement(int row, int column, String element);
}
```

Alle klasser som implementerer **StringGrid**-grensesnittet må støtte de fire definerte metodene.

## Del 1 - StringGrid-grensesnitt og implementerende StringGridImpl-klasse

Lag en **StringGridImpl**-klasse som implementerer **StringGrid**-grensesnittet definert over. Merk at grensesnitt ikke kan brukes til å spesifisere konstruktører, så du må selv definere en eller flere egnede konstruktører. Det er imidlertid nødvendig å implementere en konstruktør som tilsvarer den JUnit-testen forventer:

- `StringGridImpl(int rows, int columnCount)` - konstruktør som tar inn antall rader som `rows` og antall kolonner som `columnCount`.

Du står fritt til å velge hvordan metodene definert av grensesnittet skal implementeres så lenge de tilfredsstiller den definerte oppførselen. 

**Hint:** Bruk en enkel `ArrayList<String>` eller en dobbel `ArrayList<ArrayList<String>>` (se wiki-siden om [todimensjonale matriser](https://www.ntnu.no/wiki/display/tdt4100/Todimensjonale+matriser)).

## Del 2 - StringGridIterator-klasse

Det er hensiktmessig å kunne iterere over alle elementene i et rutenett som implementerer grensesnittet **StringGrid**, f.eks. når en bygger en streng i en **toString()**-metode eller skal sjekke om et spill har blitt avsluttet / vunnet. I denne deloppgaven skal du lage en slik [Iterator](https://www.ntnu.no/wiki/display/tdt4100/Iterasjon+med+Iterator+og+Iterable)-implementasjon, kalt **StringGridIterator**. Denne klassen må implementere grensesnittet `Iterator<String>`, siden **StringGrid** inneholder **String**-objekter. I tillegg til metodene som er definert i **Iterator**-grensesnittet, må **StringGridIterator** ha en konstruktør som tar imot hvilken **StringGrid** det skal itereres over og i hvilken rekkefølge elementene skal returneres i. Disse verdiene må huskes, så koden i **Iterator**-metodene kan brukes dem til å styre iterasjonen. **StringGridIterator**-klassen må altså støtte følgende konstruktør / metoder:

- `StringGridIterator(StringGrid, boolean)` - konstruktør som tar inn **StringGrid**-objektet som **StringGridIterator**-klassen skal iterere over i tillegg til en logisk verdi som angir om iterasjonen skal være bortover først (`rowMajor=true`) eller nedover først (`rowMajor=false`).
- `boolean hasNext()` - returnerer true så lenge det er flere **String**-objekter igjen i **StringGrid**-objektet som ikke ennå er blitt iterert over (mao. sjekk om du har kommet til siste rute i rutenettet).
- `String next()` - returnerer det neste **String**-objektet i rutenettet. Hvilken **String** som er den neste, avhenger av hvordan rutenettet skal itereres (mao. om `rowMajor=true` eller `rowMajor=false`).
- `void remove()` - denne metoden skal bare utløse et unntak av typen `UnsupportedOperationException` siden det ikke skal være mulig å fjerne `String`-objekter fra rutenettet.

## Del 3 - Iterable-grensesnittet

Endre **StringGrid**-grensesnittet slik at det utvider (med extends) [**Iterable<String>**](https://www.ntnu.no/wiki/display/tdt4100/Iterasjon+med+Iterator+og+Iterable). Dette skal gjøre det mulig å skrive for-setningen under, for å gå gjennom alle elementene i rutenettet.

```java
StringGrid stringGrid = ... // her initialiseres stringGrid
// gå gjennom alle elementene i stringGrid
for (String s: stringGrid) {
    // gjør noe med s her
}
```

Rekkefølgen som en slik for-setningen går gjennom elementene på, skal være hele første rad, så hele andre rad osv. til og med siste rad.

Hva slags følger får det for **StringGridImpl**? Gjør nødvendige endringer i den også, og test at det virker!

Testkode for del 1 og del 2 finner du her: [oving5/StringGridTest.java](../../src/test/java/oving5/StringGridTest.java). 
