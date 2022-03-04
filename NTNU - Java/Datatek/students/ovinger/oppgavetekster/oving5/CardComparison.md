# Interface - CardComparison-oppgave
Denne oppgaven hander om to måter å håndtere sortering av `Card`-objekter, med grensesnittene `Comparable` og `Comparator`, som er innebygd i Java
(`java.util.Comparable`, `java.util.Comparator`).

Vi tar i denne oppgaven utgangspunkt i `Card`-klassen fra [Innkapsling - Card-oppgave](../oving3/Card.md). Et `Card`-objekt har en kortfarge (av typen *char*) og verdi (*int*), og sortering gjøres på disse verdiene, ved at en først sorterer på kortfarge og så på verdi. Siden Java har sorteringsmetoder innebygd trenger vi ikke bry oss om selve sorteringsalgoritmen. Vi fokuserer her på logikken for *sammenligning* av `Card`-objekter, altså hvilke `Card` som skal komme før/etter andre.

## Del 1
La `Card`-klassen implementere `Comparable` med følgende sammenligningslogikk

*  `compareTo`-metoden skal sammenligne et kort med et annet, slik at 
   - spar kommer etter hjerter
   - hjerter kommer etter ruter
   - ruter kommer etter kløver
   - Ved lik kortfarge skal verdien brukes i stigende rekkefølge, altså 1 (ess) kommer før 2, kommer før 3 osv. til og med 11 (knekt), 12 (dame) og 13 (konge).

Skriv testkode som sorterer kort i en liste vha. `Collections.sort` og `Comparable`-logikken, og verifiser at sammenligningslogikken er riktig implementert.

*Hint:* Returner `-1` for å sette kortet `this` før kortet som blir gitt inn, `0` dersom de er like, og `1` dersom `this` skal komme etter det gitte kortet.

## Del 2
For å kunne sortere `Card`-objekter med annen logikk, så kan en bruke grensesnittet `Comparator`, som er et objekt som kan sammenligne
objekter parvise. Implementer en `Comparator` (dvs. lag en klasse som *implements* `Comparator`) kalt `CardComparator`, som kan
konfigureres (stilles inn) til å sortere med ess som høyeste kort og med en bestemt kortfarge som trumf, altså en kortfarge som regnes
som høyere enn de andre.

*  `CardComparator` må ha en konstruktør som tar inn en *boolean* og en *char*. *boolean*-argumentet sier om ess skal regnes som størst (`true`)
eller minst (`false`) og *char*-argumentet angir hvilke kortfarge som er trumf. F.eks. skal et `CardComparator`-objekt laget med
`new CardComparator(true, ' ')` rangere ess høyere enn konge og bruke standard rangering av kortfarger
(siden trumf-argumentet ikke er en av kortfargene), og et `CardComparator`-objekt laget med `new CardComparator(false, 'C')`
rangerer ess lavest og kløver ('C' = clubs) høyest av kortfargene (de andre kortfargene har standard rangering med spar over
hjerter over ruter).

Skriv testkode som sorterer kort i en liste vha. `Collections.sort` og `Comparator-logikken`, og verifiser at sammenligningslogikken er riktig implementert.

Testkode for del 1 og del 2 finner du her: [oving5/CardComparatorTest.java](../../src/test/java/oving5/CardComparatorTest.java).

## Valgfri Ekstraoppgave
Utvid `CardComparator` slik at den kan konfigureres med en annen rangering av kortfargene, f.eks. slik at kløver er høyere enn ruter.
Merk at denne fortsatt skal overstyres av evt. trumf. Nytten er altså at en kan endre rangeringsrekkefølgen på alle på én gang.

