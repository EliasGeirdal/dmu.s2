package application.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import application.model.Company;
import application.model.Employee;
import storage.Storage;

public class Controller {
	private static Controller uniqueController;
	private Storage storage = Storage.getInstance();

	private Controller() {
	}

	public static Controller getInstance() {
		if (uniqueController == null) {
			uniqueController = new Controller();
		}
		return uniqueController;
	}

	/**
	 * Creates a new Company.<br />
	 * Requires: hours >= 0.
	 */
	public Company createCompany(String name, int hours) {
		Company company = new Company(name, hours);
		storage.addCompany(company);
		return company;
	}

	/**
	 * Deletes the company.<br />
	 * Requires: The company has no employees.
	 */
	public void deleteCompany(Company company) {
		storage.removeCompany(company);
	}

	/**
	 * Updates the company.<br />
	 * Requires: hours >= 0.
	 */
	public void updateCompany(Company company, String name, int hours) {
		company.setName(name);
		company.setHours(hours);
	}

	/**
	 * Get all the companies
	 */
	public ArrayList<Company> getCompanies() {
		return storage.getCompanies();
	}

	// -------------------------------------------------------------------------

	/**
	 * Creates a new employee.<br />
	 * Requires: wage >= 0.
	 */
	public Employee createEmployee(String name, int wage) {
		Employee employee = new Employee(name, wage);
		storage.addEmployee(employee);
		return employee;
	}

	/**
	 * Creates a new employee.<br />
	 * Requires: wage >= 0, company!=null.
	 */
	public Employee createEmployee(String name, int wage, Company company) {
		Employee employee = createEmployee(name, wage);
		company.addEmployee(employee);
		return employee;
	}

	/**
	 * Deletes the employee.
	 */
	public void deleteEmployee(Employee employee) {
		Company company = employee.getCompany();
		if (company != null) {
			company.removeEmployee(employee);
		}
		storage.removeEmployee(employee);
	}

	/**
	 * Updates the employee.<br />
	 * Requires: wage >= 0.
	 */
	public void updateEmployee(Employee employee, String name, int wage) {
		employee.setName(name);
		employee.setWage(wage);
	}

	/**
	 * Adds the employee to the company. Removes the employee from the old company
	 * if present.
	 */
	public void addEmployeeToCompany(Employee employee, Company company) {
		company.addEmployee(employee);
	}

	/**
	 * Removes the employee from the old company if not null.
	 * 
	 * @param company  The old company. Can be null.
	 * @param employee The employee to remove.
	 */
	public void removeEmployeeFromCompany(Employee employee, Company company) {
		if (company != null) {
			company.removeEmployee(employee);
		}
	}

	/**
	 * Get all the employees.
	 */
	public ArrayList<Employee> getEmployees() {
		return storage.getEmployees();
	}

	// -------------------------------------------------------------------------

	/**
	 * serialize storage with terms used in PRO_14-Eksempler
	 */
	public void saveStorage() {
		try (FileOutputStream fos = new FileOutputStream("Storage.ser")) {
			try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(storage);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deserialize storage with terms used in PRO_14_Eksempler
	 * 
	 * @throws ClassNotFoundException
	 */
	public void loadStorage() throws ClassNotFoundException {
		try (FileInputStream fis = new FileInputStream("Storage.ser")) {
			try (ObjectInputStream ois = new ObjectInputStream(fis)) {
				storage = (Storage) ois.readObject();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("error loading storage.");
			throw new RuntimeException(e);
		}
	}

	/**
	 * Serialize any type of Object.
	 */
	public void serialize(Object o) {
		try {
			FileOutputStream fos = new FileOutputStream("Object.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Serialize specific object.
	 */
	public void serialize(Employee e) {
		e.serialize();
	}

	public void serialize(Company c) {
		c.serialize();
	}

	// -------------------------------------------------------------------------

	/**
	 * Initializes the storage with some objects.
	 */
	public static void initStorage() {
		Controller controller = Controller.getInstance();
		Company c1 = controller.createCompany("IBM", 37);
		Company c2 = controller.createCompany("AMD", 40);
		controller.createCompany("SLED", 45);
		controller.createCompany("Vector", 32);

		controller.createEmployee("Bob Dole", 210, c2);
		controller.createEmployee("Alice Schmidt", 250, c1);
		controller.createEmployee("George Down", 150, c2);

		controller.createEmployee("Rita Uphill", 300);
	}

	public static void init() {

		initStorage();

	}

}
