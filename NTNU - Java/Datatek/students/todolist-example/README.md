# Todolist - eksempel på mini-app for prosjektet

Dette er både et eksempel på en enkel JavaFX-app tilsvarende det vi forventer i prosjektet, og
et greit prosjekt-oppsett basert på **maven**.

## Prosjekt-oppsett basert på maven

Maven brukes for å styre mange aspekter ved prosjektet, inkludert hva som regnes som kildekodemapper og hvor filer skal ligge og hvilke klassebiblioteker en får tilgang til.
Merk at mange IDE-er har sin egen måte å konfigurere, men de støtter som regel å lese oppsettet fra maven sin [**pom.xml**](pom.xml) i stedet, slik at det blir som beskrevet her.

### Mappestrukturen (for kildekode og ressurser)

I et standard maven-prosjekt så har en egne kildekodemapper for ulike formål:

- **src/main/java** - de vanlige java-filene
- **src/main/resources** - såkalte ressursfilene til de vanlige java-filene, f.eks. fxml-filer og bildefiler
- **src/test/java** - test-koden
- **src/test/resources** - ressursfiler for testkoden (ikke alltid så relevant)

Inni disse mappene ligger mappestrukturer som tilsvarer pakkestrukturen.
F.eks. ligger filene som tilhører pakken **todolist.core** i undermappen **todolist/core**.
NB! Det blir feil hvis en lager mapper som heter det *samme* som *hele* pakkenavnet (med punktum i), f.eks. **todolist.core**

Merk at det går an å konfigurere maven til å bruke en annen og enklere struktur, men det er like greit å bruke det som er standard for maven.

### Ressursfiler

Ressursfiler er filer som leses av appen og regnes som en del av det, men som ikke er Java-kode.
Datafiler som endres av appen er ikke en ressursfil, og slike skal som hovedregel ligge utenfor prosjektet!

En får tak i ressursfiler i appen ved å bruke `getClass().getResource(...sti relativ til klassen en er i...)`. F.eks. skal 
F.eks. så leser [**TodoApp**](src/main/java/todolist/fxui/TodoApp.java) inn [**Todo.fxml**](src/main/resources/todolist/fxui/Todo.fxml) med
`getClass().getResource("Todo.fxml)`. Grunnen til at filstien er såpass enkel er at [**TodoApp**]-klassen og [**Todo.fxml**]-fila logisk sett ligger i samme pakke,
selv om de ligger i hver sin mappestruktur.

Litt utdypet: I dette prosjektet ligger [**TodoApp**-klassen](src/main/java/todolist/fxui/TodoApp.java) i **todolist.fxui**-pakken under **src/main/java**, mens
[**Todo.fxml**](src/main/resources/todolist/fxui/Todo.fxml) ligger under **src/main/resources** i undermappen **todolist/fxui** (som tilsvarer **todolist.fxui**-pakken).
Da vil **TodoApp**-klassen kunne hente frem **Todo.fxml** med `getClass().getResource("Todo.fxml")`,
siden `"Todo.fxml"` er en relativ sti med utgangspunkt i **TodoApp**-klassen.
Alternativt kunne en brukt `getClass().getResource("/todolist/fxui/Todo.fxml")` (virker fra en hvilken som helst klasse),
fordi `"/todolist/fxui/Todo.fxml"` er en absolutt sti fra toppen av pakkestrukturen ned til samme fil.

### Tilgang til klassebiblioteker

Nokså ofte trenger en å bruke klasser som ikke er i Java sitt standardbibliotek, f.eks. til GUI og til testing.
I gamle dager måtte man laste ned disse som såkalte jar-filer, som er zip-filer med standard struktur og **.jar**-endelse, men
maven automatiserer nedlasting av dem. Det du selv må gjøre er å liste dem i pom.xml-fila som *avhengigheter*.

