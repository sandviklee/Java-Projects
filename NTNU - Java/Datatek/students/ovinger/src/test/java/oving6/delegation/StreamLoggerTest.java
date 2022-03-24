package oving6.delegation;

import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamLoggerTest {

	private ByteArrayOutputStream stream;
	private StreamLogger logger;
	private static final String formatString = "%s: %s (%s)";
	private static final String melding = "En melding ble logget!";

	@BeforeEach
	public void setup() {
		stream = new ByteArrayOutputStream();
		logger = new StreamLogger(stream);
	}

	@Test
	@DisplayName("Logger infomelding")
	public void testLog() {
		logger.log(ILogger.INFO, melding, null);
		Assertions.assertTrue(stream.toString().contains(melding),
				"Teste at strømmen inneholder melding etter at den har blitt logget");
		Assertions.assertTrue(stream.toString().contains(ILogger.INFO),
				"Teste at strømmen inneholder melding av typen info etter den har blitt logget");
	}

	@Test
	@DisplayName("Logger unntak")
	public void testLogException() {
		IllegalStateException exception = new IllegalStateException();
		logger.setFormatString(formatString);
		logger.log(ILogger.INFO, melding, exception);
		Assertions.assertEquals(String.format(formatString, ILogger.INFO, melding, exception), stream.toString().trim(),
				"Teste formatet på melding som ble logget med exception");
	}
}
