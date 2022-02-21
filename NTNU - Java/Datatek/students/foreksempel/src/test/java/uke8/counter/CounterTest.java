package uke8.counter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CounterTest {

    Counter counter;
    
    @BeforeEach
    public void setUp() {
        counter = new Counter(5);
    }

    @Test
    @DisplayName("rett tilstand i konstruktør")
    public void constructorInitializesCounterCorrectly() {
        assertEquals(0, counter.getCount());
    }

    @Test
    public void countIncreasesCounter() {
        assertEquals(0, counter.getCount(),"Feil!");
        counter.count();
        assertEquals(1, counter.getCount());
        counter.count();
        assertEquals(2, counter.getCount());
    }
    
    @Test
    public void maxNotReachedBeforeCounted() {
        assertFalse(counter.isMax());
    }
    
    @Test
    public void maxNotReachedBeforeCountedEnoughTimes() {
        counter.count();
        counter.count();
        counter.count();
        counter.count();
        assertFalse(counter.isMax());
    }
    
    @Test
    public void maxReachedAfterRightCounts() {
        counter.count();
        counter.count();
        counter.count();
        counter.count();
        counter.count();
        assertTrue(counter.isMax());
    }
    
    @Test
    public void neverCountAboveMax() {
        for (int i = 0; i < 100; i++) {
            counter.count();
        }
        assertEquals(5, counter.getCount());
    }
}
