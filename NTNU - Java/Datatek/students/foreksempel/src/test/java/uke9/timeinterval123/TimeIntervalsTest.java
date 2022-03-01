package uke9.timeinterval123;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uke9.timeinterval123.TimeInterval1;
import uke9.timeinterval123.TimeInterval2;
import uke9.timeinterval123.TimeInterval3;

public class TimeIntervalsTest {

	TimeInterval1 ti1;
	TimeInterval2 ti2;
	TimeInterval3 ti3;

	@BeforeEach
	public void setUp() throws Exception {
		ti1 = new TimeInterval1(14, 15, 16, 00);
		ti2 = new TimeInterval2(14, 15, 16, 00);
		ti3 = new TimeInterval3(14, 15, 16, 00);
	}

	
	@Test
	public void testCorrectTimeInterval() {
		assertEquals("14:15-16:00", ti1.toString());
		assertEquals("14:15-16:00", ti2.toString());
		assertEquals("14:15-16:00", ti3.toString());
	}

	@Test
	public void testCorrectDuration() {
		assertEquals(105, ti1.getDuration());
		assertEquals(105, ti2.getDuration());
		assertEquals(105, ti3.getDuration());
	}

    @Test
    public void testFailsWhenAfterisBeforeBefore1() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
        () -> new TimeInterval1(14, 15, 14, 00));
    }
	
	@Test 
	public void testFailsWhenAfterisBeforeBefore2() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
		new TimeInterval2(14, 15, 14, 00));
	}

	@Test 
	public void testFailsWhenAfterisBeforeBefore3() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
		ti3 = new TimeInterval3(14, 15, 14, 00));
	}

}
