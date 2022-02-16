package uke7;

import java.util.ArrayList;
import java.util.Collection;


public class Folder {

    String name;
    Folder parent;
    Collection<Folder> folders = new ArrayList<>();
    Collection<File> files;

    

    public Folder(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
        files = new ArrayList<>();
        if (parent != null)
            parent.addFolder(this);
    }

    public void addFolder(Folder folder) {
        this.folders.add(folder);
    }

    public void removeFolder(Folder folder) {
        this.folders.remove(folder);
    }

    public String getName() {
        return name;
    }

    public Folder getParent() {
        return parent;
    }

    @Override
    public String toString() {
        String tmp = "/"+getName();
        if (this.parent != null)
            tmp = parent.toString() + tmp;
        return tmp;
    }

    Collection<Folder> getFolders() {
        return this.folders;
    }

    private boolean contains(Folder destination) {
        System.out.println("Contains: Er i "+this);
        if (this == destination) return true;
        for (Folder folder : folders) {
            if (folder.contains(destination))
            System.out.println("Contains: Sjekker "+this+" mot "+destination);
                return true;
        }
        return false;
    }

    private boolean contains2(Folder destination) {
        System.out.println("Contains2: sjekker"+this+" mot "+destination);
        if (this == destination) return true;
        if (null == destination) return false;
        else return this.contains2(destination.parent);

    }

    public void move(Folder destination) {

        System.out.println("Flytte "+this+ " til "+destination);

        if (this.contains(destination))
            throw new IllegalArgumentException("Rekursiv kopiering");

        parent.removeFolder(this);
        this.parent = destination;
        parent.addFolder(this);
    }

    void printTree() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(this);
        for (Folder folder : folders) {
            folder.printTree();
        }
    }

    public static void main(String[] args) {
    Folder home = new Folder("home",null);
    Folder andreas = new Folder("andreas",home);
    Folder borgeh = new Folder("borgeh",home);
    Folder carsten = new Folder("carsten",home);
    Folder adiv = new Folder("adiv",andreas);
    Folder bdiv = new Folder("bdiv",borgeh);
    Folder btmp = new Folder("btmp",borgeh);
    Folder cdiv = new Folder("cdiv",carsten);
    // System.out.println(home.getFolders()); 
    // System.out.println(andreas.getFolders());
    // System.out.println(home.contains(borgeh));    
    // System.out.println(borgeh.contains2(home));
    // cdiv.move(bdiv);
    // home.printTree();
    // System.out.println(cdiv);
    // File homefile = new File("home.txt", home);
    // home.printTree();
    // borgeh.move(cdiv);
    // borgeh.printTree();
    System.out.println("Sjekke contains: ");
    System.out.println(home.contains(bdiv)); // Her får vi med alle folderne...
    
    // Se på utskriften under. Hvorfor skrives Contains2-utskriften som er inni
    // contains2-metoden ut før denne linjen kommer ut?
    System.out.println("Sjekke contains2: "+home.contains2(bdiv));
    Folder foo = new Folder("Ikkeno", null);
    System.out.println("Sjekke contains mot noe som ikke finnes i treet: "+home.contains2(foo));
    
    }

}
