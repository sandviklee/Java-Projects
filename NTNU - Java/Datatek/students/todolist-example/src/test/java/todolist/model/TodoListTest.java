package todolist.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TodoListTest {
	@Test
	public void testSetGetName() {
		TodoList tl = new TodoList();
		for (String name : new String[] {"name1", "2name", "#MANY_NaMEs"}) {
			tl.setName(name);
			assertEquals(name, tl.getName(), "Name was not set correctly.");
		}
	}
	
	private void assertListContainsEntries(List<String> entries, TodoList tl) {
		List<String> entryCopies = new ArrayList<>(entries);
		for (TodoEntry entry : tl) {
			assertTrue(entryCopies.remove(entry.getText()), "TodoList contains extra entry: " + entry.getText());
		}
		assertEquals(0, entryCopies.size(), "TodoList misses some elements: " + entryCopies.toString());
	}
	private void assertListContainsEntries(String[] entries, TodoList tl) {
		assertListContainsEntries(Arrays.asList(entries), tl);
	}
	
	@Test
	public void testAddEntry() {
		TodoList tl = new TodoList();
		assertListContainsEntries(new String[] {}, tl);
		String e1 = "e1";
		String e2 = "E2";
		String e3 = "e3E4M";
		tl.addEntry(new TodoEntry(e1));
		assertListContainsEntries(List.of(e1), tl);
		tl.addEntry(new TodoEntry(e1));
		assertListContainsEntries(List.of(e1, e1), tl);
		tl.addEntry(new TodoEntry(e2));
		assertListContainsEntries(List.of(e1, e1, e2), tl);
		tl.addEntry(new TodoEntry(e3));
		assertListContainsEntries(List.of(e1, e1, e2, e3), tl);
		
		var alreadyAdded = tl.iterator().next();
		tl.addEntry(alreadyAdded);
		assertListContainsEntries(List.of(e1, e1, e2, e3), tl);
	}
	
	@Test
	public void testRemoveEntry() {
		TodoList tl = new TodoList();
		TodoEntry e1 = new TodoEntry("E1");
		TodoEntry e2 = new TodoEntry("E2");
		TodoEntry e3 = new TodoEntry("E3");
		tl.addEntry(e1);
		tl.addEntry(e2);
		tl.addEntry(e3);
		
		assertListContainsEntries(List.of(e1.getText(), e2.getText(), e3.getText()), tl);
		
		tl.removeEntry(e1);
		assertListContainsEntries(List.of(e2.getText(), e3.getText()), tl);
	}
	
	@Test
	public void testFindEntry() {
		TodoList tl = new TodoList();

		TodoEntry e1 = new TodoEntry("E1");
		TodoEntry e2 = new TodoEntry("E2");
		TodoEntry e3 = new TodoEntry("E3");
		tl.addEntry(e1);
		tl.addEntry(e2);
		tl.addEntry(e3);
		
		assertEquals(e1, tl.findEntry(e1.getText()));
		assertEquals(e2, tl.findEntry(e2.getText()));
		assertEquals(e3, tl.findEntry(e3.getText()));
		
		assertNull(tl.findEntry("NotThere"));
		assertNull(tl.findEntry("e1"));
	}
	
	@Test
	public void testHasEntry() {
		TodoList tl = new TodoList();

		TodoEntry e1 = new TodoEntry("E1");
		TodoEntry e2 = new TodoEntry("E2");
		TodoEntry e3 = new TodoEntry("E3");
		tl.addEntry(e1);
		tl.addEntry(e2);
		tl.addEntry(e3);
		
		assertTrue(tl.hasEntry(e1.getText()));
		assertTrue(tl.hasEntry(e2.getText()));
		assertTrue(tl.hasEntry(e3.getText()));
		
		assertFalse(tl.hasEntry("NotThere"));
		assertFalse(tl.hasEntry("e1"));
	}
}
