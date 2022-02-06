package stateandbehavior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    /**
     * Compares all values in a given {@link Rectangle} to a set of expected values.
     *
     * @param rect   The rectangle to check
     * @param minX   The expected minimum x value of rect
     * @param minY   The expected minimum y value of rect
     * @param maxX   The expected maximum x value of rect
     * @param maxY   The expected maximum y value of rect
     * @param width  The expected width of rect
     * @param height The expected height of rect
     */
    static void assertValues(Rectangle rect, int minX, int minY, int maxX, int maxY, int width, int height,
                              String suffix) {
        Assertions.assertEquals(minX, rect.getMinX(), "Wrong minX " + suffix);
        Assertions.assertEquals(minY, rect.getMinY(), "Wrong minY " + suffix);
        Assertions.assertEquals(maxX, rect.getMaxX(), "Wrong maxX " + suffix);
        Assertions.assertEquals(maxY, rect.getMaxY(), "Wrong maxY " + suffix);
        Assertions.assertEquals(width, rect.getWidth(), "Wrong width " + suffix);
        Assertions.assertEquals(height, rect.getHeight(), "Wrong height " + suffix);
    }

    /**
     * Check that a rectangle is empty
     *
     * @param rect The rectangle to check
     */
    static void assertEmpty(Rectangle rect) {
        Assertions.assertTrue(rect.isEmpty(), "Expected rectangle to be empty!");
        Assertions.assertFalse(rect.contains(0, 0), "Empty rectangle should not contain (0, 0)! Have you checked if " +
                "the Rectangle is empty in your #contains method?");
        Assertions.assertTrue(rect.getWidth() == 0 || rect.getHeight() == 0, "Empty rectangle should either have a " +
                "width or height of 0!");
    }

    @Test
    @DisplayName("Empty rectangle")
    public void testEmpty() {
        // Test creating empty rectangle
        Rectangle rect1 = new Rectangle(0, 0, 0, 0);
        assertEmpty(rect1);

        // Test creating empty rectangle with only 0 height
        Rectangle rect2 = new Rectangle(3, 2, 1, 2);
        assertEmpty(rect2);

        // Test creating empty rectangle with only 0 width
        Rectangle rect3 = new Rectangle(3, 1, 3, 2);
        assertEmpty(rect3);
    }

    @Test
    @DisplayName("Rectangle constructor")
    public void testConstructor() {
        // Simple test
        Rectangle rect1 = new Rectangle(0, 0, 1, 2);
        assertValues(rect1, 0, 0, 1, 2, 1, 2, "when testing constructor");

        // Test providing points in opposite order
        Rectangle rect2 = new Rectangle(1, 2, 0, 0);
        assertValues(rect2, 0, 0, 1, 2, 1, 2, "when testing constructor");

        // Test negative values
        Rectangle rect3 = new Rectangle(3, 3, -1, 5);
        assertValues(rect3, -1, 3, 3, 5, 4, 2, "when testing constructor");
    }

    private void testAdd(Rectangle rect, int x, int y, boolean expected) {
        Assertions.assertEquals(expected, rect.add(x, y), "Wrong value returned when adding (" + x + ", " + y + ") to" +
                " " + rect);
        Assertions.assertFalse(rect.isEmpty(), "Rectangle should not be empty after adding a point!");
        Assertions.assertTrue(rect.contains(x, y), "Rectangle should contain the point that has been just added!");
    }

    @Test
    @DisplayName("Adding point to rectangle")
    public void testAddXY() {
        int x1 = 13, y1 = -27;
        int x2 = -11, y2 = 23;
        int x3 = 15, y3 = 33;

        Rectangle rect = new Rectangle(x1, y1, x2, y2);

        // Add (x3, y3) and check that rect is updated accordingly.
        this.testAdd(rect, x3, y3, true);

        int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
        int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
        int minX1X2X3 = Math.min(minX1X2, x3), minY1Y2Y3 = Math.min(minY1Y2, y3);
        int maxX1X2X3 = Math.max(maxX1X2, x3), maxY1Y2Y3 = Math.max(maxY1Y2, y3);

        assertValues(rect, minX1X2X3, minY1Y2Y3, maxX1X2X3, maxY1Y2Y3, maxX1X2X3 - minX1X2X3,
                maxY1Y2Y3 - minY1Y2Y3, "when adding point that is not in rectangle");
    }

    @Test
    @DisplayName("Adding point already in rectangle")
    public void testAddSameXY() {
        int x1 = 13, y1 = -27;
        int x2 = -11, y2 = 23;
        int x3 = 15, y3 = 33;

        int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
        int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
        int minX1X2X3 = Math.min(minX1X2, x3), minY1Y2Y3 = Math.min(minY1Y2, y3);
        int maxX1X2X3 = Math.max(maxX1X2, x3), maxY1Y2Y3 = Math.max(maxY1Y2, y3);

        Rectangle rect = new Rectangle(x1, y1, x2, y2);

        // Add (x3, y3) and check that rect is updated accordingly.
        testAdd(rect, x3, y3, true);
        assertValues(rect, minX1X2X3, minY1Y2Y3, maxX1X2X3, maxY1Y2Y3, maxX1X2X3 - minX1X2X3, maxY1Y2Y3 - minY1Y2Y3,
                "when adding point that is not in rectangle");

        // Add (x3, y3) again and check that all state is the same, with false response
        testAdd(rect, x3, y3, false);
        assertValues(rect, minX1X2X3, minY1Y2Y3, maxX1X2X3, maxY1Y2Y3, maxX1X2X3 - minX1X2X3, maxY1Y2Y3 - minY1Y2Y3,
                "when adding point that is in rectangle");

    }

    @Test
    @DisplayName("Adding other rectangle")
    public void testAddRectangle() {
        // Add a point to this.rect
        int x1 = 13, y1 = -27;
        int x2 = -11, y2 = 23;
        int x3 = 15, y3 = 33;
        int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
        int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
        int minX1X3 = Math.min(x1, x3), minY1Y3 = Math.min(y1, y3);
        int maxX1X3 = Math.max(x1, x3), maxY1Y3 = Math.max(y1, y3);

        int minX1X2X3 = Math.min(minX1X2, x3), minY1Y2Y3 = Math.min(minY1Y2, y3);
        int maxX1X2X3 = Math.max(maxX1X2, x3), maxY1Y2Y3 = Math.max(maxY1Y2, y3);
        int widthX1X2X3 = maxX1X2X3 - minX1X2X3, heightX1X2X3 = maxY1Y2Y3 - minY1Y2Y3;

        // Create a rectangle and fill it with some points. Assert that this rect is correct.
        Rectangle rect = new Rectangle(x1, y1, x2, y2);
        assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2, maxY1Y2 - minY1Y2, "when " +
                "creating new rectangle");

        // Create another rectangle and fill it with some points. Assert that this rect is correct.
        Rectangle rect2 = new Rectangle(x1, y1, x3, y3);
        assertValues(rect2, minX1X3, minY1Y3, maxX1X3, maxY1Y3, maxX1X3 - minX1X3, maxY1Y3 - minY1Y3, "when " +
                "creating new rectangle");

        // Add rect to this.rect, and check correctness
        Assertions.assertTrue(rect.add(rect2));
        assertValues(rect, minX1X2X3, minY1Y2Y3, maxX1X2X3, maxY1Y2Y3, widthX1X2X3, heightX1X2X3, "when adding " +
                "another rectangle");
    }

    @Test
    @DisplayName("Adding rectangle to itself")
    public void testAddSameRectangle() {
        int x1 = 13, y1 = -27;
        int x2 = -11, y2 = 23;
        int width = Math.abs(x1 - x2), height = Math.abs(y1 - y2);
        int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
        int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);

        // Create a rectangle and fill it with some points. Assert that this rect is correct.
        Rectangle rect = new Rectangle(x1, y1, x2, y2);
        assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, width, height, "when creating new rectangle");

        //Add rectangle to itself and check that state stays the same
        Assertions.assertFalse(rect.add(rect), "Expected no change when adding equal rectangle using #add(Rectangle)");
        assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, width, height, "when adding the same rectangle to" +
                " itself");
    }

    @Test
    @DisplayName("Rectangle union")
    public void testUnion() {
        int x1 = 13, y1 = -27;
        int x2 = -11, y2 = 23;
        int x3 = 15, y3 = 33;
        int x4 = 17, y4 = -33;

        int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
        int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
        int minX3X4 = Math.min(x3, x4), minY3Y4 = Math.min(y3, y4);
        int maxX3X4 = Math.max(x3, x4), maxY3Y4 = Math.max(y3, y4);

        // Create two rectangles and check correctness
        Rectangle rect1 = new Rectangle(x1, y1, x2, y2);
        assertValues(rect1, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2, maxY1Y2 - minY1Y2, "when " +
                "creating new rectangle");

        Rectangle rect2 = new Rectangle(x3, y3, x4, y4);
        assertValues(rect2, minX3X4, minY3Y4, maxX3X4, maxY3Y4, maxX3X4 - minX3X4, maxY3Y4 - minY3Y4, "when " +
                "creating new rectangle");

        // Take the union (both ways), and check that both are the same
        int minX = Math.min(minX1X2, minX3X4), minY = Math.min(minY1Y2, minY3Y4);
        int maxX = Math.max(maxX1X2, maxX3X4), maxY = Math.max(maxY1Y2, maxY3Y4);

        Rectangle union1 = rect1.union(rect2);
        assertValues(union1, minX, minY, maxX, maxY, maxX - minX, maxY - minY, "when calling #union with another" +
                " rectangle");
        assertValues(rect1, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2, maxY1Y2 - minY1Y2, "Values " +
                "changed when calling #union with another rectangle! Make sure to not create a new Rectangle and not " +
                "modify the current ones!");
        assertValues(rect2, minX3X4, minY3Y4, maxX3X4, maxY3Y4, maxX3X4 - minX3X4, maxY3Y4 - minY3Y4, "Values " +
                "changed when calling #union with another rectangle! Make sure to not create a new Rectangle and not " +
                "modify the current ones!");

        Rectangle union2 = rect2.union(rect1);
        assertValues(union2, minX, minY, maxX, maxY, maxX - minX, maxY - minY, "when calling #union with another" +
                " rectangle");
        assertValues(rect1, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2, maxY1Y2 - minY1Y2, "Values " +
                "changed when calling #union with another rectangle! Make sure to not create a new Rectangle and not " +
                "modify the current ones!");
        assertValues(rect2, minX3X4, minY3Y4, maxX3X4, maxY3Y4, maxX3X4 - minX3X4, maxY3Y4 - minY3Y4, "Values " +
                "changed when calling #union with another rectangle! Make sure to not create a new Rectangle and not " +
                "modify the current ones!");
    }
}
