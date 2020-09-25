package opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Opgave_07 {

	public static void main(String[] args) {

		try {
			System.out.println("Opret tidsregistrering");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Navn: ");
			String navn = inLine.readLine();
			System.out.println("Stillingsbetegnelse: ");
			String stilling = inLine.readLine();
			System.out.println("Telefon: ");
			String tlf = inLine.readLine();

			Connection minConnection;
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://COLUMBIDAE\\SQLEXPRESS;databaseName=Lek_03_Tidsregistrering;user=sa;password=cookie;");

			String sql = "exec opretMedarbejder ?, ?, ?";// preparedStatement
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();

			prestmt.setString(1, navn.trim());
			prestmt.setString(2, stilling.trim());
			prestmt.setString(3, tlf.trim());

			prestmt.executeUpdate();
			System.out.println("Medarbejder oprettet");

			if (prestmt != null)
				prestmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (SQLException e) {
			System.out.println("fejl:  " + e.getErrorCode());
			System.out.println("fejl:  " + e.getMessage());
		} catch (Exception e) {
			System.out.println("fejl: " + e.getMessage());
		}
	}

}
