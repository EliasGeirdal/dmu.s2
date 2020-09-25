package eksJDBC20V;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectMedlemmer {

	public static void main(String[] args) {

		try {
			Connection minConnection;
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://COLUMBIDAE\\SQLEXPRESS;databaseName=Lektion_02_OmformingAfKlassediagrammer;user=sa;password=cookie;");

			Statement stmt = minConnection.createStatement();

			ResultSet res = stmt.executeQuery("select * from Medlem");
			while (res.next()) {
				System.out.println(res.getString(1) + "\t" + res.getString(2) + " \t " + res.getString(3));
			}

			if (res != null)
				res.close();
			if (stmt != null)
				stmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}
}