I pom.xml-fila finner en bl.a. følgende inni `<dependencies>-elementet:

```
        <!-- JavaFX FXML -->
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>15.0.1</version>
        </dependency>

        <!-- JUnit 5 -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.7.0</version>
            <scope>test</scope>
        </dependency>
```

Dette forteller maven at appen er avhengig av et spesifikt bibliotek (for JavaFX og FXML)
for å kompilere og kjøre den vanlige koden (i **src/main/java**) og
et annet spesifikt bibliotek (for JUnit 5) for å kompilere og kjøre testkoden (i **src/test/java**).
Biblioteket angis generelt med såkalte *maven-koordinater* i form **groupId**, **artifactId** og **version**.
Akkurat hva som er riktig for et gitt prosjekt kan være komplisert å finne ut av, men som regel har en et eksempel som en kopierer dette fra.

Hovedpoenget er at dette forteller maven eksakt hvilke biblioteksfiler den må laste ned og koble til prosjektet vårt, så IDE-en kan kompilere og kjøre koden, og ikke minst komme med forslag til klasse- og metodenavn i editoren. Denne automatikken er en av de store fordelene med å bruke maven!

### Maven-tillegg

Maven lar en automatisere og konfigurere en rekke oppgaver som må utføres ved app-utvikling. Dette gjøres gjennom
å referere til såkalte *tillegg* eller *plugins*. F.eks. kan en endre hvilken Java-versjon en bruker, hvilket
test-rammeverk en bruker, hvordan kjøre applikasjonen osv.

Tilleggene aktiveres og konfigueres med **<plugin>**-elementer, og i **pom.xml** er flere slike angitt.
F.eks. er **maven-compiler-plugin** og angitt og Java-versjonen er konfigurert i **<release>**-elementet.

Det finnes et vell av maven-tillegg som brukes til ulike formål, et par av dem beskrives lenger ned.
Felles for de fleste av disse, inkludert den for kompilatoring, er at de gjerne legger resultatet av
oppgaven deres på et spesifikt sted i **target**-mappa. F.eks. blir kompilerte filer lagt i **target/classes** og
**target/test-classes**.

## Lage kjørbar app

Ved utvikling så kjører en som regel appen direkte fra IDE-en, men det er fint å kunne lage en
selvstendig kjørbar versjon, så andre kan få kjørt den. Det finnes flere måter å gjøre dette på,
avhengig av hva andre må installere på forhånd for å få kjørt.

### Kjørbar app med Java installert (men uten JavaFX)

Java-applikasjoner pakkes gjerne som jar-filer, og det finnes et standard maven-tillegg for det. For å gjøre
appen lettere å kjøre så kan klassebiblioteker som er lagt inn som avhengigheter i pom.xml-fila, bakes inn i jar-fila.
En slik jar kalles gjerne en über-jar og gjøres av maven-tillegget **maven-shade-plugin**. For at kjøring skal virke
sammen med JavaFX-bibliotekene så må man lage en egen oppstartsklasse som kjører App-klassen.
Vår oppstartsklasse heter [**TodoLauncher**](src/main/java/todolist/fxui/TodoLauncher.java) og
dens eneste innehold er en **main**-metode som kaller main-metoden i **TodoApp**.

Hvis en nå kjører kommandoen `mvn package` i terminalen (i mappa der pom-fila ligger), så vil über-jar-fila
etterhvert dukke opp i **target**-mappa. Denne kan så kjøres med `java -jar target/todo-app.jar` (bytt ut **todo-app.jar** med navnet på den *største* jar-fila som dukker opp).

En må ha installert Java for å kjøre en slik über-jar, men en trenger altså ikke å ha installert JavaFX.
Du kan altså sende jar-fila til hvem som helst, be dem installere Java og kjøre i terminalen med ``java``-kommandoen.

### Kjørbar app uten Java installert

Java-applikasjoner kjøres vanligvis vha. en såkalt virtuell maskin (Java VM-en),
som sammen med Java sitt standard-bibliotek. utgjør Java sin *kjøretidsomgivelse*, den såkalte JRE-en.
For å lage en helt selvstendig app, må applikasjonen din pakkes sammen med JRE-en
(eller rettere sagt de delene av JRE-en som trengs for å kjøre akkurat din app) i en såkalt *native* applikasjon.
Det finnes to måter å gjøre det på, vha. **jlink** og **jpackage** eller
vha. Gluon sin **client-maven-plugin** og **graalvm**.

#### jlink og jpackage

En del av moderniseringen av Java-plattformen har handlet om støtte for å lage "skreddersydde" distribusjoner
av Java og pakke dem sammen med app-klasser til helt selvstendige, direkte kjørbare applikasjoner.
Dette bygger bl.a. på informasjonen i **module-info.java**, som spesifiserer presist hvilke *moduler*
applikasjonen vår trenger, om det nå er de som følger med standard Java eller om de oppgis i **pom.xml** og
lastes ned av maven.

Jobben med pakking gjøres av verktøyene **jlink** og **jpackage**, som er integrert i maven av tilleggene **javafx-maven-plugin** og **jpackage-maven-plugin**. **jlink** lager en skreddersydd JRE-distribusjon, mens
**jpackage** gjør lager en installasjonspakke for plattformen din (Linux, Mac eller Windows).
Basert på konfigurasjonen i **pom.xml** vil kommandoen `mvn javafx:jlink jpackage:jpackage` lage en slik pakke i **target/dist**, f.eks. vil en på Mac få en **dmg**-fil som en kan dobbeltklikke på for å installere selv appen.

Kilde: https://dev.to/cherrychain/javafx-jlink-and-jpackage-h9

#### Gluons client-maven-plugin og graalvm

Den andre teknikken er mer omstendelig, har noen begrensninger, men har også større potensiale,
siden den i tillegg til Linux, Mac eller Windows støtter Android, iOS og Raspberry Pi!.

I likhet med teknikken beskrevet over, så pakkes app-klassene sammen med en Java VM og tilhørende klasser. Men denne gangen brukes en minimalistisk VM kalt Substrate og app-koden gjennomanalyseres så bare de klassene som koden din
faktisk trenger blir tatt med.

Den største delen av jobben gjøres av **Graal**, som først må installeres. Du laster ned **graal** fra
https://github.com/gluonhq/graal/releases/latest (velg den som heter noe med **graalvm-ce-java...** for din plattform) og pakker ut til et passende sted. Så konfigureres **client-maven-plugin** i **pom.xml** og en kjører kommandoen
`mvn client:build client:package` for å pakke applikasjonen og evt. `mvn client:run` for å prøvekjøre.
Hvis en bruker **FXML** (eller såkalt *refleksjon* hvor en laster inn klasser dynamisk basert på navn)
så må en liste opp alle klasser som refereres til ved navn i alle fxml-filer i **<reflectionList>**-elementet,
typisk kontroller-klassen og de som importeres med `<?import ...?>`-direktiver.

Det er et par begrensninger, f.eks. at Graal bare støtter noen spesfikke Java-versioner. Jeg måtte f.eks. endre til Java 11 (Java 16 er visst også støttet, men det fikk jeg ikke til å virke).
Prosessen tar en del tid og hvis en glemmer å oppgi en klasse i **<reflectionList>**-elementet,
så får en kjøretidsfeil og må gjøre det på nytt.

Som nevnt støttes også mobilplattformene Android og iOS, men det krever mer installasjon på forhånd, og selve prosessen kan ikke kjøres på en alle plattformer,
f.eks. må en ha Linux for å bygge for Android og Mac for å bygge for iOS.
Det er også mer krevende å få applikasjonen inn på mobilen eller nettbrettet evt. teste på en emulator.
Heldigvis finnes det en eksempelprosjekter og demonstrasjonsvideoer.

Kilde: https://docs.gluonhq.com/#_the_gluon_client_plugin_for_maven.
