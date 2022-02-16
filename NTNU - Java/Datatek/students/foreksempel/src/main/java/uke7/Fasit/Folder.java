package uke7.Fasit;

import java.util.ArrayList;
import java.util.List;

public class Folder {

	String name;
	Folder parent;
	List<Folder> folders;
	List<File> files;

	public static void main(String[] args) {
		Folder home = new Folder("home",null);
		Folder borgeh = new Folder("borgeh",home);
		Folder hal = new Folder("hal",home);
		Folder div = new Folder("div",borgeh);
		//		home.printTree();
		borgeh.setName("kari");
		System.out.println("borgeh i hal: "+hal.contains2(borgeh));
		borgeh.move(hal);
		//		borgeh.printTree();
		System.out.println("borgeh i hal: "+hal.contains2(borgeh));

		// Litt kode for � vise hvordan contains2 er elendig i forhold til contains!
		// Vi lager tretti nye foldere inni home.
		// for (int i = 0; i < 30; i++) {
		// 	home.addFolder(new Folder(Integer.toString(i),home));				
		// }

		// Inni hver av home sine subfoldere lager vi tretti nye foldere.
		// for (Folder folder : home.folders) {
		// 	for (int i = 0; i < 30; i++) {
		// 		folder.addFolder(new Folder(Integer.toString(i),folder));				
		// 	}
		// }


		home.printTree();

		// Se p� forskjellen i hva som skrives ut av disse - hvilken er mest effektiv?
		//		home.contains2(home.folders.get(25));
		//		System.out.println("contains:");
		//	Folder destination = home.folders.get(23).folders.get(24);
		//	System.out.println(destination);
		//	System.out.println(home.contains(destination));
		//		versus home.contains2(destination);

		File homefil = new File("tmpfil.txt",home);
		File egenfil1 = new File("egenfil.txt", borgeh);
		File egenfil2 = new File("egenfil2.txt", borgeh);
		File tvillingfil1 = new File("tvillingfil.txt", borgeh);
		File tvillingfil2 = new File("tvillingfil.txt", hal);
		egenfil2.move(home);
		home.printTree();
		System.out.println("FindFirst:" + home.findFirst("hal"));
		
		System.out.println(home.findAll("tvillingfil.txt"));
	}


	List<File> findAll(String pattern) {
		List<File> result = new ArrayList<>();
		
		findAll(pattern, result);
		
		return result;
	}


	private void findAll(String pattern, List<File> result) {
		for (File file : files) {
			if (matchesName(pattern, file.getName())) {
				System.out.println("Match!");
				result.add(file);
			}
		}
		for (Folder folder : folders) {
			folder.findAll(pattern, result);
		}
	}


	Object findFirst(String pattern) {
		for (File file : files) {
			if (matchesName(pattern, file.getName()))
				return file;
		}
		
		for (Folder folder : folders) {
			if (matchesName(pattern, folder.getName()))
				return folder;
		}
		
		for (Folder folder : folders) {
			Object found = folder.findFirst(pattern);
			if (found != null)
				return found;
		}
		
		return null;
		
	}


	private boolean matchesName(String pattern, String name) {
		return pattern.equals(name);
	}


	/* 
	 * Dette er den 'enkleste' m�ten � tenke seg at en sjekker om
	 * destination er en subfolder av this. Problemet er at denne sjekker
	 * potensielt ALLE subfoldere til ALLE subfoldere. Det kan bli mye!
	 * contains sjekker motsatt vei i 1:n-relasjonen mellom en folder
	 * og dens subfoldere, da er det kun 1 objekt per niv�, og ikke n.
	 */
	boolean contains2(Folder destination) {
		//		System.out.println("Sjekker mot "+destination.toString());
		if (this == destination)
			return true;
		for (Folder folder : folders) {
			System.out.println("Sjekker s� mot "+folder.toString());
			if (folder.contains2(destination))
				return true;
		}		
		return false;
	}

	/*
	 *  Hvordan fungerer contains?
	 *  Hvis en skal sjekke om this inneholder destination, s�
	 *  kan en sjekke alle parents til destination helt til parent
	 *  er null for om den aktuelle Folder (dest, dest.parent, 
	 *  dest.parent.parent etc, men dette skjer rekursivt) er lik this.
	 *  Hvis den er lik this, s� m� en returnere True siden destination da
	 *  ligger i en subfolder til this, eller dypere. 
	 *  Hvis en kommer helt dit og ender opp med null, da 
	 *  returnerer en false - destination er ikke en subfolder.
	 */
	boolean contains(Folder destination) {
		if (destination != null)
			System.out.println("Sjekker mot " + destination.toString());
		if (destination == this) {
			return true;
		}
		else if (destination == null) {
			return false;
		}
		else return this.contains(destination.parent);
	}

	private void move(Folder destination) {
		System.out.println("Skal flytte " + this.getName() + 
				" til " + destination.getName());
		if (destination != null && this.contains(destination)) {
			throw new IllegalStateException("Uendelig l�kke...");
		}

		// parent m� ha beskjed f�r vi endrer parent til en ny Folder.
		parent.removeFolder(this);

		// Selv
		this.parent = destination;

		// ny parent m� f� beskjed
		parent.addFolder(this);

	}

	private void removeFolder(Folder folder) {
		folders.remove(folder);
	}

	private void printTree() {
		System.out.println(this);

		for (File file : files) {
			System.out.println(file.toString());
		}

		for (Folder folder : folders) {
			folder.printTree();
		}

	}

	@Override
	public String toString() {
		String tmp = "/" + name;
		if (parent != null)
			tmp = parent.toString() + tmp;
		return tmp;
	}
	public Folder(String name, Folder parent) {
		super();
		folders = new ArrayList<>();
		files = new ArrayList<>();

		//		files = new ArrayList<>();
		this.name = name;
		//		this.parent = parent; // Denne strykes, brukes igjen etterp�.
		if (parent != null) {
			setParent(parent);
			parent.addFolder(this);
		}

	}
	void addFolder(Folder folder) {
		if (!folders.contains(folder)) // Lagt til denne etter forelesning!
			folders.add(folder);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new IllegalStateException("Name cannot be null.");
		}
		if (name.length() == 0)
			throw new IllegalStateException("Name cannot be of zero length.");
		this.name = name;
	}

	public Folder getParent() {
		return parent;
	}
	public void setParent(Folder parent) {
		this.parent = parent;
	}


	public void addFile(File file) {
		this.files.add(file);
	}


	public void removeFile(File file) {
		this.files.remove(file);
	}


}
