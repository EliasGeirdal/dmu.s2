package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import bibliotek.Bog;

public class BogTest {
	private Bog bog;

	@Before
	public void setUp() throws Exception {
		bog = new Bog(LocalDate.of(2020, 10, 14));
	}

	@Test
	public void testBeregnGebyr() {
		assertEquals(10, bog.beregnGebyr(LocalDate.of(2020, 10, 15), false));
		assertEquals(10, bog.beregnGebyr(LocalDate.of(2020, 10, 17), false));
		assertEquals(10, bog.beregnGebyr(LocalDate.of(2020, 10, 21), false));
		assertEquals(60, bog.beregnGebyr(LocalDate.of(2020, 10, 22), true));
		assertEquals(60, bog.beregnGebyr(LocalDate.of(2020, 10, 24), true));
		assertEquals(60, bog.beregnGebyr(LocalDate.of(2020, 10, 28), true));
		assertEquals(90, bog.beregnGebyr(LocalDate.of(2020, 10, 29), true));
		assertEquals(90, bog.beregnGebyr(LocalDate.of(2020, 10, 30), true));
	}

}
