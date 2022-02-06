package of3.kode;

public class StrengSammenligning {

    public static void main(String[] args) {
        System.out.println("Eksempel med sammenligning med == :");
        String longString = "Dette er en lang streng";
        System.out.println(longString.substring(0, 5));
        System.out.println(longString.substring(0, 5) == "Dette");

        System.out.println("\nEksempel med sammenligning med .equals() :");
        System.out.println(longString.substring(0, 5).equals("Dette"));

        System.out.println("\nEksempel med sammenligning av to String()-objekter :");
        String streng1 = new String("Test");
        String streng2 = new String("Test");
        System.out.println(streng1 == streng2);
        System.out.println(streng1.equals(streng2));

        System.out.println("\nEksempel med sammenligning av to 'string literals' :");
        System.out.println("Test" == "Test");

    }

}
