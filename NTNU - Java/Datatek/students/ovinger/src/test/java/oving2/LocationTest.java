package oving2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocationTest {

	private Location loc;

	/**
	 * Check that the position of {@link #loc} is equal to the parameters.
	 * 
	 * @param x Expected x position
	 * @param y Expected y position
	 */
	private void checkPos(int x, int y) {
		Assertions.assertEquals(x, loc.getX(), "Wrong x coordinate");
		Assertions.assertEquals(y, loc.getY(), "Wrong y coordinate");
	}

	@BeforeEach
	public void beforeEach() {
		loc = new Location();
	}

	@Test
	@DisplayName("Private fields")
	public void testPrivateFields() {
		TestHelper.checkIfFieldsPrivate(Location.class);
	}

	@Test
	@DisplayName("Constructor")
	public void testConstructor() {
		checkPos(0, 0);
	}

	@Test
	@DisplayName("Move up")
	public void testUp() {
		loc.up();
		checkPos(0, -1);
		loc.up();
		checkPos(0, -2);
	}

	@Test
	@DisplayName("Move down")
	public void testDown() {
		loc.down();
		checkPos(0, 1);
		loc.down();
		checkPos(0, 2);
	}

	@Test
	@DisplayName("Move left")
	public void testLeft() {
		loc.left();
		checkPos(-1, 0);
		loc.left();
		checkPos(-2, 0);
	}

	@Test
	@DisplayName("Move right")
	public void testRight() {
		loc.right();
		checkPos(1, 0);
		loc.right();
		checkPos(2, 0);
	}

	@Test
	@DisplayName("Move multiple directions")
	public void testComplexMovement() {
		loc.right();
		checkPos(1, 0);
		loc.down();
		checkPos(1, 1);
		loc.right();
		checkPos(2, 1);
		loc.down();
		checkPos(2, 2);
		loc.left();
		checkPos(1, 2);
		loc.up();
		checkPos(1, 1);
		loc.up();
		checkPos(1, 0);
		loc.left();
		checkPos(0, 0);
	}
}