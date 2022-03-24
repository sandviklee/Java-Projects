package oving6.delegation.office;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrinterTest {

	private Printer printer;
	private Clerk clerk1;
	private Clerk clerk2;

	@BeforeEach
	public void setup() {
		printer = new Printer();
		clerk1 = new Clerk(printer);
		clerk2 = new Clerk(printer);
	}

	@Test
	@DisplayName("Kun en printer som printer")
	public void testPrintSingleClerk() {
		Assertions.assertEquals(0, printer.getPrintHistory(clerk1).size(),
				"Teste initialisering av antall utskrifter i printerhistorikken");

		printer.printDocument("dokument1", clerk1);
		Assertions.assertEquals(1, printer.getPrintHistory(clerk1).size(),
				"Teste antall utskrifter i historikken etter 1 utskrift");
		Assertions.assertTrue(printer.getPrintHistory(clerk1).contains("dokument1"),
				"Teste at dokumentet som ble skrevet ut ligger i historikken");

		printer.printDocument("dokument2", clerk1);
		Assertions.assertEquals(2, printer.getPrintHistory(clerk1).size(),
				"Teste antall utskrifter i historikken etter 2 utskrifter");
		Assertions.assertTrue(printer.getPrintHistory(clerk1).contains("dokument2"),
				"Teste at dokument 2 som ble skrevet ut ligger i historikken");
	}

	@Test
	@DisplayName("Flere printere som printer")
	public void testPrintMultipleClerks() {
		Assertions.assertEquals(0, printer.getPrintHistory(clerk1).size(),
				"Teste initialisering av printerhistorikk for arbeider1");
		Assertions.assertEquals(0, printer.getPrintHistory(clerk2).size(),
				"Teste initialisering av printerhistorikk for arbeider2");

		// Printer dokument for Clerk 1
		printer.printDocument("dokument1", clerk1);
		Assertions.assertEquals(1, printer.getPrintHistory(clerk1).size(),
				"Teste antall utskrifter i historikken for arbeider1 etter å ha skrevet ut 1 dokument");
		Assertions.assertTrue(printer.getPrintHistory(clerk1).contains("dokument1"),
				"Teste at historikken til arbeider1 inneholder dokumentet som ble skrevet ut");
		Assertions.assertEquals(0, printer.getPrintHistory(clerk2).size(),
				"Teste antall utskrifter i historikken for arbeider2 etter at arbeider1 har skrevet ut dokument");

		// Printer dokument for Clerk 2
		printer.printDocument("dokument2", clerk2);
		Assertions.assertEquals(1, printer.getPrintHistory(clerk2).size(),
				"Teste antall utskrifter i historikken for arbeider2 etter å ha skrevet ut et dokument");
		Assertions.assertTrue(printer.getPrintHistory(clerk2).contains("dokument2"),
				"Teste at historikken til arbeider2 inneholder dokumentet som ble skrevet ut");
		Assertions.assertEquals(1, printer.getPrintHistory(clerk1).size(),
				"Teste antall utskrifter i historikken for arbeider1 etter at arbeider1 og arbeider2 har skrevet ut 1 dokument hver");
	}

	@Test
	@DisplayName("Endre printer-historikken går ikke")
	public void testPrintHistoryModification() {
		printer.printDocument("dokument1", clerk1);
		printer.printDocument("dokument2", clerk1);
		Assertions.assertEquals(2, printer.getPrintHistory(clerk1).size(),
				"Teste antall utskrifter i historikken etter 2 utskrifter");

		// Fjerner et dokument og sjekker at printer-historikken er uendret
		printer.getPrintHistory(clerk1).remove("dokument1");
		Assertions.assertEquals(2, printer.getPrintHistory(clerk1).size(),
				"Teste antall utskrifter i historikken etter 2 utskrifter og ha prøvd å fjerne 1 av de");
	}
}
