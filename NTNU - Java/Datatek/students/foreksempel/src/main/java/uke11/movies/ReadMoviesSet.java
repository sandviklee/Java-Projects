package uke11.movies;

import java.util.ArrayList;
import java.util.Collection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ReadMoviesSet {

    // Hva heter de ulike tingene
    String[] headers;

    // Public, bare så man kan leke med den på forelesning. Ellers vil en jo skjule dette...
    public Collection<GenericHashSet> movies = new ArrayList<>();


    // De klassene vi bruker her kommer vi litt inn på senere i semesteret!
    private void readHeaders(String filename) {
        headers = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filename)))
            .lines().findFirst().get().split("\t");
    }

    private void readMovies(String filename) {
        try { // Denne under er et alternativ til den over. Men mye vi ikke har hatt ennå, ei heller dekker mye...
            this.movies = Files.lines(Paths.get(getClass().getResource(filename).toURI()))
            .skip(1) // Hopper over første linje, den inneholder navnet på hver kategori
            .map(s -> new GenericHashSet(headers, s.split("\t"))) // Mekke nytt objekt for hver film
            .toList();            
                
        } catch (Exception e) {
            System.out.println("Feil: "+e);
        }
    }
    
    // Konstruktør
    // Først lese første linje for å hente headers, så lese inn filmene og legge dem i samlingen
    public ReadMoviesSet(String filename) {
        this.readHeaders(filename);
        this.readMovies(filename);
    }


    public static void main(String[] args) {
        ReadMoviesSet rf = new ReadMoviesSet("movies.txt");
        System.out.println("Første film: "+rf.movies.stream().findFirst().get());
        System.out.println("\nAntall filmer: "+
            rf.movies.stream().filter(m -> m.getData("titleType").equals("movie")).count());

        System.out.println("\nFilmer med 'The' i tittel: "+
            rf.movies.stream()
                .filter(m -> m.getData("titleType").equals("movie"))
                .filter(m -> m.getData("primaryTitle").contains("The"))
                .map(m -> m.getData("primaryTitle"))
                .toList());

        // Når ble alle ting som har startdato filmet, i snitt: Denne er nok litt rotete, mer prinsippet.
        System.out.println("Snitt startår: "+rf.movies.stream()
            .filter(m -> !m.getData("startYear").equals("\\N"))
            .mapToInt(m -> Integer.parseInt(m.getData("startYear").equals("\\N")?"0":m.getData("startYear")))
            .sum() / 
            rf.movies.stream().filter(m -> !m.getData("startYear").equals("\\N")).count());
        
    }
}
