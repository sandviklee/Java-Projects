package todolist.model;

/**
 * Class representing a single entry in a TODO-list.
 * 
 * The class contains a text-value representing the label of the entry, 
 * and has a getText-method to retrieve said label.
 *
 */
public class TodoEntry {
    
    private final String text;
    
    /**
     * Create a new entry with a given label.
     * 
     * @param text The label to assign to this entry
     */
    public TodoEntry(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("[TodoEntry \"%s\"]", getText());
    }

    public String getText() {
        return text;
    }
}