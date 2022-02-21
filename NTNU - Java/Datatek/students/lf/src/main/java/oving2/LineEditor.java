package oving2;

public class LineEditor {

	private String text = "";
	private int insertionIndex = 0;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		this.insertionIndex = text.length();
	}

	public int getInsertionIndex() {
		return insertionIndex;
	}

	public void setInsertionIndex(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("The insertion index cannot be negative");
		} else if (index > text.length()) {
			throw new IllegalArgumentException("The insertion index cannot be larger than the length of the text");
		}

		this.insertionIndex = index;
	}

	public void left() {
		if (insertionIndex > 0) {
			insertionIndex = insertionIndex - 1;
		}
	}

	public void right() {
		if (insertionIndex < text.length()) {
			insertionIndex = insertionIndex + 1;
		}
	}

	public void insertString(String s) {
		text = text.substring(0, insertionIndex) + s + text.substring(insertionIndex);
		insertionIndex = insertionIndex + s.length();
	}

	public void deleteLeft() {
		if (insertionIndex > 0) {
			text = text.substring(0, insertionIndex - 1) + text.substring(insertionIndex);
			insertionIndex = insertionIndex - 1;
		}
	}

	public void deleteRight() {
		if (insertionIndex < text.length()) {
			text = text.substring(0, insertionIndex) + text.substring(insertionIndex + 1);
		}
	}

	@Override
	public String toString() {
		return String.format("%s|%s", text.substring(0, insertionIndex), text.substring(insertionIndex));
	}
}
