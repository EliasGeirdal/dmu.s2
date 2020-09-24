package setup;

import application.controller.Controller;

public class StorageInitializer {

	public static void main(String[] args) {
		initStorage();
	}

	/**
	 * Initializes the storage with some objects.
	 */
	private static void initStorage() {
		Controller service = Controller.getController();
		service.createStudent("Lene", 22, true);
		service.createStudent("Mette", 20, false);
		service.createStudent("Hans", 23, true);
		service.createStudent("Mads", 19, false);

		service.saveStorage();
	}

}
