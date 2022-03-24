package oving6.observable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StockIndexTest {

	private static final double facebookPrice = 67.80d;
	private static final double applePrice = 534.98;
	private static final double epsilon = 0.000001d;

	private Stock facebook, apple;
	private StockIndex index0, index1, indexN;

	@BeforeEach
	public void setup() {
		facebook = new Stock("FB", facebookPrice);
		apple = new Stock("AAPL", applePrice);

		index0 = new StockIndex("OSEBX");
		index1 = new StockIndex("OSEBX", facebook);
		indexN = new StockIndex("OSEBX", facebook, apple);
	}

	@Test
	@DisplayName("Teste konstruktør")
	public void testConstructor() {
		Assertions.assertEquals(0.0, index0.getIndex(), epsilon, "Teste verdien til indeks med 0 aksjer ");
		Assertions.assertEquals(facebookPrice, index1.getIndex(), epsilon, "Teste verdien til indeks med 1 aksje");
		Assertions.assertEquals(facebookPrice + applePrice, indexN.getIndex(), epsilon,
				"Teste verdien til indeks med 2 aksjer");
	}

	@Test
	@DisplayName("Legge til aksje")
	public void testAddStock() {
		Assertions.assertEquals(0.0, index0.getIndex(), epsilon, "Teste verdien til indeks med 0 aksjer");
		index0.addStock(facebook);
		Assertions.assertEquals(facebookPrice, index0.getIndex(), epsilon,
				"Teste verdien til indeks etter å ha lagt til 1 aksje");
	}

	@Test
	@DisplayName("Legge til samme aksje to ganger")
	public void testAddDuplicateStocks() {
		Assertions.assertEquals(0.0, index0.getIndex(), epsilon, "Teste verdien til indeks med 0 aksjer");

		index0.addStock(facebook);
		Assertions.assertEquals(facebookPrice, index0.getIndex(), epsilon,
				"Teste verdien til indeks etter å ha lagt til 1 aksje");

		index0.addStock(facebook);
		Assertions.assertEquals(facebookPrice, index0.getIndex(), epsilon,
				"Teste verdien til indeks etter å ha lagt til aksje som allerede er med i indeks");
	}

	@Test
	@DisplayName("Fjerne aksje")
	public void testRemoveStock() {
		Assertions.assertEquals(facebookPrice + applePrice, indexN.getIndex(), epsilon,
				"Teste verdien til indeks med 2 aksjer");

		indexN.removeStock(apple);
		Assertions.assertEquals(facebookPrice, indexN.getIndex(), epsilon,
				"Teste verdien til indeks etter å ha fjernet 1 aksje");

		indexN.removeStock(apple);
		Assertions.assertEquals(facebookPrice, indexN.getIndex(), epsilon,
				"Teste verdien til indeks etter å ha fjernet 1 aksje som ikke var med i indeks");

		indexN.removeStock(facebook);
		Assertions.assertEquals(0.0, indexN.getIndex(), epsilon,
				"Teste verdien til indeks etter å ha fjernet eneste aksje i indeks");
	}

	@Test
	@DisplayName("Endre aksjepris")
	public void testChangePrice() {
		double facebookPrice2 = 67.0;
		double facebookPrice3 = 69.0;

		facebook.setPrice(facebookPrice2);
		Assertions.assertEquals(facebookPrice2, index1.getIndex(), epsilon,
				"Teste verdien til indeks med 1 aksje etter å ha endret prisen på aksje");
		Assertions.assertEquals(facebookPrice2 + applePrice, indexN.getIndex(), epsilon,
				"Teste verdien til indeks med 2 aksjer etter å ha endret prisen til 1 av aksjene");

		facebook.setPrice(facebookPrice3);
		Assertions.assertEquals(facebookPrice3, index1.getIndex(), epsilon,
				"Teste verdien til indeks med 1 aksje etter å ha endret prisen på aksje for andre gang");
		Assertions.assertEquals(facebookPrice3 + applePrice, indexN.getIndex(), epsilon,
				"Teste verdien til indeks med 2 aksjer etter å ha endret prisen til 1 av aksjene for andre gang");
	}
}