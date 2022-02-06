package of3.kode;

public class StrengSplitting {

    public static void main(String[] args) {
        String domenenavn = "www.example.com";

        System.out.println("Splitting med bare punktum:");
        String[] domenekomponenter = domenenavn.split(".");
        for (String komponent : domenekomponenter) {
            System.out.println(komponent);
        }

        System.out.println("\nSplitting med 'escaped' punktum:");
        String[] domenekomponenter2 = domenenavn.split("\\.");
        for (String komponent : domenekomponenter2) {
            System.out.println(komponent);
        }

    }

}
