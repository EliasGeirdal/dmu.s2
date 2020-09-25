package storage;

import java.util.ArrayList;

import application.model.Company;
import application.model.Employee;

public class Storage {
	private static Storage uniqueStorage;
	private ArrayList<Company> companies = new ArrayList<>();
	private ArrayList<Employee> employees = new ArrayList<>();

	private Storage() {
	};

	public static Storage getInstance() {
		if (uniqueStorage == null) {
			uniqueStorage = new Storage();
		}
		return uniqueStorage;
	}

	// -------------------------------------------------------------------------

	public ArrayList<Company> getCompanies() {
		return new ArrayList<Company>(companies);
	}

	public void addCompany(Company company) {
		companies.add(company);
	}

	public void removeCompany(Company company) {
		companies.remove(company);
	}

	// -------------------------------------------------------------------------

	public ArrayList<Employee> getEmployees() {
		return new ArrayList<Employee>(employees);
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}

	// -------------------------------------------------------------------------

}
