# Innkapsling - Vehicle-oppgave

Oppgaven handler om en `Vehicle`-klasse, som håndterer informasjon om et kjøretøy og implementerer innkapslingsmetoder med validering.

Et `Vehicle`-objekt inneholder type _kjøretøy_, _drivstoffet_ det bruker og _registreringsnummer_:

- Typen kan være enten motorsykkel eller bil.
- Drivstoffet kan være enten hydrogen, elektrisitet, diesel eller bensin. Kun biler kan gå på hydrogen.
- Gyldige registreringsnummeret avhenger av typen kjøretøy og drivstoff etter følgende regler:
  - Kjøretøy som går på elektrisitet skal ha registreringsnummer som starter med bokstavene `"EL"` eller `"EK"`
  - Hydrogenbilene har registreringsnummer som begynner med bokstavene `"HY"`
  - Dieselkjøretøy og bensinkjøretøy har registreringsnummer som begynner på to bokstaver. De kan ikke være `"EK"`, `"EL"` eller `"HY"`. Bokstavene Æ, Ø og Å skal ikke brukes.
  - For alle drivstoff gjelder det at det skal være brukt store bokstaver.
  - Ellers så gjelder det at motorsykler har 4 sifre etter bokstavene, mens biler har 5.

Følgende metoder må implementeres:

- `Vehicle(char, char, String)` - Konstruktør der argument-rekkefølgen må være kjøretøystype, drivstofftype og registreringsnummer. Ved ugyldige argumenter utløses unntak av typen `IllegalArgumentException`.
- `getFuelType()` - returnerer type drivstoff som følgende: `'H'` for hydrogen, `'E'` for elektrisitet, `'D'` for diesel eller `'G'` for bensin.
- `getRegistrationNumber()` - returnerer registreringsnummeret
- `setRegistrationNumber(String)` - endrer registreringsnummeret dersom det er gyldig i henhold til kravene over, og utløser unntak av typen `IllegalArgumentException` dersom det ikke er gyldig.
- `getVehicleType()` - returnerer kjøretøystype: `'M'` for motosykkel, `'C'` for bil.

## Del 1 – Java-kode

Implementer `Vehicle`-klassen som beskrevet over med stram innkapsling. Eventuelle hjelpemetoder for validering bør også ha stram innkapsling. Det kan være lurt å lese om [String-klassen](https://www.ntnu.no/wiki/display/tdt4100/java.lang.String) og dens metoder før du setter i gang.

Testkode for denne oppgaven finner du i [oving2/VehicleTest.java](../../src/test/java/oving2/VehicleTest.java).

Merk at din implementasjon må ligge i en pakke med samme navn som testkodens pakke. Pass derfor på at Vehicle-klassen ligger i pakken `oving2`.
