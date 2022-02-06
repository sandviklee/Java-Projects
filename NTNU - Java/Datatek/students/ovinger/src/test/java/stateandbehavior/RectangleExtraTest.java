package stateandbehavior;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static stateandbehavior.RectangleTest.assertValues;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RectangleExtraTest {
    
    @Test
    @DisplayName("Intersecting rectangles")
    void testIntersection() {
        Rectangle rect1 = new Rectangle(0, 0, 5, 5);
        Rectangle rect2 = new Rectangle(3, 3, 7, 7);

        Rectangle intersection = rect1.intersection(rect2);
        assertValues(intersection, 3, 3, 5, 5, 2, 2, " for intersecting rectangle");

        assertTrue(rect1.intersects(rect2), "Wrong value from #intersects(Rectangle)");
    }

    @Test
    @DisplayName("Non-intersecting rectangles")
    void testNonIntersection() {
        Rectangle rect1 = new Rectangle(-3, -3, 0, 0);
        Rectangle rect2 = new Rectangle(3, 3, 7, 7);

        Rectangle intersection = rect1.intersection(rect2);
        assertNull(intersection, "Intersection of two non-intersecting rectangles should be null");
        assertFalse(rect1.intersects(rect2), "Wrong value from #intersects(Rectangle)");
    }
}
