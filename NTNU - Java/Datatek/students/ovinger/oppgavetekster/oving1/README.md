# Øving 1: Objekter og klasser, tilstand og oppførsel

**Øvingsmål**:

- Bli kjent med Java-syntaks og bruk av VSCode
- Lære (enkel) objektorientert tankegang
- Lære å lage enkle Java-klasser og -programmer

**Øvingskrav**:

- Kunne tegne enkle tilstandsdiagrammer
- Kunne deklarere klasser, med data og kode, iht. oppgavespesifikasjon
- Kunne skrive main-metoder for å teste objekter
- Kunne bruke standardtyper og -metoder (e.g. toString()-metoden)

## NB: Viktig beskjed!

For å få testene og eventuell kode til øvingene lokalt brukes systemet git. I VSCode kan du klikke på Source Control (Venstresiden av programmet) -> Tre prikker øverst -> Pull for å hente den nye øvingen ved hjelp av dette.

## Dette må du gjøre

Oppgavene for denne øvingen skal lagres i [`ovinger/src/main/java/stateandbehavior`](../../src/main/java/stateandbehavior). Test-filene som kjøres for å teste koden ligger i [`ovinger/src/test/java/stateandbehavior`](../../src/test/java/stateandbehavior).

Hvis du ikke allerede har gjort det, må du installere VSCode med det forhåndskonfigurerte oppsettet for TDT4100. Se [denne](https://www.ntnu.no/wiki/display/tdt4100/VS+Code) wikisiden for en guide. Dersom du opplever problemer med oppsett/installasjon send oss gjerne en melding på Teams i "Teknisk Hjelp" kanalen, still et spørsmål på Piazza eller spør din læringsassistent!

**Del 1 - Tilstandsdiagram**

For én av oppgavene du gjør i del 2: Tegn et [objekttilstandsdiagram](https://www.ntnu.no/wiki/x/gSfuAw) for en tenkt bruk av klassen. Velg selv en passende start-tilstand og en sekvens av kall. Lag dette diagrammet før du begynner med koden.

**Del 2 - Java-kode**

Du skal velge og gjennomføre minst tre av de følgende oppgavene angående [Tilstand og oppførsel](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=65937373).

- [Account (Lett)](./Account.md)
- [Location (Lett)](./Location.md)
- [Digit (Lett)](./Digit.md)
- [UpOrDownCounter (Medium)](./UpOrDownCounter.md)
- [LineEditor (Vanskelig)](LineEditor.md)
- [Stopwatch (Vanskelig)](Stopwatch.md)
- [Rectangle (Vanskelig)](Rectangle.md)

Oppgavene er merket med en vanskelighetsgrad relativt til hverandre. Det er en god idé å begynne med de lettere oppgavene dersom du ikke er komfortabel med pensum så langt, men det er anbefalt å prøve seg på de vanskeligere oppgavene om du synes de første oppgavene er uproblematiske. Dersom du allerede føler deg trygg på punktene i øvingskravene kan du forsøke å gå rett på de vanskeligere oppgavene. Du er selvfølgelig velkommen til å løse flere oppgaver enn minstekravet, hvilket lurt gjøres med tanke på eksamen og et langt liv som programmerende.

Før du setter i gang kan det vært lurt å lese wiki-siden om [Tilstand og oppførsel](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=65937373) nøye, samt ta en titt på det tilhørende `Counter`-eksempelet. Forelesningene og tilhørende øvingsforelesning er selvsagt også lure å få med seg

Det finnes masse ressurser på [wikien](https://www.ntnu.no/wiki/display/tdt4100/Faginnhold) om hvordan ulike metoder skal fungere, f.eks `toString`-metoden og ulike metoder for teksthåndtering. Naviger deg litt rundt om du lurer på noe.

### Hjelp/Mistanke om bugs

Ved spørsmål eller behov for hjelp konsulter studassen din i saltiden hans / hennes. Du kan også oppsøke andre studasser på sal eller legge ut et innlegg på [Piazza](piazza.com/ntnu.no/spring2022/tdt4100).

### Godkjenning

Last opp kildekode på Blackboard innen den angitte innleveringsfristen. Innlevert kode skal demonstreres for læringsassistent innen én uke etter innleveringsfrist. Se Blackboard-sidene for mer informasjon rundt organisering av øvingsopplegget og det tilhørende øvingsreglementet.
