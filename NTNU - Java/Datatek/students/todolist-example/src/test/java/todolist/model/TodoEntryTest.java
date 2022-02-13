package todolist.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TodoEntryTest {
	
	@Test
	public void testEntryGetsCorrectText() {
		for (var s : new String[]{"T1", "T2", "AbC21"}) {
			var entry = new TodoEntry(s);
			assertEquals(s, entry.getText(), "Entry did not get correct text");
		}
	}
}
