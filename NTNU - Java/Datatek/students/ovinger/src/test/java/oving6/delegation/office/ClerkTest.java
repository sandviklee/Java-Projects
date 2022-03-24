package oving6.delegation.office;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClerkTest {

	private Printer printer;
	private Clerk clerk;

	@BeforeEach
	public void setup() {
		printer = new Printer();
		clerk = new Clerk(printer);
	}

	@Test
	@DisplayName("Gjøre kalkuleringer")
	public void testDoCalculations() {
		Assertions.assertEquals(0, clerk.getTaskCount(), "Teste initialiseringen av antall oppgaver utført");

		double calc1 = clerk.doCalculations((x, y) -> x + y, 2.0, 3.5);
		Assertions.assertEquals(5.5, calc1, "Teste beregning med addisjon: 2.0 + 3.5");
		Assertions.assertEquals(1, clerk.getTaskCount(), "Teste antall oppgaver etter 1 beregning");

		double calc2 = clerk.doCalculations((x, y) -> x / y, 2.0, 4.0);
		Assertions.assertEquals(0.5, calc2, "Teste beregning med divisjon: 2.0/4.0");
		Assertions.assertEquals(2, clerk.getTaskCount(), "Teste antall oppgaver etter to beregninger");
	}

	@Test
	@DisplayName("Printe dokumenter")
	public void testPrintDocuments() {
		Assertions.assertEquals(0, clerk.getTaskCount(), "Teste initialiseringen av antall oppgaver utført");

		// Printer et dokument
		clerk.printDocument("dokument1");
		Assertions.assertTrue(printer.getPrintHistory(clerk).contains("dokument1"),
				"Teste om dokumentet som ble printet ble lagt til i printerhistorikken");
		Assertions.assertEquals(1, clerk.getTaskCount(), "Teste antall oppgaver etter 1 utskrift");
		Assertions.assertEquals(1, printer.getPrintHistory(clerk).size(),
				"Teste antall utskrifter i historikken etter 1 utskrift");

		// Printer enda et dokument
		clerk.printDocument("dokument2");
		Assertions.assertTrue(printer.getPrintHistory(clerk).contains("dokument2"),
				"Teste om dokument 2 som ble printet ble lagt til i printerhistorikken");
		Assertions.assertEquals(2, clerk.getTaskCount(), "Teste antall oppgaver etter 2 utskrifter");
		Assertions.assertEquals(2, printer.getPrintHistory(clerk).size(),
				"Teste antall utskrifter i historikken etter 2 utskrifter");
	}

	@Test
	@DisplayName("Hente antall oppgaver")
	public void testTaskCount() {
		Assertions.assertEquals(0, clerk.getTaskCount(), "Teste initialiseringen av antall oppgaver utført");

		clerk.printDocument("dokument1");
		Assertions.assertEquals(1, clerk.getTaskCount(), "Teste antall oppgaver etter 1 utskrift");

		clerk.doCalculations((x, y) -> x + y, 2.0, 3.5);
		Assertions.assertEquals(2, clerk.getTaskCount(), "Teste antall oppgaver etter 1 utskrift og 1 beregning");
	}

	@Test
	@DisplayName("Hente antall ressurser")
	public void testResourceCount() {
		Assertions.assertEquals(1, clerk.getResourceCount(), "Teste antall ressurser for en arbeider");
	}
}
