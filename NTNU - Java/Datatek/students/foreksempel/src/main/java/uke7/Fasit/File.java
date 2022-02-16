package uke7.Fasit;

public class File {

	private String name;
	private Folder parent;
	
	public File(String name, Folder parent) {
		super();
		setName(name);
		this.parent = parent;
		parent.addFile(this);
	}
	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Name cannot be null.");
		if (name.length() == 0)
			throw new IllegalArgumentException("Name cannot be of zero length.");
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public Folder getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return parent.toString() + "/" + name;
	}
	public void move(Folder destination) {
		if (destination == null)
			throw new IllegalArgumentException("Can't move file to 'null'");
		parent.removeFile(this);
		this.parent = destination;
		destination.addFile(this);
	}

}
