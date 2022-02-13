package oving4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class StopWatchManagerTest {

	private StopWatchManager manager;

	@BeforeEach
	public void setup() {
		manager = new StopWatchManager();
	}

	@Test
	@DisplayName("Lage ny stoppeklokke")
	public void testNewStopWatch() {
		StopWatch sw1 = manager.newStopWatch("SW1");
		StopWatch sw2 = manager.newStopWatch("SW2");
		Assertions.assertEquals(sw1, manager.getStopWatch("SW1"));
		Assertions.assertEquals(sw2, manager.getStopWatch("SW2"));
	}

	@Test
	@DisplayName("Ticker")
	public void testTicks() {
		StopWatch sw1 = manager.newStopWatch("SW1");
		StopWatch sw2 = manager.newStopWatch("SW2");

		manager.tick(1);
		Assertions.assertEquals(1, sw1.getTicks());
		Assertions.assertEquals(1, sw2.getTicks());

		manager.tick(4);
		Assertions.assertEquals(5, sw1.getTicks());
		Assertions.assertEquals(5, sw2.getTicks());
	}

	@Test
	@DisplayName("Fjerne stoppeklokke")
	public void testRemoveStopWatches() {
		Assertions.assertEquals(0, manager.getAllWatches().size());

		StopWatch sw1 = manager.newStopWatch("SW1");
		Assertions.assertEquals(1, manager.getAllWatches().size());
		Assertions.assertEquals(sw1, manager.getStopWatch("SW1"));

		StopWatch sw2 = manager.newStopWatch("SW2");
		Assertions.assertEquals(2, manager.getAllWatches().size());
		Assertions.assertEquals(sw1, manager.getStopWatch("SW1"));
		Assertions.assertEquals(sw2, manager.getStopWatch("SW2"));

		manager.removeStopWatch("SW1");
		Assertions.assertEquals(1, manager.getAllWatches().size());
		Assertions.assertEquals(null, manager.getStopWatch("SW1"));

		manager.removeStopWatch("SW2");
		Assertions.assertEquals(0, manager.getAllWatches().size());
		Assertions.assertEquals(null, manager.getStopWatch("SW1"));
		Assertions.assertEquals(null, manager.getStopWatch("SW2"));
	}

	@Test
	@DisplayName("Starte og stoppe klokker")
	public void testStartedStoppedWatches() {
		Assertions.assertEquals(0, manager.getStartedWatches().size());

		manager.newStopWatch("SW1").start();
		Assertions.assertEquals(1, manager.getStartedWatches().size());
		Assertions.assertEquals(0, manager.getStoppedWatches().size());
		Assertions.assertTrue(manager.getStartedWatches().contains(manager.getStopWatch("SW1")));
		Assertions.assertTrue(manager.getStopWatch("SW1").isStarted());

		manager.newStopWatch("SW2").start();
		Assertions.assertEquals(2, manager.getStartedWatches().size());
		Assertions.assertEquals(0, manager.getStoppedWatches().size());
		Assertions.assertTrue(manager.getStartedWatches().contains(manager.getStopWatch("SW1")));
		Assertions.assertTrue(manager.getStopWatch("SW1").isStarted());
		Assertions.assertFalse(manager.getStopWatch("SW1").isStopped());
		Assertions.assertTrue(manager.getStartedWatches().contains(manager.getStopWatch("SW2")));
		Assertions.assertTrue(manager.getStopWatch("SW2").isStarted());
		Assertions.assertFalse(manager.getStopWatch("SW2").isStopped());

		manager.getStopWatch("SW2").stop();
		Assertions.assertEquals(1, manager.getStoppedWatches().size());
		Assertions.assertFalse(manager.getStoppedWatches().contains(manager.getStopWatch("SW1")));
		Assertions.assertFalse(manager.getStopWatch("SW1").isStopped());
		Assertions.assertTrue(manager.getStoppedWatches().contains(manager.getStopWatch("SW2")));
		Assertions.assertTrue(manager.getStopWatch("SW2").isStopped());

		manager.getStopWatch("SW1").stop();
		Assertions.assertEquals(2, manager.getStoppedWatches().size());
		Assertions.assertTrue(manager.getStoppedWatches().contains(manager.getStopWatch("SW1")));
		Assertions.assertTrue(manager.getStopWatch("SW1").isStopped());
		Assertions.assertTrue(manager.getStoppedWatches().contains(manager.getStopWatch("SW2")));
		Assertions.assertTrue(manager.getStopWatch("SW2").isStopped());
	}

}
