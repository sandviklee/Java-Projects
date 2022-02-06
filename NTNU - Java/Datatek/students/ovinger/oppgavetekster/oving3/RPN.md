# Innkapsling - RPN-kalkulator-oppgave

Oppgaven handler om å lage en RPN-kalkulator (RPN = Reverse Polish Notation). I denne oppgaven kommer du til å ta i bruk en _stack_, og utføre matematiske operasjoner.

Her er en forklaring av hvordan en RPN-kalkulator fungerer:

> The RPN calculator differs from a normal calculator in that its syntax is completely different: It uses postfix notation instead of infix notation.
>
> Reverse polish notation, or postfix notation, is a notation where the operators (+, -, \*, /, ...) appear after the operands (1.0, 3.14, 2.187, 42, …). As an example, consider the expressions `2 – 1` and `9 + 3*4`. In RPN, this would be `2 1 -` and `9 3 4 * +`, as the operator shall appear after the operands. If the last example is confusing, think of it as `9 (3 4 *) +` instead.
>
> The main advantage of this is notation is that we can avoid parentheses and avoid determining which calculation to perform first. In infix, operator precedence is a problem: In the expression `9 + 3*4`, we first have to multiply, even though the plus operator appears first. In RPN, we simply take the first operator we see and apply it on the last two numbers we've seen, and replace the operator and operands with the result. For the multiplication and addition example:
>
> `9 3 4 * +` - the first operator we see is \*, so we apply that to the two last seen values, 3 and 4, and replace those elements with the result, 12
>
> `9 12 +` - the next operator we see is +, so we apply that to 9 and 12
>
> `21` - We are finished, as there are no more operators in the expression
>
> For the more complex expression `(9 + 7) / (5 – 3)`, this will be written as `9 7 + 5 3 - /` in RPN. Notice how we can avoid parentheses and still calculate what we want without any issues:
>
> `9 7 + 5 3 - /` - the first operator is +, so we perform `9 + 7` and replace those elements with the result
>
> `16 5 3 - /` - the next operator is -, so we perform the operation `5 – 3`, as those are the last two elements
>
> `16 2 /` - we perform the last operation, division:
>
> `8` - We are done, as there are no more operators left.
>
> Most RPN calculators have a stack of numbers, giving them control over which numbers to do operations on when they see the next operand. Whenever they see an operand, they push it on the stack. If they see an operator, they pop off the numbers required, perform the operation, and push the result on top of the stack again.
>
> As an example of how this will work, consider the example `9 3 4 * +` once more. Here, an RPN calculator will first push 9, 3 and 4 on the stack. The stack will now look like this: [9, 3, 4], where 4 is the top of the stack. Then, when the calculator see the operator _, it then pops 4 off the stack, pops 3 off the stack, and pushes 3 _ 4 on top of the stack. The stack which now contains [9, 12]. Then, when the RPN calculator sees the operator \*, it pops off 12 and 9 off the stack, and performs the operation 9 + 12, and pushes it back on top of the (now empty) stack. The stack will now contain [21].

Tilstanden i `RPNCalc`-objekter velger du selv, men det er naturlig å bruke en `Stack` eller `ArrayList` med `Double`-objekter.

`RPNCalc`-klassen skal ha følgende metoder:

- `void push(double)` - legg argumentet på toppen av stacken.
- `double pop()` - returner verdien på toppen av stacken. Verdien skal også fjernes fra stacken. Dersom stacken er tom, så skal `Double.NaN` returneres.
- `double peek(int)` - returner verdien i stacken som står på plassen gitt i argumentet, telt fra toppen. Det vil si, `peek(0)` skal returnere verdien på toppen av stacken, `peek(1)` skal returnere verdien nest øverst i stacken osv. Verdien skal ikke fjernes av stacken. Dersom det er for få elementer på stacken, så skal `Double.NaN` returneres.
- `int getSize()` - returner antallet elementer i stacken.
- `void performOperation(char)` - utfør den angitte operasjonen på de to øverste verdiene i stacken. De to verdiene skal fjernes fra stacken og resultatet skal legges øverst. Bruk eksisterende metoder for å utføre dette der det er mulig. Metoden må støtte '+' (pluss), '-' (minus), '\*' (multiplikasjon) og '/' (divisjon), men kan også støtte andre operatorer, f.eks. '~' (swap) for å bytte de to øverste operandene, 'p' eller 'π' (pi) for å legge pi på stacken (bruker ingen operander), '|' (absolutt-verdi, bruker én operand). Prøv å håndtere manglende operander på en måte som gir mening for operasjonen.

**(Valgfritt)** Det kan være nyttig å tegne [objekttilstandsdiagram](https://www.ntnu.no/wiki/display/tdt4100/Objekttilstandsdiagrammer) for en tenkt bruk av `RPNCalc`-klassen. Velg selv passende start-tilstand og sekvens av kall.

## Del 1 - Java-kode

Skriv Java-kode for `RPNCalc`-klassen med oppførsel som er beskrevet over. Du skal bruke synlighetsmodifikatorer på metoder og felt for å gjøre innkapslingen "vanntett".

Lag en [main-metode](https://www.ntnu.no/wiki/display/tdt4100/Main-metoden), hvor du tester sekvenser av operander og operatorer, og kaller henholdsvis `push` og `performOperation`-metodene på et `RPNCalc`-objekt og skriver ut stacken. Test `RPNCalc`-klassen og sjekk at oppførselen stemmer med tilstandsdiagrammet.

## Del 2 - Teori

Til nå har det blitt spesifisert at `peek()` og `pop()`-metodene skal returnere `Double.NaN` hvis stacken er tom. Alternativet er å utløse et unntak.

Svar på følgende:

- Hvilken type unntak vil det være naturlig å bruke?
- Hvilke fordeler og ulemper ser du for dette alternativet?

Det er også spesifisert at en skal "håndtere manglende operander på en måte som gir mening for operasjonen". Hvis `+`-operasjonen ble utført på kun én operand, så kan en f.eks. velge å la den manglende operanden være 0.

Svar på følgende:

- Hva vil tilsvarende verdi for manglende operand for `*`-operasjonen (multiplikasjon) være? Hva med for `/` (divisjon)?
- Hvordan kan du endre (evt. har du endret) grensesnittet for stack-operasjonene for å gjøre implementasjonen av disse enklere?
- Også her er et alternativ å utløse unntak. Hva tror du om det?

Testkode for denne oppgaven finner du i [oving3/RPNCalcTest.java](../../src/test/java/oving3/RPNCalcTest.java).
