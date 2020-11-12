package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import application.controller.Controller;
import application.model.Student;

public class ControllerTest {
	private Controller controller = Controller.getController();

	@Before
	public void setUp() throws Exception {
		controller.createStudent("Margrethe", 51, true);
		System.out.println("setup kaldt");
	}

	@Test
	public void testCreateStudent() {
		Student s1 = controller.createStudent("Hanne", 51, true);
		assertNotNull(s1);
		assertEquals(s1.getName(), "Hanne");

		assertTrue(controller.getStudents().contains(s1));

	}

	@Test
	public void testDeleteStudent() {
		Student s2 = controller.createStudent("Hanne", 51, true);
		assertTrue(controller.getStudents().contains(s2));
		controller.deleteStudent(s2);
		assertFalse(controller.getStudents().contains(s2));

	}

	@Test
	public void testGetAge() {
		Student s1 = controller.createStudent("Margrethe", 25, true);
		assertEquals(s1.getAge(), 25);

	}

}
