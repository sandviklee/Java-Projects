package uke11.iostreams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;

public class MyIO {
    
    // InputStream.read() leser neste byte
    private static void readInputStream(InputStream inputStream) throws IOException {
        int byteVerdi = 0;
		while ((byteVerdi = inputStream.read()) > 0) { // Denne er fin, tilordne variabel inni while!
			System.out.println(byteVerdi + " er egentlig \t" + Character.toString((char) byteVerdi));
		}
    }

    // ISR.read() leser neste tegn, selv om det er mer enn 1 byte
    private void input_Stream_Reader(InputStream inputStream) {
        InputStreamReader isr = new InputStreamReader(inputStream);
        int c;
        try {
            while ((c = isr.read()) > 0 ) {
                System.out.println(c);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    // Denne inneholder 'try with resources', som automatisk lukker strømmen.
	public static void bufferedISR(InputStream is)  {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))){
			while (reader.ready()) {
				String line = reader.readLine();
				System.out.println("Linje: "+line);
				// automatisk lukking pga Closable-argument like etter try.
			}

		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private static void print_Writer() {
		try (PrintWriter writer = new PrintWriter ("C:/z/utFil.txt")) {
            writer.println("Tror du de skjønner noe ennå?");
            System.out.println(writer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

	}
	

    public static void file_Reader(String filepath) {
        try (Reader reader = new FileReader(new File(filepath))) {
            char[] buffer = new char[1000];
            int charCount;
            while ((charCount = reader.read(buffer)) > 0) { 
                System.out.println(buffer);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /* MAIN */
    public static void main(String[] args) {


        /* STRINGREADER - å lese tallverdiene på tegn (Charset) fra en streng. */
        StringReader sr = new StringReader("Dette er en streng");
        int i;

        try {
            while ((i = sr.read()) > 0) {
                // System.out.println(i + " er "+Character.toString((char) i));
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        /* PRINTWRITER */ 
        // print_Writer();

        /* INPUTSTREAM */
        // InputStream fra fil. Denne bruker 'try with resources', så en slipper å stenge strømmen.
        File initialFile = new File("C:/z/tekst.txt"); // Denne vil jo dere måtte legge inn selv.
        try (InputStream inputStream = new FileInputStream(initialFile)) {
            // readInputStream(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Vi kan lage en InputStream fra en nettside:
        try (
            InputStream inputStream = new URL("http://www.brainjar.com/java/host/test.html").openStream()) {
            // readInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /* BUFFEREDINPUTSTREAM */
        initialFile = new File("C:/z/tekst.txt");
        // try (InputStream inputStream = new FileInputStream(initialFile)) {
        // try (InputStream inputStream = new URL("https://www.themealdb.com/api/json/v1/1/random.php").openStream()) {
        try (InputStream inputStream = new URL("http://www.brainjar.com/java/host/test.html").openStream()) {
            bufferedISR(inputStream);
            } catch (IOException e) {
            e.printStackTrace();
        }

        /* FILEREADER */
        // file_Reader("C:/z/tekst.txt");

    }
}
