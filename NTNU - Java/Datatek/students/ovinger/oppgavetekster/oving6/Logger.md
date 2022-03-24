# Delegering - Logger-oppgave

Denne oppgaven bruker delegeringsteknikken for å implementere en fleksibel måte å håndtere logging (av feil i programmer) på.

## Logging

Ved kjøring av programmer er det ofte behov for å logge hva som skjer underveis, slik at det blir lettere å drive feilsøking i etterkant. F.eks. kan en lagre feilmeldinger til fil, med tidspunkt og litt om programtilstanden og hvis programmet kræsjer ordentlig, så kan brukeren sende logg-fila som e-post til utviklerne. En enkel måte å støtte logging på er å lage en hjelpeklasse med én metode, f.eks. `log(String melding)`, og så er det hjelpeklassen som bestemmer om meldingen skal vises i statuslinja, skrives til fil, sendes som melding til en alarmsentral osv. Hjelpeklassen kan kanskje brukes av mange programmer, og siden behovene vil variere er det viktig å gjøre dette fleksibelt. Denne oppgaven bruker [grensesnitt](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=65936813) og [delegeringsteknikken](https://www.ntnu.no/wiki/display/tdt4100/Delegeringsteknikken) for å implementere fleksibel logging, litt på samme måte som eksisterende loggingsrammeverk (se f.eks. [Java sin egen loggingsfunksjonalitet](http://docs.oracle.com/javase/6/docs/technotes/guides/logging/overview.html), Apache sitt [log4j-rammeverk](http://logging.apache.org/log4j/), eller Googles ["Java logging framework"](https://www.google.no/search?q=java+logging+frameworks)).

Alle filene i denne oppgaven skal lages i [oving6/delegation](../../src/main/java/oving6/delegation)

### ILogger-grensesnittet

Logging gjøres ved å bruke ulike implementasjoner av **ILogger**, som er definert som følger:

```java
package delegation;

public interface ILogger {
    public String ERROR = "error", WARNING = "warning", INFO = "info";
    public void log(String severity, String message, Exception exception);
}
```

ILogger-grensesnittet definerer én log-metode som brukes til all logging:

- `severity`-argumentet angir alvorlighetsgraden, og må være en av **String**-verdiene **ERROR**, **WARNING** eller **INFO**, som er definert som konstanter i grensesnittet.
- `message`-argumentet er en melding om hva som var feil.
- `exception`-argumentet er et unntaksobjekt, som kan gi mer informasjon av hva som var feil, men kan være **null**.

En typisk bruk vil være i **catch**-delen av en **try/catch**:

```java
ILogger logger = ...
...
try {
    ...
} catch (IOException ioe) {
    logger.log(ILogger.ERROR, "Feil ved lesing fra fil", ioe);
}
```

Akkurat hvordan logging utføres bestemmes av hvilken implementasjon av ILogger-grensesnittet en bruker, og i denne oppgaven skal du implementere følgende tre klasser:

- **DistributingLogger** - delegerer til andre loggere basert på _alvorlighetsgraden_
- **FilteringLogger** - delegerer til en annen logger, men kun for spesifikke alvorlighetsgrader
- **StreamLogger** - skriver logg-meldingen til en angitt strøm

Hver av disse utgjør én av deloppgavene beskrevet under.

## Del 1 - StreamLogger

En **StreamLogger** sørger for å skrive alle logg-meldinger til en angitt **OutputStream**, med én melding pr. linje (altså linjeskift mellom hver melding). **OutputStream**-objektet må gis inn i konstruktøren:

- `StreamLogger(OutputStream stream)` - initialiserer **StreamLogger**-objektet slik at logg-meldinger skrives til **stream**.

Eksempel på bruk:

```java
ILogger logger = new StreamLogger(System.out);
logger.log(ILogger.INFO, "Denne meldingen er til informasjon og skrives til System.out", null);
```

Husk å kalle **flush**-metoden til OutputStream etter at logg-meldingen er skrevet.

Det skal også være mulig å angi en såkalt _format_-string, dvs. en **String** som fungerer som en slags mal for hva som skrives, f.eks. `"%s: %s (%s)"`:

- `setFormatString(String formatString)` - setter format-string-en som brukes for å lage logg-meldingen som skrives

Effekten av skriving skal være som om man ga format-string-en som første argument til **String.format**-metoden etterfulgt av severity-, message- og exception-argumentene, og så skrev ut det denne metoden returnerer:

```java
String logMessage = String.format(formatString, severity, message, exception);
// skriv logMessage til OutputStream-en her
```

Merk at dersom format-string-en ikke er satt, så skal den ha en fornuftig start-verdi.

Testkode for oppgaven: [oving6/delegation/StreamLoggerTest.java](../../src/test/java/oving6/delegation/StreamLoggerTest.java).

## Del 2 - FilteringLogger

**FilteringLogger**-klassen implementerer **ILogger**-grensesnittet og delegerer til en annen **ILogger**-implementasjon, men bare hvis _alvorlighetsgraden_ er en av et sett angitte verdier. Både loggeren det delegeres til og alvorlighetsgradene angis når **FilteringLogger**-objektet opprettes:

- `FilteringLogger(ILogger logger, String... severities)` - initialiserer **FilteringLogger**-objektet så det delegerer logging til **logger**-argumentet, men bare hvis _alvorlighetsgraden_ som gis til **log**-metoden er en av verdiene angitt i **severities**-argumentet. **severities**-argumentet er et såkalt varargs-argument, som du kan lese mer om her: [Varargs - variabelt antall argumenter](https://www.ntnu.no/wiki/display/tdt4100/Varargs+-+variabelt+antall+argumenter). Det viktigste å vite her er at det du får inn i metoden din vil være en variabel `severities` som er av typen string array (`String[]`). Du kan hente ut elementer her via `severities[0]`, sjekke lengde ved `severities.length` og ellers bruke alle normale arraymetoder.

Det skal også være mulig å sjekke om logging er på og slå logging av og på i etterkant:

- `boolean isLogging(String severity)` - returnerer **true** hvis logging er slått på for den angitte alvorlighetsgraden og **false** ellers.
- `void setIsLogging(String severity, boolean value)` - slår logging på (**value = true**) eller av (**value = false**) for den angitte _alvorlighetsgraden_

Eksempel på bruk:

```java
ILogger syserrLogger = new StreamLogger(System.err);
FilteringLogger logger = new FilteringLogger(syserrLogger, ILogger.ERROR);
logger.log(ILogger.ERROR, "Denne meldingen er alvorlig og skrives til System.err", null);
logger.log(ILogger.WARNING, "Denne meldingen er en advarsel og blir filtrert bort", null);
logger.log(ILogger.INFO, "Denne meldingen er til informasjon og blir filtrert bort", null);
logger.setIsLogging(ILogger.WARNING, true);
logger.log(ILogger.WARNING, "Denne meldingen er en advarsel og blir nå skrevet til System.err", null);
```

Testkode for oppgaven: [oving6/delegation/FilteringLoggerTest.java](../../src/test/java/oving6/delegation/FilteringLoggerTest.java).

## Del 3 - DistributingLogger

**DistributingLogger**-klassen brukes for å fordele logg-meldinger til en av tre andre loggere, avhengig av _alvorlighetsgraden_ til en logg-melding. Den har én hjelpe-logger for meldinger med alvorlighetsgrad **ERROR**, én for meldinger av alvorlighetsgrad **WARNING** og en for meldinger av alvorlighetsgrad **INFO**. Alle disse angis til konstruktøren:

- `DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger)` - initialiserer objektet slik at den første loggeren brukes til alvorlighetsgraden **ERROR**, den andre til alvorlighetsgraden **WARNING** og den tredje til alvorlighetsgraden **INFO**.

I tillegg skal klassen ha en metode for å sette hver av dem individuelt:

- `void setLogger(String severity, ILogger logger)` - setter/endrer loggeren som brukes for den angitte alvorlighetsgraden.

Eksempel på bruk:

```java
ILogger syserrLogger = new StreamLogger(System.err);
ILogger sysoutLogger = new StreamLogger(System.out);
DistributingLogger logger = new DistributingLogger(syserrLogger, syserrLogger, sysoutLogger);
logger.log(ILogger.ERROR, "Denne meldingen er alvorlig og skrives til System.err", null);
logger.log(ILogger.WARNING, "Denne meldingen er en advarsel og skrives til System.err", null);
logger.log(ILogger.INFO, "Denne meldingen er til informasjon og skrives til System.out", null);
logger.setLogger(ILogger.WARNING, sysoutLogger);
logger.log(ILogger.WARNING, "Denne meldingen er en advarsel, men nå skrives den til System.out", null);
```

Testkode for oppgaven: [oving6/delegation/DistributingLoggerTest.java](../../src/test/java/oving6/delegation/DistributingLoggerTest.java).
