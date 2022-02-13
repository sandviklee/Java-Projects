package oving4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PartnerTest {

	private Partner p1;
	private Partner p2;

	@BeforeEach
	public void setup() {
		p1 = new Partner("1");
		p2 = new Partner("2");
	}

	@Test
	@DisplayName("Sjekk konstruktøren ikke oppretter noen partnere")
	public void testConstructor() {
		assertNull(p1.getPartner());
		assertNull(p2.getPartner());
	}

	@Test
	@DisplayName("Sjekk at p1 og p2 er partnere etter p1.setPartner(s2)")
	public void simplePartnerShip() {
		// Enkelt partnerskap
		assertNull(p1.getPartner());
		assertNull(p2.getPartner());
		p1.setPartner(p2);
		assertEquals(p1.getPartner(), p2, "P1 skulle vært partneren til p2");
		assertEquals(p2.getPartner(), p1, "P2 skulle vært partneren til p1");
	}

	@Test
	@DisplayName("Sjekk at man kan oppløse partnerskap")
	public void partnershipWithDivorce() {
		// Partnerskap med etterfølgende brudd
		p1.setPartner(p2);
		assertEquals(p1.getPartner(), p2, "P1 skulle vært partneren til p2");
		assertEquals(p2.getPartner(), p1, "P2 skulle vært partneren til p1");
		p1.setPartner(null);
		assertNull(p1.getPartner());
		assertNull(p2.getPartner());
	}

	@Test
	@DisplayName("Sjekk at kombinert brudd med påfølgende opprettelse av nytt partnerskap fungerer")
	void swinger() {
		// "Partnerskap med etterfølgende kombinert brudd og nytt partnerskap"
		Partner p3 = new Partner("3");
		Partner p4 = new Partner("4");
		// Partnerskap inngås
		p1.setPartner(p2);
		p3.setPartner(p4);
		assertEquals(p1.getPartner(), p2, "P1 skulle vært partneren til p2");
		assertEquals(p2.getPartner(), p1, "P2 skulle vært partneren til p1");
		assertEquals(p3.getPartner(), p4, "P3 skulle vært partneren til p4");
		assertEquals(p4.getPartner(), p3, "P4 skulle vært partneren til p3");
		// Kombinert brudd og nytt partnerskap
		p1.setPartner(p4);
		assertEquals(p1.getPartner(), p4, "P4 skulle vært partneren til p1");
		assertEquals(p4.getPartner(), p1, "P1 skulle vært partneren til p4");
		assertNull(p2.getPartner());
		assertNull(p3.getPartner());
	}
}
