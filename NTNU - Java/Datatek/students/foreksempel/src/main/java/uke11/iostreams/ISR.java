package uke11.iostreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Poenget med denne klassen er å vise at når man leser fra InputStream så leses en og en byte, det betyr at
 * dersom man bruker et Charset som bruker flere byte per tegn så vil ikke teksten leses korrekt.
 */
public class ISR {
    
    private static void readInputStream() {
        InputStream inputStream = ISR.class.getResourceAsStream("utf8.txt");
        int byteVerdi = 0;
		try {
            while ((byteVerdi = inputStream.read()) > 0) { // Denne er fin, tilordne variabel inni while!
            	System.out.println(byteVerdi + " er egentlig \t" + Character.toString((char) byteVerdi));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readISR() {
        InputStreamReader isr;
        try {
            isr = new InputStreamReader(ISR.class.getResourceAsStream("utf8.txt"), "UTF-8");
            int byteVerdi = 0;
	        while ((byteVerdi = isr.read()) > 0) { // Denne er fin, tilordne variabel inni while!
            	System.out.println(byteVerdi + " er egentlig \t" + Character.toString((char) byteVerdi));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



        public static void main(String[] args) {
            
            // readInputStream();
            readISR(); // Børge: For å vise kinesiske tegn, skriv dette i terminalvinduet: chcp 65001
            
        }
}
