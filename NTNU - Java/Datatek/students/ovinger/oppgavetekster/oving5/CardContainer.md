# Interface - CardContainer-oppgave
Denne oppgaven handler om å lage et felles grensesnitt for `CardDeck`- og `CardHand`-klassene, laget i oppgavene
[Innkapsling - Card-oppgave](../oving3/Card.md) og
[Objektstrukturer - Card-oppgave del 2](../oving5/Card.md).
Her skal du lage og implementere et grensenitt kalt `CardContainer`, som spesifiserer metoder for lesing av samlinger av Card-objekter.

## Del 1 - CardContainer interface

Definer et `CardContainer`-grensesnitt, med metodene som er felles for `CardHand` og `CardDeck`:

* `getCardCount()` - returnerer antall kort som dette objektet inneholder
* `getCard(int n)` - returnerer kort nr. `n` i dette objektet

Gjør nødvendig endringer i `CardHand`- og `CardDeck`-klassene for å implementere `CardContainer`-grensesnittet.

## Del 2 - Iterator for CardContainer

Lag en klasse kalt `CardContainerIterator`, som er en [Iterator](https://www.ntnu.no/wiki/display/tdt4100/Iterasjon+med+Iterator+og+Iterable)
for alle klasser som implementerer `CardContainer`-grensesnittet. `CardContainerIterator` må ha en konstruktør som tar inn en instans av (en klasse som implementerer) `CardContainer`. Du kan gjøre dette ved å ta inn et argument av typen `CardContainer`, altså `CardContainerIterator(CardContainer container) { ... }`.

*Hint*: Merk at `CardContainerIterator` ikke vet om `CardContainer`-objektet er et `CardDeck`-objekt, et `CardHand`-objekt eller et annet
objekt som implementerer `CardContainer`. Den har derfor ikke tilgang til de interne listene i `CardHand` og `CardDeck`.
Hvilke metoder må alle klasser som implementerer `CardContainer` ha, og hvordan kan disse metodene brukes for å lage en
[Iterator](https://www.ntnu.no/wiki/display/tdt4100/Iterasjon+med+Iterator+og+Iterable)?

Testkode for oppgaven finner du her: [oving5/CardDeckTest.java](../../src/test/java/oving5/CardDeckTest.java), [oving5/CardHandTest.java](../../src/test/java/oving5/CardHandTest.java) og [oving5/CardContainerIteratorTest.java](../../src/test/java/oving5/CardContainerIteratorTest.java). 

## Valgfri Ekstraoppgave

La `CardContainer`-grensesnittet utvide (`extends`) `Iterable<Card>` og la `iterator()`-metoden som dermed kreves, returnere en korrekt
konfigurert instans av `CardContainerIterator`.

