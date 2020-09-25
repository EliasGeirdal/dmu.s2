package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import opgave_3.Skole;
import opgave_3.Studerende;

public class SkoleTest {
	private Skole skole;
	private Studerende stud;
	private Studerende stud1;

	@Before
	public void setUp() throws Exception {
		skole = new Skole("Super skole");

		stud = new opgave_3.Studerende(1, "Studyman");
		stud1 = new opgave_3.Studerende(3, "FE male");
		stud.addKarakter(4);
		stud.addKarakter(7);
		stud.addKarakter(10);
		stud.addKarakter(2);
//
		stud1.addKarakter(4);
		stud1.addKarakter(7);
		stud1.addKarakter(10);
		stud1.addKarakter(2);
		skole.addStuderende(stud);
		skole.addStuderende(stud1);
	}

	@Test
	public void testSkole() {
		assertNotNull(skole);
	}

	@Test
	public void testFindStuderende() {
		assertEquals(stud, skole.findStuderende(1));
	}

	@Test
	public void testGennemsnit() {
		assertEquals(5.75, skole.gennemsnit(), 0.0001);
	}

	@Test
	public void testRemoveStuderende() {
		skole.removeStuderende(stud1);
		assertEquals(null, skole.findStuderende(3));
	}

	@Test
	public void testAddStuderende() {
		Studerende studerende = new Studerende(2, "Quebec");
		skole.addStuderende(studerende);
	}

	@Test
	public void testGetNavn() {
		assertEquals("Super skole", skole.getNavn());
	}

}
