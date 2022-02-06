package uke4.fasit;

public class B {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.getNumber()); // 0 når det ikke er oppgitt.
        a.setTall(5);
        System.out.println(a.getNumber());

        // Ved hjelp av try-catch kan vi fange opp feil og programmet kan
        // fortsette å kjøre selv om det skjer noe galt. Dette vil dere
        // lære mer om senere, som å kunne lage egne feiltyper!
        try {
            a.setTall(15); // Dette går ikke vettu
        }
        catch (Exception ex) {
            System.out.println(ex); // Skrive ut feilen.
        }
        System.out.println(a.getNumber()); // Fremdeles 5.
    }
    
}
