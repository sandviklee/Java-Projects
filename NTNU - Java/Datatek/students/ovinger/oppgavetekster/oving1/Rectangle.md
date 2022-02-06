# Tilstand og oppførsel – Rectangle

Oppgaven handler om en `Rectangle`-klasse, som håndterer et firkantet område i et koordinatsystem, med sider parallelle med koordinataksene.

Tilstanden i `Rectangle`-objekter er ikke spesifisert eksplisitt, men må velges slik at metodene nedenfor kan implementerers. Merk at alle metodene jobber med heltallsstørrelser.

`Rectangle`-klassen har metoder for å spørre om tilstanden og endre tilstanden. Spørremetodene dekker høyde og bredde og koordinatene til øverste venstre og nederste høyre hjørne og om rektanglet inneholder spesifikke punkt(er). Endringsmetodene dekker utviding ved å legge til punkter.

Logikken til metodene må tilfredsstille følgende krav:

- Når en utvider et `Rectangle`-objekt med en av `add`-metodene, så skal ikke rektanglet bli større enn nødvendig, dvs. at dersom man må utvide rektangelet skal det bare utvides slik at det akkurat inneholder det nye punktet.
- Et rektangel er tomt dersom enten bredden eller høyden er 0.

Konstruktører:

- `Rectangle(int x1, int y1, int x2, int y2)` - Lager et minst mulig rektangel som inneholder både punktene `(x1, y1)` og `(x2, y2)`

Spørremetoder:

- `int getMinX()` og `int getMinY()` - returnerer henholdsvis $`x`$- og $`y`$-koordinatene til punktet med lavest $`(x,y)`$-verdier som er inneholdt i dette rektanglet.
- `int getMaxX()` og `int getMaxY()` - returnerer henholdsvis $`x`$- og $`y`$-koordinatene til punktet med høyest $`(x,y)`$-verdier som er inneholdt i dette rektanglet.
- `int getWidth()` og `int getHeight()` - returnerer henholdsvis bredden og høyden til rektanglet. Begge skal returnere $`0`$, dersom dette rektanglet er tomt.
- `boolean isEmpty()` - returnerer `true` om rektanglet er tomt, dvs. om bredden og/eller høyden er $`0`$.
- `boolean contains(int x, int y)` - returnerer `true` om punktet $`(x,y)`$ er inneholdt i dette rektanglet, og `false` ellers.
- `boolean contains(Rectangle rect)` - returnerer `true` om hele `rect`, dvs. alle hjørnepunktene i `rect`, er inneholdt i dette rektanglet, og false ellers.

Endringsmetoder:

- `boolean add(int x, int y)` - utvider (om nødvendig) dette rektanglet slik at det (akkurat) inneholder punktet $`(x,y)`$. Returnerer `true` om dette rektanglet faktisk ble endret, ellers `false`.
- `boolean add(Rectangle rect)` - utvider (om nødvendig) dette rektanglet slik at det (akkurat) inneholder hele `rect`-argumentet. Returnerer `true` om dette rektanglet faktisk ble endret, ellers `false`. Dersom `rect` er tomt, så skal dette rektanglet ikke endres.

Andre metoder:

- `Rectangle union(Rectangle rect)` - returnerer et nytt `Rectangle`-objekt som tilsvarer kombisjonen av dette rektanglet og `rect`-argumentet. Alle punktene som finnes i ett av rektanglene skal altså være inneholdt i rektanglet som returneres.

## Java-kode

Skriv Java-kode for `Rectangle`-klassen med oppførsel som er beskrevet over.

Lag en passende `toString()`-metode og et hovedprogram, der du gjennomfører en valgfri sekvens av kall som viser at koden oppfører seg som tenkt. Om du tegnet tilstandsdiagram for denne oppgaven i Del 1, kan du bruk sekvens av kall her.

Testkode for denne oppgaven finner du her: [src/test/java/stateandbehavior/RectangleTest.java](../../src/test/java/stateandbehavior/RectangleTest.java).

## Ekstraoppgave

Implementer følgende metoder:

- `Rectangle intersection(Rectangle rect)` - returnerer et nytt `Rectangle`-objekt som tilsvarer overlappet mellom dette rektanglet og `rect`-argumentet. Alle punktene som finnes i begge rektanglene skal altså være inneholdt i rektanglet som returneres. Dersom rektanglene ikke overlapper skal `null` returneres.
- `boolean intersects(Rectangle rect)` - returnerer `true` om dette rektanglet og `rect`-argumentet overlapper, dvs. om det finnes ett eller flere punkter som er inneholdt i begge disse rektanglene.

Testkode for ekstraoppgaven finner du her: [src/test/java/stateandbehavior/RectangleExtraTest.java](../../src/test/java/stateandbehavior/RectangleExtraTest.java).
