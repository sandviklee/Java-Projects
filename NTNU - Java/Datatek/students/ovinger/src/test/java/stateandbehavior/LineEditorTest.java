package stateandbehavior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineEditorTest {
	private LineEditor lineEditor;

	private void checkEditorContent(String s) {
		Assertions.assertEquals(s, lineEditor.toString(), "Wrong value returned by toString()");
		int pos = s.indexOf('|');
		Assertions.assertEquals(s.substring(0, pos) + s.substring(pos + 1), lineEditor.getText(),
				"Wrong text value returned");
		Assertions.assertEquals(pos, lineEditor.getInsertionIndex(), "Wrong insertion index");
	}

	@BeforeEach
	public void setup() {
		lineEditor = new LineEditor();
	}

	@Test
	@DisplayName("Constructor")
	public void testContstructor() {
		checkEditorContent("|");
	}

	@Test
	@DisplayName("Setter methods")
	public void testSetters() {
		lineEditor.setText("Hello World!");
		checkEditorContent("|Hello World!");
		lineEditor.setInsertionIndex(5);
		checkEditorContent("Hello| World!");
	}

	@Test
	@DisplayName("Insert string at end")
	public void testInsertStringAtEnd() {
		lineEditor.insertString("");
		checkEditorContent("|");
		lineEditor.insertString("Java");
		checkEditorContent("Java|");
		lineEditor.insertString(" er gøy!");
		checkEditorContent("Java er gøy!|");
	}

	@Test
	@DisplayName("Insert string in the middle")
	public void testInsertStringMiddle() {
		lineEditor.setText("Javagøy!");
		lineEditor.setInsertionIndex(4);
		lineEditor.insertString(" er ");
		checkEditorContent("Java er |gøy!");
	}

	@Test
	@DisplayName("Insert string at the begginning")
	public void testInsertStringAtBeginning() {
		lineEditor.setText("er gøy!");
		lineEditor.setInsertionIndex(0);
		lineEditor.insertString("Java ");
		checkEditorContent("Java |er gøy!");
	}

	@Test
	@DisplayName("Move left")
	public void testLeft() {
		lineEditor.left();
		checkEditorContent("|");
		lineEditor.setText("J");
		lineEditor.setInsertionIndex(1);
		checkEditorContent("J|");
		lineEditor.left();
		checkEditorContent("|J");
	}

	@Test
	@DisplayName("Move right")
	public void testRight() {
		lineEditor.right();
		checkEditorContent("|");
		lineEditor.setText("J");
		lineEditor.setInsertionIndex(0);
		checkEditorContent("|J");
		lineEditor.right();
		checkEditorContent("J|");
	}

	@Test
	@DisplayName("Delete left")
	public void testDeleteLeft() {
		lineEditor.deleteLeft();
		checkEditorContent("|");
		lineEditor.insertString("J");
		lineEditor.deleteLeft();
		checkEditorContent("|");
		lineEditor.insertString("Java");
		lineEditor.setInsertionIndex(2);
		checkEditorContent("Ja|va");
		lineEditor.deleteLeft();
		checkEditorContent("J|va");
	}

	@Test
	@DisplayName("Delete right")
	public void testDeleteRight() {
		lineEditor.deleteRight();
		checkEditorContent("|");
		lineEditor.insertString("J");
		lineEditor.setInsertionIndex(0);
		lineEditor.deleteRight();
		checkEditorContent("|");
		lineEditor.insertString("Java");
		lineEditor.setInsertionIndex(2);
		checkEditorContent("Ja|va");
		lineEditor.deleteRight();
		checkEditorContent("Ja|a");
	}
}