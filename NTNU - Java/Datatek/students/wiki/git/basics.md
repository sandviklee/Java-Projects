# Git del 1: Git basics

Før vi begynner med det praktiske, er det kjekt å ha litt grunnleggende kunnskap om git.
Denne delen vil gi en veldig kjapp slik innføring.

For det første: Git jobber med *repositories*, ofte forkortet til *repos*.
Et repo kan ses på som en mappe som inneholder alle filene du er interessert i å tracke.
F.eks. bruker øvingsopplegget i dette faget et repo som inneholder alle prosjektene våre (`foreksempel`, `lf`, `minegenkode` og `ovinger`).

Måten git tracker endringer i filer er via såkalte *commits*, som er en form for checkpoints.
Rent praktisk fungerer det ved at vi sier at git skal legge til endringer vi har endret på *indeksen* sin.
Indeksen er en oversikt over endringer vi vil at skal være med i neste commit.
Når vi har gjort nok endringer til at det gir mening å lagre et checkpoint, sier vi til git at den skal commite.
Da lagrer git de endringene vi har sagt i fra om, slik at vi på hvilket som helst tidspunkt kan se hvordan ting så ut på det tidspunktet, og eventuelt revertere til det om vi har klussa noe til.

En viktig forskjell her i forhold til f.eks. OneDrive eller DropBox er at git bare gjør som vi forteller den.
Den vil ikke tracke noen endringer med mindre vi sier i fra om det.
Dette er i utgangspunktet positivt, for da slipper vi å få en historie fyllt opp av alt som ikke fungerer og prøving av forskjellige ting.
Samtidig legger det et større ansvar på oss som utviklere til å huske å commite på naturlige tidspunkt.
Hva som går som naturlig varierer etter personlig preferanse, regler for prosjektet man jobber i, eller andre faktorer.

Det siste konseptet vi må vite om for å kunne bruke git effektivt er grener, eller *branches*.
En gren består i bunn og grunn av en serie med commits.
Det som gjør dem praktiske er det at man kan ha flere parallelle grener, der endringer i en gren ikke påvirker koden i de andre grenene.
Dette gjøres ved å *branche* ut av en eksisterende gren, og er spesielt praktisk om man skal jobbe flere på samme prosjekt.
Da kan man, når man skal starte med å jobbe på en ny del av prosjektet, lage en ny gren for dette.
I mens du jobber på din del av prosjektet, kan de du jobber sammen med fortsette på sin jobb uten at dere forstyrrer hverandre.
Det er vanlig å ha en hovedbranch, tradisjonelt kalt *master* (selv om en del jobber for å endre dette navnet til *main*), som man ikke bør skrive kode direkte i, men heller skrive all kode i grener som går ut i fra master.

Når du så er ferdig med en del av prosjektet ditt i en gren, må du få koden du har endret tilbake til master.
Dette gjør du ved en såkalt *merge*, som betyr at du tar alt du har gjort og kombinerer det med master (eller en annen branch).
Git er relativt smart, så ofte klarer den å gjøre denne kombinasjonen uten problemer.
Om det derimot har kommet endringer i master siden du branchet ut, kan du få en såkalt *merge conflict*.
Vi kommer tilbake til hvordan du løser det senere i denne guiden.

Bildet under viser en typisk tilstand i et git-repo.
Her er hvert punkt en commit, og hver farge tilsvarer en gren.
Vi ser at den blå grenen først kommer ut fra master, det gjøres et par commits i den, og så merges alt tilbake til master.
Underveis i denne prossessen startes også den grønne grenen (`feat/entry`, som betyr at dette er en *feature branch* som jobber med featuret *entry*. Dette er bare en navngivningsstandard, og har ingen spesiell betydinging utover navnet).
Denne jobbes med, men har enda ikke blitt merge tilbake i master.
Merk at den grønne grena ikke har blitt oppdatert med endringene som har kommet i `master` etter at den ble opprettet.
Om man ønsker å få inn oppdateringene kan man *merge `master` inn i `feat/entry`*.
Det vil oppdatere den grønne branchen med alle ting som har blitt lagt til i master etter at vi branchet ut.

Det er verdt å merke seg at bildet viser commits som er lagd direkte i `master`.
Dette er typisk ikke anbefalt, men er gjort for å forenkle figuren.
Dere kan tenke at dette er andre grener som har blitt merget inn i master. 
![Git Tree](img/tree.png)

Til slutt er det viktig å få med at git fungerer utmerket til å synkroniserer ditt lokale repo med et eksternt repo som ligger på en server.
Dette gjøres ved at lokale grener settes til å *tracke* grener på serveren, så man kan `push`e og `pull`e dem.
Git gjør det lett for oss å sette opp dette, og vi går gjennom de relevante kommandoene (`clone`, `push`, `pull`, `checkout`) i neste del.