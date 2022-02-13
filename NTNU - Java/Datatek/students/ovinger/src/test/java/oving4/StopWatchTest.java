package oving4;

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
	@DisplayName("Sjekk at et nyopprettet StopWatch-objekt har korrekte verdier")
	public void testConstructor() {
		Assertions.assertFalse(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());
		Assertions.assertEquals(0, stopWatch.getTicks());
		Assertions.assertEquals(-1, stopWatch.getTime());
		Assertions.assertEquals(-1, stopWatch.getLapTime());
		Assertions.assertEquals(-1, stopWatch.getLastLapTime());
	}

	@Test
	@DisplayName("Sjekk at tick() uten start ikke endrer tiden")
	public void testTicksWithoutStart() {
		stopWatch.tick(1);
		Assertions.assertEquals(-1, stopWatch.getTime());
		Assertions.assertEquals(1, stopWatch.getTicks());
		stopWatch.tick(4);
		Assertions.assertEquals(-1, stopWatch.getTime());
		Assertions.assertEquals(5, stopWatch.getTicks());
	}

	@Test
	@DisplayName("Start og stopp klokken og sjekk at tiden er riktig")
	public void testStartTickStop() {
		stopWatch.start();
		Assertions.assertEquals(0, stopWatch.getTime());
		Assertions.assertEquals(0, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());

		Assertions.assertThrows(IllegalStateException.class, () -> {
			stopWatch.start();
		}, "Cannot start already running stopwatch");

		stopWatch.tick(3);
		Assertions.assertEquals(3, stopWatch.getTime());
		Assertions.assertEquals(3, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());

		stopWatch.tick(5);
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(8, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());

		stopWatch.stop();
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(8, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertTrue(stopWatch.isStopped());

		Assertions.assertThrows(IllegalStateException.class, () -> {
			stopWatch.stop();
		}, "Skal ikke kunne stoppe en klokke som allerede er stoppet");
	}

	@Test
	@DisplayName("Start og stopp klokken, og kall tick() mens den ikke er startet")
	public void testTickStartTickStopTick() {
		stopWatch.tick(2);
		Assertions.assertEquals(-1, stopWatch.getTime());
		Assertions.assertEquals(2, stopWatch.getTicks());
		Assertions.assertFalse(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());

		stopWatch.start();
		Assertions.assertEquals(0, stopWatch.getTime());
		Assertions.assertEquals(2, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());

		stopWatch.tick(3);
		Assertions.assertEquals(3, stopWatch.getTime());
		Assertions.assertEquals(5, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());

		stopWatch.tick(5);
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(10, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());

		stopWatch.stop();
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(10, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertTrue(stopWatch.isStopped());

		stopWatch.tick(3);
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(13, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertTrue(stopWatch.isStopped());

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			stopWatch.tick(-1);
		}, "Tiden skal ikke kunne gå bakover");
	}

	@Test
	@DisplayName("Sjekk at laps funker som forventet")
	public void testLaps() {
		Assertions.assertThrows(IllegalStateException.class, () -> {
			stopWatch.lap();
		}, "Skal ikke kunne starte en ny runde uten å starte klokken");
		stopWatch.start();
		Assertions.assertEquals(0, stopWatch.getTime());
		Assertions.assertEquals(0, stopWatch.getLapTime());
		Assertions.assertEquals(-1, stopWatch.getLastLapTime());

		stopWatch.tick(3);
		Assertions.assertEquals(3, stopWatch.getTime());
		Assertions.assertEquals(3, stopWatch.getLapTime());
		Assertions.assertEquals(-1, stopWatch.getLastLapTime());

		stopWatch.lap();
		Assertions.assertEquals(3, stopWatch.getTime());
		Assertions.assertEquals(0, stopWatch.getLapTime());
		Assertions.assertEquals(3, stopWatch.getLastLapTime());

		stopWatch.tick(5);
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(5, stopWatch.getLapTime());
		Assertions.assertEquals(3, stopWatch.getLastLapTime());

		stopWatch.stop();
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(0, stopWatch.getLapTime());
		Assertions.assertEquals(5, stopWatch.getLastLapTime());
		Assertions.assertThrows(IllegalStateException.class, () -> {
			stopWatch.lap();
		}, "Skal ikke kunne starte en ny runde med en stoppet klokke");
	}

}
