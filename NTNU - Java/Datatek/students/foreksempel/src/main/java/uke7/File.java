package uke7;

public class File {
    
    String name;
    Folder parent;

    public String getName() {
        return name;
    }

    public Folder getParent() {
        return parent;
    }

    public File(String name, Folder parent) {

        if (parent == null) {
            throw new IllegalArgumentException("En fil må ha en folder");
        }
        // Sjekke om navn er noe. 
        this.name = name;
        this.parent = parent;
        parent.addFile(this);
    }

    
    @Override
    public String toString() {
        return parent.toString()+"/"+getName();
    }

    public void move(Folder destination) {

        parent.removeFile(this);
        this.parent = destination;
        parent.addFile(this);
    }
}
