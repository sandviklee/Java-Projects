# Interface - CardPredicate-oppgave

Denne oppgaven handler om hvordan en kan bruke det funksjonelle `Predicate<T>`-grensesnittet, sammen med `CardDeck`-klassen. Vi tar i denne oppgaven utgangspunkt i `CardDeck`-klassen fra [Innkapsling - Card-oppgave](../oving3/Card.md). Et `CardDeck`-objekt har en liste med `Card`-objekter. `Card` har en kortfarge (av typen `char`) og verdi (`int`), og vi ønsker å lage metoder i `CardDeck` som søker opp `Card`-objekter som tilfredsstiller visse kriterier, f.eks. sjekker om spar dame finnes, teller antall hjerter eller henter ut alle ess. For å representere selve kriteriet brukes [`Predicate<T>`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Predicate.html)-grensesnittet, som handler om å teste/sjekke om et objekt
tilfredsstiller visse kriterium.

**Implementer** følgende metoder i `CardDeck`-klassen:

- `boolean hasCard(Predicate<Card> predicate)` - Skal returnere `true` dersom det finnes et kort som tilfredsstiller `predicate`, `false` ellers.
- `int getCardCount(Predicate<Card> predicate)` - Skal returnere hvor mange kort som tilfredsstiller `predicate`.
- `List<Card> getCards(Predicate<Card> predicate)` - Skal returnere en liste med de kortene som tilfredsstiller `predicate`.

Lag også din egen main-metode hvor du prøver hver av de tre metodene over. Du skal altså sjekke om spar dame finnes, telle antall hjerter og
hente ut alle ess.

Hvordan en kan opprette funksjonelle grensesnitt kan du se på [wikisiden](https://www.ntnu.no/wiki/display/tdt4100/Lambda-uttrykk+og+funksjonelle+grensesnitt+i+Java+8) om dette.
