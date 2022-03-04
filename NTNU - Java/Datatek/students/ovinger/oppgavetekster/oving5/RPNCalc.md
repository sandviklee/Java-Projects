# Interface - RPNKalkulator med funksjonelle grensesnitt

Denne oppgaven handler om å gjøre det enklere å utvide en kalkulator ved å bruke det innebygde funksjonelle grensesnittet `BinaryOperator<T>`, sammen med **RPNCalc**-klassen.

Vi tar i denne oppgaven utgangspunkt i **RPNCalc**-klassen fra [Øving 3 - RPN-kalkulator](../oving3/RPN.md)-oppgave. Et **RPNCalc**-objekt består av en stack med tall, metoder for å håndtere stacken, og `performOperation(char)` metoden, som utfører en operasjon gitt av parameteret. For eksempel vil kallet `performOperation('*')` fjerne de to øverste tallene fra stacken, multiplisere dem, og pushe resultatet på toppen av stacken. Om operasjonene hardkodes i metoden, vil det være vanskelig å endre hva kalkulatoren kan gjøre under kjøring. Denne oppgaven går derfor ut på å gjøre det mulig å legge til og fjerne operasjoner fra kalkulatoren. Operasjoner på en og to flyttall kan representeres ved bruk av henholdsvis `UnaryOperator<Double>`- og `BinaryOperator<Double>`-grensesnittene, og operasjoner uten operander (f.eks. pi) kan representeres ved bruk av `Supplier<Double>`.

Implementer følgende metoder i **RPNCalc**-klassen:

- `boolean addOperator(char, BinaryOperator<Double>)` - Legg til en operator som virker på to tall (f.eks +) hvis operatoren ikke allerede er lagt til. Returner true hvis den nye operatoren blir lagt til
- `void removeOperator(char)` - Fjern operatoren med tegn operatorSign

Du må også oppdatere `performOperation(char)` til å bruke operatorene som legges til via metodene over. Om man prøver å kalle `performOperation` med en operator som ikke er lagt til skal det utløses et `UnsupportedOperationException`-unntak.

## Valgfri Ekstraoppgave

Utvid programmet til å kunne ta inn operatorer som tar inn et parameter (`UnaryOperator<Double>`, f.eks. `|` (absoluttverdi)) og ingen parametre (`Supplier<Double>`, f.eks. `p` (pi)). Husk at du må håndtere forsøk på å legge til samme operator i flere kategorier (f.eks. om man prøver å legge til `+` som både **UnaryOperator** og **BinaryOperator** må det håndteres på en god måte).

Dette vil innebære å legge til metodene

- `boolean addOperator(char, UnaryOperator<Double>)`
- `boolean addOperator(char, Supplier<Double>)`

som fungerer på samme måte som `addOperator(char, BinaryOperator<Double>)`, samt å oppdatere resten av koden til å fungere med de forskjellige operatortypene.

**Hjelp / mistanke om bugs**

Ved spørsmål eller behov for hjelp konsulter studassen din i saltiden hans / hennes. Du kan også oppsøke andre studasser på sal eller legge ut et innlegg på Piazza.

**Godkjenning**

Last opp **kildekode** på Blackboard innen den angitte innleveringsfristen. Innlevert kode skal demonstreres for stud.ass innen én uke etter innleveringsfrist. Se for øvrig Blackboard-sidene for informasjon rundt organisering av øvingsopplegget og det tilhørende øvingsreglementet.
