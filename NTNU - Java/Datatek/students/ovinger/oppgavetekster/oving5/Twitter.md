# Interface - Sortering av TwitterAccount-objekter ved bruk av Comparator

Denne oppgaven handler om sortering av `TwitterAccount`-objekter, ved bruk av grensesnittet `Comparator`. Oppgaven illustrerer
hvordan man kan sortere objekter av samme klasse på ulike måter, ved hjelp av ulike implementasjoner av `Comparator`.

Vi tar i denne oppgaven utgangspunkt i `TwitterAccount`- og `Tweet`-klassen fra [Objektstrukturer - Twitter-oppgave](../oving5/Twitter.md).
Et `TwitterAccount`-objekt har et brukernavn, en liste over andre brukere som følges, en liste over brukere som følger denne brukeren
(dette `TwitterAccount`-objektet), og en liste med tweets. Vi ønsker å kunne sortere `TwitterAccount`-objekter på tre ulike parametre:

1. Brukernavn
1. Antall følgere
1. Antall tweets

## Del 1

I denne delen av oppgaven skal du lage tre ulike implementasjoner av `Comparator`-grensesnittet. `Comparator`-grensesnittet inneholder
én metode `compare(Object o1, Object o2)`. Implementasjonen av denne metoden skal returnere:

- et negativt tall dersom objektet o1 skal komme før objektet o2 i en sortert rekkefølge
- et positivt tall dersom objektet o1 skal komme etter objektet o2 i en sortert rekkefølge
- 0 om det er likegyldig hvilken rekkefølge objektene har (dvs. de er like hverandre for den parameteren/de paremetrene de sorteres på)

De tre klassene du skal lage er som følger:

- `UserNameComparator`: sammenligner `TwitterAccount`-objektene på brukernavn, slik at brukeren “Apekatten” vil komme før
  “Bjørnen” som igjen vil komme før “Cameleonen” (dvs. leksikalsk rekkefølge - tenk rekkefølgene brukernavnene ville stått i et
  leksikon eller en ordbok)
- `FollowersCountComparator`: sammenligner `TwitterAccount`-objektene på antall følgere, slik at brukeren med flest følgere havner først.
- `TweetsCountComparator`: sammenligner `TwitterAccount`-objektene på antall tweets, slik at brukeren med flest tweets havner først.

Alle klassene skal implementere `Comparator<TwitterAccount>`.

[Hint om sammenligning av strenger](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html#compareTo(java.lang.String))

[Hint om sammenligning av tall](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Integer.html#compareTo(java.lang.Integer))

## Del 2

I denne delen av oppgaven skal du legge til en funksjon i `TwitterAccount`-klassen som lar deg hente ut en sortert versjon av følgerene
til dette (`this`) `TwitterAccount`-objektet. Funksjonen du skal implementere er som følger:

- `getFollowers(Comparator<TwitterAccount>)` - skal returnere en sortert kopi av følgere-listen til dette `TwitterAccount`-objektet.
  Objektene skal sorteres ved å bruke det `Comparator`-objektet som tas inn som parameter. Dersom parameteren er `null` skal du returnere
  den orginale (usorterte) versjonen av følgere-listen. Du skal ikke skrive din egen sorteringsalgoritme, men bruke
  `Collections.sort`-funksjonen fra `java.utils`-biblioteket. Merk at den opprinnelige følgere-listen skal være uforandret etter at
  denne funksjonen har blitt kjørt.

Testkode for oppgaven finner du her:

- [oving5/twitter/TwitterAccountTest.java](../../src/test/java/oving5/twitter/TwitterAccountTest.java)
- [oving5/twitter/FollowersCountComparatorTest.java](../../src/test/java/oving5/twitter/FollowersCountComparatorTest.java)
- [oving5/twitter/TweetsCountComparatorTest.java](../../src/test/java/oving5/twitter/TweetsCountComparatorTest.java)
- [oving5/twitter/UserNameComparatorTest.java](../../src/test/java/oving5/twitter/UserNameComparatorTest.java)

## Valgfri Ekstraoppgave

Lag en klasse `TwitterAccountComparator` som implementerer `Comparator<TwitterAccount>` og sammenligner `TwitterAccount`-objekter på
følgende måte:

- `TwitterAccount`-objektet med flest følgere skal komme først.
- Dersom to `TwitterAccount`-objekter har like mange følgere skal det `TwitterAccount`-objektet med flest tweets komme først.
- Dersom to `TwitterAccount`-objekter har like mange følgere og tweets skal `TwitterAccount`-objektene sammenlignes på brukernavn.
