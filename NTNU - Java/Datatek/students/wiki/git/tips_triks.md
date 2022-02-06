# Git del 4: Tips og Triks

Her kommer det en liste over noen tips og triks for å bruke git.
Jeg kommer bare til å vise terminal-versjonen her, fordi jeg ikke har brukt Eclipse sin git-integrasjon nok til å vite hvordan man gjør det der.
Du kan sannsynligvis finne ut av hvordan du gjør alt dette der ved å lete gjennom menyene og tilgjengelig views.

## Se logg
Vi har jo lært at git lagrer historien vår som en serie commits, der hver commit har en melding.
Vi kan undersøke denne historien med en enkel kommando:
```bash
git log
```

Det vil vise alle commits som er gjort i grenen vi er i, inkludert hvem som commitet, når commiten ble gjort, en commit hash (som identifiserer commiten), og commit-meldingen.
Loggen vises i et `less`-aktig vindu, så trykk `q` for å gå ut av den.

Om man bare vil ha en rask oversikt over historien, kan man i stedet bruke
```bash
git log --oneline
```
som kun viser en forkortet commit hash og første linje av commit-meldinga.

Til slutt kan vi få en oversikt over grener, litt som i bildene brukt i denne guiden, ved å skrive
```bash
git log --graph
```
eller
```bash
git log --oneline --graph
```

Personlig har jeg lagd en alias for det siste, så jeg bare kan skrive
```bash
git tree
```
og få opp en slik logg.
Det gjør du med
```bash
git config --global alias.tree 'log --oneline --graph'
```

## Blame
Om du jobber på et prosjekt sammen med andre, kan det noen ganger være kode du ikke forstår, og trenger hjelp med.
Da kan man bruke `blame`-funksjonaliteten.
```bash
git blame <filename>
```
Da får du opp en liste med alle linjene i fila, og hvem som sist endret den linja.
En mer praktisk måte å kalle kommandoen på er nok
```bash
git blame -w -L <n>,<m> <filename>
```
der `<n>` og `<m>` er hhv. første og siste linje du bryr deg om, og `-w` betyr at git ignorerer endringer i whitespace.