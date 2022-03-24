package oving6.observable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StockTest {

	private Stock stock;
	private double oldPrice, newPrice;

	// Brukes for å sjekke at lyttere funker
	private double oldPriceListener, newPriceListener;

	private void setPriceForListener(double oldPrice, double newPrice) {
		oldPriceListener = oldPrice;
		newPriceListener = newPrice;
	}

	private void setPriceCheckListener(double newPrice, double expectedOldPrice, double expectedNewPrice) {
		// Oppdatere prisen
		this.oldPrice = this.newPrice;
		this.newPrice = newPrice;
		stock.setPrice(newPrice);

		// Sjekke at lytter har mottatt endring
		Assertions.assertEquals(expectedOldPrice, this.oldPriceListener,
				"Teste gammel pris for lytter etter å ha oppdatert pris fra " + oldPrice + " til " + newPrice);
		Assertions.assertEquals(expectedNewPrice, this.newPriceListener,
				"Teste ny pris for lytter etter å ha oppdatert pris fra " + oldPrice + " til " + newPrice);
	}

	@BeforeEach
	public void setup() {
		stock = new Stock("APPL", 110.0);
		oldPrice = 0.0;
		newPrice = 110.0;
		oldPriceListener = 0.0;
		newPriceListener = 0.0;
	}

	@Test
	@DisplayName("Teste kontruktør")
	public void testConstructor() {
		Assertions.assertEquals("APPL", stock.getTicker(), "Teste ticker");
		Assertions.assertEquals(110.0, stock.getPrice(), "Teste aksjeprisen");
	}

	@Test
	@DisplayName("Negativ aksjepris gir feilmelding")
	public void testSetNegativePrice() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			stock.setPrice(-20.0);
		}, "Teste å sette negativ aksjepris");
	}

	@Test
	@DisplayName("Aksjepris lik null gir feilmelding")
	public void testSetZeroPrice() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			stock.setPrice(0);
		}, "Teste å sette aksjepris lik null");
	}

	@Test
	@DisplayName("Legge til lytter")
	public void testStockListener() {
		StockListener listener = (Stock stock, double oldPrice, double newPrice) -> setPriceForListener(oldPrice,
				newPrice);
		stock.addStockListener(listener);

		setPriceCheckListener(118.0, 110.0, 118.0);
		Assertions.assertEquals(118.0, stock.getPrice(), "Teste aksjepris etter å ha oppdatert pris");

		setPriceCheckListener(121.0, 118.0, 121.0);
		Assertions.assertEquals(121.0, stock.getPrice(), "Teste aksjepris etter å ha oppdatert pris 2 ganger");
	}
}
