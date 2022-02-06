# Tilstand og oppførsel – Account

Oppgaven handler om en `Account`-klasse, som håndterer data i en bankkonto. Tilstanden i `Account`-objekter er som følger:

- `balance` - et desimaltall som angir beløpet som er på kontoen
- `interestRate` - et desimaltall som angir rentefot som prosentpoeng.

Begge verdiene skal være satt til `0.0` når klassen opprettes.

`Account`-klassen har fem metoder, med følgende oppførsel:

- `deposit(double)` - øker konto-beløpet med den angitte argument-verdien (et desimaltall), men kun dersom det er positivt. Dersom det er negativt skal ingen endring skje.
- `addInterest()` - beregner rente og legger det til konto-beløpet
- `getBalance()` - returnerer beløpet som er på kontoen.
- `getInterestRate()` - returnerer rentefoten
- `setInterestRate(double)` - oppdaterer renten til å være den nye verdien

## Java-kode

Skriv Java-kode for `Account`-klassen med oppførsel som er beskrevet over.

Lag en passende `toString()`-metode og en `main`-metode, der du gjennomfører en valgfri sekvens av kall som viser at koden oppfører seg som tenkt. Om du tegnet tilstandsdiagram for denne oppgaven i Del 1, kan du bruk samme start-tilstand og sekvens av kall her.

Testkode for denne oppgaven finner du her: [src/test/java/stateandbehavior/AccountTest.java](../../src/test/java/stateandbehavior/AccountTest.java).
