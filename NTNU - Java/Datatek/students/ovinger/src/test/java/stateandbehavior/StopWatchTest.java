package stateandbehavior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StopWatchTest {
	private StopWatch stopWatch;

	@BeforeEach
	public void beforeEach() {
		stopWatch = new StopWatch();
	}

	@Test
	@DisplayName("Constructor")
	public void testConstructor() {
		Assertions.assertFalse(stopWatch.isStarted(), "Stopwatch should not be started");
		Assertions.assertFalse(stopWatch.isStopped(), "Stopwatch should not be stopped");
		Assertions.assertEquals(0, stopWatch.getTicks(), "Wrong ticks returned");
		Assertions.assertEquals(-1, stopWatch.getTime(), "Time should be -1 when not started");
		Assertions.assertEquals(-1, stopWatch.getLapTime(), "Lap time should be -1 when not started");
		Assertions.assertEquals(-1, stopWatch.getLastLapTime(), "Last lap time should be -1 when not started");
	}

	@Test
	@DisplayName("Tick without starting")
	public void testTicksWithoutStart() {
		stopWatch.tick(1);
		Assertions.assertEquals(-1, stopWatch.getTime(), "Time should be -1 when not started");
		Assertions.assertEquals(1, stopWatch.getTicks(), "Ticks should be 1 after calling #tick(1)");
		stopWatch.tick(4);
		Assertions.assertEquals(-1, stopWatch.getTime(), "Time should be -1 when not started");
		Assertions.assertEquals(5, stopWatch.getTicks(), "Ticks should be 5 after calling #tick(4)");
	}

	@Test
	@DisplayName("Tick, start and stop 1")
	public void testStartTickStop() {
		stopWatch.start();
		Assertions.assertEquals(0, stopWatch.getTime(), "Time should be 0 when just started");
		Assertions.assertEquals(0, stopWatch.getTicks(), "Ticks should be 0 when #tick() has not been called");
		Assertions.assertTrue(stopWatch.isStarted(), "Should be started after calling #start()");
		Assertions.assertFalse(stopWatch.isStopped(), "Should not be stopped before calling #stop()");

		stopWatch.tick(3);
		Assertions.assertEquals(3, stopWatch.getTime(), "Time should be 3 when started and #tick(3) has been called");
		Assertions.assertEquals(3, stopWatch.getTicks(), "Ticks should be 3 when #tick(3) has been called");
		Assertions.assertTrue(stopWatch.isStarted(), "Should be started after calling #start()");
		Assertions.assertFalse(stopWatch.isStopped(), "Should not be stopped before calling #stop()");

		stopWatch.tick(5);
		Assertions.assertEquals(8, stopWatch.getTime(), "Time should be 8 when started and #tick(5) has been called");
		Assertions.assertEquals(8, stopWatch.getTicks(), "Ticks should be 8 when #tick(5) has been called");
		Assertions.assertTrue(stopWatch.isStarted(), "Should be started after calling #start()");
		Assertions.assertFalse(stopWatch.isStopped(), "Should not be stopped before calling #stop()");

		stopWatch.stop();
		Assertions.assertEquals(8, stopWatch.getTime(), "Time should be 8 after #stop() has been called");
		Assertions.assertEquals(8, stopWatch.getTicks(), "Ticks should be 8 after #stop() has been called");
		Assertions.assertTrue(stopWatch.isStarted(), "Should be started even after #stop() has been called");
		Assertions.assertTrue(stopWatch.isStopped(), "Should be stopped after calling #stop()");
	}

	@Test
	@DisplayName("Tick, start and stop 2")
	public void testTickStartTickStopTick() {
		stopWatch.tick(2);
		Assertions.assertEquals(-1, stopWatch.getTime(), "Time should be -1 when not started");
		Assertions.assertEquals(2, stopWatch.getTicks(), "Ticks should be 2 when #tick(2) has been called");
		Assertions.assertFalse(stopWatch.isStarted(), "Stopwatch should not be started");
		Assertions.assertFalse(stopWatch.isStopped(), "Stopwatch should not be stopped");

		stopWatch.start();
		Assertions.assertEquals(0, stopWatch.getTime(), "Time should be 0 when just started");
		Assertions.assertEquals(2, stopWatch.getTicks(), "Ticks should be 2 after #start() has been called");
		Assertions.assertTrue(stopWatch.isStarted(), "Should be started after calling #start()");
		Assertions.assertFalse(stopWatch.isStopped(), "Should not be stopped before calling #stop()");

		stopWatch.tick(3);
		Assertions.assertEquals(3, stopWatch.getTime(), "Time should be 3 when started and #tick(3) has been called");
		Assertions.assertEquals(5, stopWatch.getTicks(), "Ticks should be 5 when #tick(3) has been called");
		Assertions.assertTrue(stopWatch.isStarted(), "Should be started after calling #tick(3)");
		Assertions.assertFalse(stopWatch.isStopped(), "Should not be stopped before calling #tick(3)");

		stopWatch.tick(5);
		Assertions.assertEquals(8, stopWatch.getTime(), "Time should be 8 when started and #tick(5) has been called");
		Assertions.assertEquals(10, stopWatch.getTicks(), "Ticks should be 10 when #tick(5) has been called");
		Assertions.assertTrue(stopWatch.isStarted(), "Should be started after calling #tick(5)");
		Assertions.assertFalse(stopWatch.isStopped(), "Should not be stopped before calling #tick(5)");

		stopWatch.stop();
		Assertions.assertEquals(8, stopWatch.getTime(), "Time should be 8 after #stop() has been called");
		Assertions.assertEquals(10, stopWatch.getTicks(), "Ticks should be 10 after #stop() has been called");
		Assertions.assertTrue(stopWatch.isStarted(), "Should be started even after #stop() has been called");
		Assertions.assertTrue(stopWatch.isStopped(), "Should be stopped after calling #stop()");

		stopWatch.tick(3);
		Assertions.assertEquals(8, stopWatch.getTime(),
				"Time should be 8 after #tick(3) has been called while stopped");
		Assertions.assertEquals(13, stopWatch.getTicks(),
				"Ticks should be 13 when #tick(3) has been called while stopped");
		Assertions.assertTrue(stopWatch.isStarted(),
				"Should be started even after #tick() has been called while stopped");
		Assertions.assertTrue(stopWatch.isStopped(), "Should be stopped after calling #tick() while stopped");
	}

	@Test
	@DisplayName("Lap times")
	public void testLaps() {
		stopWatch.start();
		Assertions.assertEquals(0, stopWatch.getTime(), "Time should be 0 when just started");
		Assertions.assertEquals(0, stopWatch.getLapTime(), "Lap time should be 0 when just started");
		Assertions.assertEquals(-1, stopWatch.getLastLapTime(),
				"Last lap time should be -1 when there is no previous lap");

		stopWatch.tick(3);
		Assertions.assertEquals(3, stopWatch.getTime(), "Time should be 3 after #tick(3) has been called");
		Assertions.assertEquals(3, stopWatch.getLapTime(), "Lap time should be 3 after calling #tick(3) while started");
		Assertions.assertEquals(-1, stopWatch.getLastLapTime(),
				"Last lap time should be -1 when there is no previous lap");

		stopWatch.lap();
		Assertions.assertEquals(3, stopWatch.getTime(), "Time should still be 3 after starting a new lap");
		Assertions.assertEquals(0, stopWatch.getLapTime(), "Current lap time should be 0 when just started");
		Assertions.assertEquals(3, stopWatch.getLastLapTime(),
				"Last lap time should be 3 when we just started a new lap");

		stopWatch.tick(5);
		Assertions.assertEquals(8, stopWatch.getTime(), "Time should be 8 after #tick(5) has been called");
		Assertions.assertEquals(5, stopWatch.getLapTime(), "Current lap time should be 5 after calling #tick(5)");
		Assertions.assertEquals(3, stopWatch.getLastLapTime(), "Last lap time should be 3 even after time passes");

		stopWatch.stop();
		Assertions.assertEquals(8, stopWatch.getTime(), "Time should be 8 after stopping");
		Assertions.assertEquals(0, stopWatch.getLapTime(), "Current lap time should be 0 when stopped");
		Assertions.assertEquals(5, stopWatch.getLastLapTime(),
				"Last lap should be the lap time of the current lap when stopping");
	}
}