package todolist.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A TodoList, which is an iterable of {@link TodoEntry}s.
 * 
 * The class has a name, along with methods for adding and removing entries,
 * searching through them, and checking if one exists in the list.
 *
 */
public class TodoList implements Iterable<TodoEntry> {

    private String name;

    private List<TodoEntry> entries = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("[TodoList \"%s\" with %s entries]", getName(), entries.size());
    }

    @Override
    public Iterator<TodoEntry> iterator() {
        return entries.iterator();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Find an entry given its text label.
     * 
     * @param text The label to look for.
     * @return An entry with the given text label if it exists, otherwise null.
     */
    public TodoEntry findEntry(String text) {
        for (var entry : entries) {
            if (entry.getText().equals(text)) {
                return entry;
            }
        }
        return null;
    }
    
    /**
     * Check if this TodoList has an entry with a given text label.
     * 
     * @param text The text label of the entry
     * @return true if an entry with the given text label is in this TodoList, otherwise false
     */
    public boolean hasEntry(String text) {
        return findEntry(text) != null;
    }
    
    /**
     * Add an entry to this TodoList.
     * 
     * @param entry The entry to add.
     */
    public void addEntry(TodoEntry entry) {
        if (! entries.contains(entry)) {
            entries.add(entry);
        }
    }

    /**
     * Remove and entry from this TodoList.
     * 
     * @param entry The entry to remove.
     */
    public void removeEntry(TodoEntry entry) {
        entries.remove(entry);
    }
}