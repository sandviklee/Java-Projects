package oving2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineEditorTest {

	private LineEditor lineEditor;

	@BeforeEach
	public void setup() {
		lineEditor = new LineEditor();
	}

	@Test
	@DisplayName("Private fields")
	public void testPrivateFields() {
		TestHelper.checkIfFieldsPrivate(LineEditor.class);
	}

	@Test
	public void testConstructor() {
		Assertions.assertEquals("", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());
	}

	@Test
	public void testGetSetText() {
		lineEditor.setText("ABC");
		Assertions.assertEquals("ABC", lineEditor.getText());
		Assertions.assertEquals(3, lineEditor.getInsertionIndex());

		lineEditor.setText("");
		Assertions.assertEquals("", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());
	}

	@Test
	public void testGetSetInsertionIndex() {
		lineEditor.setText("ABC");
		Assertions.assertEquals("ABC", lineEditor.getText());
		Assertions.assertEquals(3, lineEditor.getInsertionIndex());

		lineEditor.setInsertionIndex(0);
		Assertions.assertEquals("ABC", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.setInsertionIndex(3);
		Assertions.assertEquals("ABC", lineEditor.getText());
		Assertions.assertEquals(3, lineEditor.getInsertionIndex());

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			lineEditor.setInsertionIndex(-1);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			lineEditor.setInsertionIndex(4);
		});
	}

	@Test
	public void testLeft() {
		lineEditor.setText("Ja");
		lineEditor.setInsertionIndex(2);
		lineEditor.left();
		Assertions.assertEquals("Ja", lineEditor.getText());
		Assertions.assertEquals(1, lineEditor.getInsertionIndex());
		lineEditor.left();
		Assertions.assertEquals("Ja", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());
		lineEditor.left();
		Assertions.assertEquals("Ja", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());
	}

	@Test
	public void testRight() {
		lineEditor.setText("Ja");
		lineEditor.setInsertionIndex(0);
		lineEditor.right();
		Assertions.assertEquals("Ja", lineEditor.getText());
		Assertions.assertEquals(1, lineEditor.getInsertionIndex());
		lineEditor.right();
		lineEditor.setText("Ja");
		Assertions.assertEquals(2, lineEditor.getInsertionIndex());
		lineEditor.right();
		lineEditor.setText("Ja");
		Assertions.assertEquals(2, lineEditor.getInsertionIndex());
	}

	@Test
	public void testDeleteLeft() {
		lineEditor.setText("Ja");
		lineEditor.setInsertionIndex(0);
		lineEditor.deleteLeft();
		Assertions.assertEquals("Ja", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.setInsertionIndex(1);
		lineEditor.deleteLeft();
		Assertions.assertEquals("a", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.deleteLeft();
		Assertions.assertEquals("a", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.setText("Ja");
		lineEditor.setInsertionIndex(2);
		lineEditor.deleteLeft();
		Assertions.assertEquals("J", lineEditor.getText());
		Assertions.assertEquals(1, lineEditor.getInsertionIndex());

		lineEditor.deleteLeft();
		Assertions.assertEquals("", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.deleteLeft();
		Assertions.assertEquals("", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());
	}

	@Test
	public void testDeleteRight() {
		lineEditor.setText("Ja");
		lineEditor.setInsertionIndex(2);
		lineEditor.deleteRight();
		Assertions.assertEquals("Ja", lineEditor.getText());
		Assertions.assertEquals(2, lineEditor.getInsertionIndex());

		lineEditor.setInsertionIndex(1);
		lineEditor.deleteRight();
		Assertions.assertEquals("J", lineEditor.getText());
		Assertions.assertEquals(1, lineEditor.getInsertionIndex());

		lineEditor.deleteRight();
		Assertions.assertEquals("J", lineEditor.getText());
		Assertions.assertEquals(1, lineEditor.getInsertionIndex());

		lineEditor.setText("Ja");
		lineEditor.setInsertionIndex(0);
		lineEditor.deleteRight();
		Assertions.assertEquals("a", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.deleteRight();
		Assertions.assertEquals("", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.deleteRight();
		Assertions.assertEquals("", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());
	}

	@Test
	public void testInsertString() {
		lineEditor.insertString("");
		Assertions.assertEquals("", lineEditor.getText());
		Assertions.assertEquals(0, lineEditor.getInsertionIndex());

		lineEditor.insertString("Java");
		Assertions.assertEquals("Java", lineEditor.getText());
		Assertions.assertEquals(4, lineEditor.getInsertionIndex());

		lineEditor.insertString(" er gøy!");
		Assertions.assertEquals("Java er gøy!", lineEditor.getText());
		Assertions.assertEquals(12, lineEditor.getInsertionIndex());

		lineEditor.setText("Javagøy!");
		lineEditor.setInsertionIndex(4);
		lineEditor.insertString(" er ");
		Assertions.assertEquals("Java er gøy!", lineEditor.getText());
		Assertions.assertEquals(8, lineEditor.getInsertionIndex());

		lineEditor.setText("er gøy!");
		lineEditor.setInsertionIndex(0);
		lineEditor.insertString("Java ");
		Assertions.assertEquals("Java er gøy!", lineEditor.getText());
		Assertions.assertEquals(5, lineEditor.getInsertionIndex());
	}

}