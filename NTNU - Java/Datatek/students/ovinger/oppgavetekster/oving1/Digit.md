# Tilstand og oppførsel – Digit

Oppgaven handler om en `Digit`-klasse, som representerer ett siffer i et gitt tallsystem.

Tilstanden i `Digit`-objekter er todelt:

- en `int` som angir tallsystemet, f.eks. 10 for titallssystemet, som oppgis i konstruktøren. Denne verdien vil ikke bli satt over 36.
- en `int`-verdi, som representerer siffer-verdien i det angitt tallsystem og må være fra og med 0 til (men ikke med) tallsystem-verdien

Konstruktøren tar inn en `int`, som initialiserer tallsystem-verdien, mens siffer-verdien settes til 0.

`Digit`-tilstanden leses og oppdateres med følgende metoder:

- `int getValue()` - returnerer siffer-verdien
- `boolean increment()` - øker siffer-verdien med én. Dersom den da når tallsystem-verdien, så (re)settes den til 0 og metoden returnerer `true`, ellers returnerer den `false`.
- `int getBase()` - returnerer tallsystemet.

## Java-kode

Skriv Java-kode for `Digit`-klassen med oppførsel som er beskrevet over. Lag også en `toString()`-metode som returnerer siffer-verdien som en `String`, hvor sifrene 0-9 etterfølges av A-Z. F.eks. skal siffer-verdien 10 i sekstentallssystemet gi "A" som returverdi.

Lag en `main`-metode, der du gjennomfører en valgfri sekvens av kall som viser at koden oppfører seg som tenkt. Om du tegnet tilstandsdiagram for denne oppgaven i Del 1, kan du bruk samme sekvens av kall her.

Testkode for denne oppgaven finner du her: [src/test/java/stateandbehavior/DigitTest.java](../../src/test/java/stateandbehavior/DigitTest.java).

## Ekstraoppgave

La hovedprogrammet opprette tre `Digit`-objekter, som fungerer som sifre i et tre-sifret tall. Lag en løkke som teller fra 0 til høyest mulig verdi som kan representeres i tallsystemet. Legg så til 1 så verdien av det tre-sifrede tallet igjen blir 0. Velg selv hvilket tallsystem du vil bruke.
