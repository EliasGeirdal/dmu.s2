package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import forsikring.BilForsikring;

public class BilForsikringTest {
	private BilForsikring bilforsikring;

	@Before
	public void setUp() throws Exception {
		bilforsikring = new BilForsikring(1000);
	}

	@Test
	public void testGetGrundPraemie() {
		double grundPræmie = bilforsikring.getGrundPraemie();
		assertEquals(1000, grundPræmie, 0.0001);
	}

	@Test
	public void testSetGrundpaemie() {
		bilforsikring.setGrundpaemie(5000);
		assertEquals(5000, bilforsikring.getGrundPraemie(), 0.0001);
	}

	@Test
	public void testBeregnPraemie() {
		assertEquals(1250, bilforsikring.beregnPraemie(23, false, 0), 0.001);
		assertEquals(1009.375, bilforsikring.beregnPraemie(23, true, 4), 0.0001);
		assertEquals(750, bilforsikring.beregnPraemie(28, false, 6), 0.001);
		assertEquals(617.5, bilforsikring.beregnPraemie(30, true, 9), 0.001);
	}

	@Test(expected = RuntimeException.class)
	public void nulGrunpræmieException() {
		bilforsikring.setGrundpaemie(0);
		bilforsikring.beregnPraemie(24, false, 2);
	}

	@Test
	public void ungException() {
		try {
			bilforsikring.beregnPraemie(17, false, 2);
			fail("For ung.");
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "Du er for ung til at tegne en forsikring");
		}
	}

	@Test
	public void ForMangeSkadefriÅrException() {
		try {
			bilforsikring.beregnPraemie(20, false, 3);
			fail();
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "Du kan ikke have kaert skadefri saelaenge");
		}
	}

	@Test(expected = RuntimeException.class)
	public void negativSkadefriÅrException() {
		bilforsikring.beregnPraemie(24, false, -2);
	}

}
