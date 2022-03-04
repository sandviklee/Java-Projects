# Debugging - StringMergingIterator-oppgave

Oppgaven handler om feilsøking ("debugging") av en Iterator-implementasjon ved bruk av [**debuggeren**](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=235996724) i VSCode.

Les først denne artikkelen om bruk av debugger i VSCode om du ikke er kjent med dette: [Kjøring av kode og debugging i VS Code](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=235996724)

Klassen **StringMergingIterator** implementerer grensesnittet [**Iterator<String>**](https://www.ntnu.no/wiki/display/tdt4100/Iterasjon+med+Iterator+og+Iterable), og leverer annenhver verdi fra to andre iteratorer av typen **Iterator<String>**. Denne iteratoren fletter altså verdiene fra to andre gitte iteratorer, og er altså en meta-iterator. Meta-iteratorer er iteratorer som bruker andre iteratorer som datakilder. Se lysark om teknikken: [Forelesningslysark om meta-iteratorer](https://docs.google.com/file/d/0B9IltfWcNirndERTb1RnTGM3YWs/preview)

**StringMergingIterator** har følgende konstruktør:

- `StringMergingIterator(Iterator<String> first, Iterator<String> second)`

Siden klassen implementerer **Iterator<String>** har den også følgende metoder:

- `boolean hasNext()` - returnerer `true` dersom iteratoren har flere verdier, `false` dersom det ikke er flere verdier.
- `String next()` - returnerer den neste verdien fra iteratoren, eller utløser et `NoSuchElementException` dersom iteratoren er tom.

I denne oppgaven blir en implementasjon av **StringMergingIterator** sammen med et testprogram utdelt, men i implementasjonen av klassen har vi plantet en eller flere feil. Målet for oppgaven er å finne feilene i implementasjonen ved hjelp av [debuggeren](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=235996724) i VSCode. Kjør programklassen **StringMergingIteratorProgram** i debug-modus, og bruk dette til å finne ut hvor **StringMergeIterator** gjør feil. Dersom programklassen lykkes med å få en flettet strøm med verdier har du funnet alle feilene.

Merk at du *ikke* skal gjøre noen endringer **StringMergingIteratorProgram**, men bruke dette programmet til å teste logikken i **StringMergingIterator**.