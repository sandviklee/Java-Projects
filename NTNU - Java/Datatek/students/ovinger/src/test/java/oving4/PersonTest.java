package oving4;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class PersonTest {

	private Person hallvard, marit, jens, anne;

	private void hasChildren(Person person, Collection<Person> children) {
		Assertions.assertEquals(children.size(), person.getChildCount());

		for (Person child : children) {
			boolean found = false;
			int i = 0;
			while (i < person.getChildCount()) {
				if (child == person.getChild(i)) {
					found = true;
				}
				i++;
			}
			Assertions.assertTrue(found);
		}
	}

	@BeforeEach
	public void setup() {
		hallvard = new Person("Hallvard", 'M');
		marit = new Person("Marit", 'F');
		jens = new Person("Jens", 'M');
		anne = new Person("Anne", 'F');
	}

	@Test
	@DisplayName("Kvinne kan ikke være far")
	public void testFatherException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			jens.setFather(marit);
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			anne.setFather(marit);
		});
	}

	@Test
	@DisplayName("Mann kan ikke være mor")
	public void testMotherException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			jens.setMother(hallvard);
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			anne.setMother(hallvard);
		});
	}

	@Test
	@DisplayName("Mann kan ikke være sin egen far")
	public void testSelfFatherException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			jens.setFather(jens);
		});
	}

	@Test
	@DisplayName("Kvinne kan ikke være sin egen mor")
	public void testSelfMotherException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			anne.setMother(anne);
		});
	}

	@Test
	@DisplayName("Sette farskap med setFather")
	public void testSetFather() {
		jens.setFather(hallvard);

		// Check state of hallvard
		Assertions.assertEquals(null, hallvard.getFather());
		Assertions.assertEquals(null, hallvard.getMother());
		hasChildren(hallvard, Arrays.asList(jens));

		// Check state of jens
		Assertions.assertEquals(hallvard, jens.getFather());
		Assertions.assertEquals(null, jens.getMother());
		Assertions.assertEquals(0, jens.getChildCount());

		anne.setFather(hallvard);

		// Check state of hallvard
		Assertions.assertEquals(null, hallvard.getFather());
		Assertions.assertEquals(null, hallvard.getMother());
		hasChildren(hallvard, Arrays.asList(jens, anne));

		// Check state of jens
		Assertions.assertEquals(hallvard, jens.getFather());
		Assertions.assertEquals(null, jens.getMother());
		Assertions.assertEquals(0, jens.getChildCount());

		// Check state of anne
		Assertions.assertEquals(hallvard, anne.getFather());
		Assertions.assertEquals(null, anne.getMother());
		Assertions.assertEquals(0, anne.getChildCount());
	}

	@Test
	@DisplayName("Sette farskap med addChild")
	public void testFatherAddChild() {
		hallvard.addChild(jens);

		// Check state of hallvard
		Assertions.assertEquals(null, hallvard.getFather());
		Assertions.assertEquals(null, hallvard.getMother());
		hasChildren(hallvard, Arrays.asList(jens));

		// Check state of jens
		Assertions.assertEquals(hallvard, jens.getFather());
		Assertions.assertEquals(null, jens.getMother());
		Assertions.assertEquals(0, jens.getChildCount());

		hallvard.addChild(anne);

		// Check state of hallvard
		Assertions.assertEquals(null, hallvard.getFather());
		Assertions.assertEquals(null, hallvard.getMother());
		hasChildren(hallvard, Arrays.asList(jens, anne));

		// Check state of jens
		Assertions.assertEquals(hallvard, jens.getFather());
		Assertions.assertEquals(null, jens.getMother());
		Assertions.assertEquals(0, jens.getChildCount());

		// Check state of anne
		Assertions.assertEquals(hallvard, anne.getFather());
		Assertions.assertEquals(null, anne.getMother());
		Assertions.assertEquals(0, anne.getChildCount());
	}

	@Test
	@DisplayName("Sette morskap med setMother")
	public void testSetMother() {
		jens.setMother(marit);

		// Check state of marit
		Assertions.assertEquals(null, marit.getFather());
		Assertions.assertEquals(null, marit.getMother());
		hasChildren(marit, Arrays.asList(jens));

		// Check state of jens
		Assertions.assertEquals(null, jens.getFather());
		Assertions.assertEquals(marit, jens.getMother());
		Assertions.assertEquals(0, jens.getChildCount());

		anne.setMother(marit);

		// Check state of marit
		Assertions.assertEquals(null, marit.getFather());
		Assertions.assertEquals(null, marit.getMother());
		hasChildren(marit, Arrays.asList(jens, anne));

		// Check state of jens
		Assertions.assertEquals(null, jens.getFather());
		Assertions.assertEquals(marit, jens.getMother());
		Assertions.assertEquals(0, jens.getChildCount());

		// Check state of anne
		Assertions.assertEquals(null, anne.getFather());
		Assertions.assertEquals(marit, anne.getMother());
		Assertions.assertEquals(0, anne.getChildCount());
	}

	@Test
	@DisplayName("Sette morskap med addChild")
	public void testMotherAddChild() {
		marit.addChild(jens);

		// Check state of marit
		Assertions.assertEquals(null, marit.getFather());
		Assertions.assertEquals(null, marit.getMother());
		hasChildren(marit, Arrays.asList(jens));

		// Check state of jens
		Assertions.assertEquals(null, jens.getFather());
		Assertions.assertEquals(marit, jens.getMother());
		Assertions.assertEquals(0, jens.getChildCount());

		marit.addChild(anne);

		// Check state of marit
		Assertions.assertEquals(null, marit.getFather());
		Assertions.assertEquals(null, marit.getMother());
		hasChildren(marit, Arrays.asList(jens, anne));

		// Check state of jens
		Assertions.assertEquals(null, jens.getFather());
		Assertions.assertEquals(marit, jens.getMother());
		Assertions.assertEquals(0, jens.getChildCount());

		// Check state of anne
		Assertions.assertEquals(null, anne.getFather());
		Assertions.assertEquals(marit, anne.getMother());
		Assertions.assertEquals(0, anne.getChildCount());
	}

	@Test
	@DisplayName("Endre far med setFather")
	public void testChangeFatherSetFather() {
		anne.setFather(jens);
		// Check state of anne
		Assertions.assertEquals(jens, anne.getFather());
		// Check state of jens
		hasChildren(jens, Arrays.asList(anne));

		anne.setFather(hallvard);
		// Check state of anne
		Assertions.assertEquals(hallvard, anne.getFather());
		// Check state of jens
		Assertions.assertEquals(0, jens.getChildCount());
		// Check state of hallvard
		hasChildren(hallvard, Arrays.asList(anne));
	}

	@Test
	@DisplayName("Endre far med addChild")
	public void testChangeFatherAddChild() {
		jens.addChild(anne);
		// Check state of anne
		Assertions.assertEquals(jens, anne.getFather());
		// Check state of jens
		hasChildren(jens, Arrays.asList(anne));

		hallvard.addChild(anne);
		// Check state of anne
		Assertions.assertEquals(hallvard, anne.getFather());
		// Check state of jens
		Assertions.assertEquals(0, jens.getChildCount());
		// Check state of hallvard
		hasChildren(hallvard, Arrays.asList(anne));
	}

	@Test
	@DisplayName("Endre morskap med setMother")
	public void testChangeMotherSetMother() {
		jens.setMother(anne);
		// Check state of jens
		Assertions.assertEquals(anne, jens.getMother());
		// Check state of anne
		hasChildren(anne, Arrays.asList(jens));

		jens.setMother(marit);
		// Check state of jens
		Assertions.assertEquals(marit, jens.getMother());
		// Check state of anne
		Assertions.assertEquals(0, anne.getChildCount());
		// Check state of marit
		hasChildren(marit, Arrays.asList(jens));
	}

	@Test
	@DisplayName("Endre morskap med addChild")
	public void testChangeMotherAddChild() {
		anne.addChild(jens);
		// Check state of jens
		Assertions.assertEquals(anne, jens.getMother());
		// Check state of anne
		hasChildren(anne, Arrays.asList(jens));

		marit.addChild(jens);
		// Check state of jens
		Assertions.assertEquals(marit, jens.getMother());
		// Check state of anne
		Assertions.assertEquals(0, anne.getChildCount());
		// Check state of marit
		hasChildren(marit, Arrays.asList(jens));
	}
}
