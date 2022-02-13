# Objektstrukturer - Card-oppgave del 2

Denne oppgaven handler om klasser for kortspill: `Card` (kort), `CardDeck` (kortstokk) og `CardHand` (korthånd), hvorav de to siste inneholder én eller flere `Card`-objekter. Oppgaven bygger på `Card` og `CardDeck` i [Øving 3 - Card-oppgave](../oving3/Card.md).

I mange sammenhenger vil objekter av en klasse inneholde eller "eie" objekter av andre klasser, og de underordnede objektene vil kunne flyttes/overføres mellom de overordnede. Når en klasse er assosiert med én instans av en (annen) klasse er dette en [1-1-assosiasjon](https://www.ntnu.no/wiki/display/tdt4100/Koding+av+1-1-assosiasjoner) og når en klasse er assosiert med flere instanser av en annen klasse er dette en [1-n-assosiasjon](https://www.ntnu.no/wiki/display/tdt4100/Koding+av+1-n-assosiasjoner). Et eksempel er kortspill, hvor kortene starter i kortstokken, fordeles på korthender og til slutt ender i en kortbunke. Et kort kan bare være ett sted om gangen, og må overføres fra ett sted til et annet, f.eks. fra kortstokk til korthender i utdelingsfasen. I [Innkapsling - Card-oppgave](../oving3/Card.md) ble det lagd logikk for kortstokk og enkeltkort. I denne oppgaven skal du implementere logikk for korthender, og utvide kortstokkens logikk litt.

`Card`-klassen har du allerede implementert, men du må sannsynligvis kopiere koden over fra `oving3` til `oving4`. Her er det enklest å lage en ny `Card`-klasse i `oving4` og så lime inn innholdet fra den gamle.

`CardDeck`-klassen har du også implementert, og denne må også flyttes på samme måte som Card. Denne klassen skal utvides:

- `deal(CardHand, int n)` - flytter n kort fra kortstokken (`CardDeck`-objektet) til korthånda (`CardHand`-objektet, som er første argument), ved å ta ett og ett kort med høyeste gyldige indeks, fjerne det fra `CardDeck`-objektet og legge det til `CardHand`-objektet.

`CardHand` er en ny klasse som skal implementeres. `CardHand`-objekter inneholder initielt ingen kort, og klassen inneholder de samme standardmetodene som `CardDeck`, altså `getCardCount()` og `getCard(int)`, for å lese hvor mange og hvilke kort den inneholder. I tillegg har den to metoder for å endre tilstand:

- `addCard(Card)` - legger argumentet til dette `CardHand`-objektet
- `play(int n)` - returnerer og fjerner kort nr. n (første kort har nr. 0) fra dette `CardHand`-objektet (som om det ble spilt ut)

**Java-kode**

Utvid `CardDeck` og lag `CardHand` som beskrevet over. Test klassene med selvlagde main-metoder og ved å kjøre JUnit-testene.

Testkode for denne oppgaven finner du her: [CardTest.java](../../src/test/java/oving4/CardTest.java), [CardDeckTest.java](../../src/test/java/oving4/CardDeckTest.java), [CardHandTest.java](../../src/test/java/oving4/CardHandTest.java).
