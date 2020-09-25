package opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Opgave_03 {

	public static void main(String[] args) {

		try {
			System.out.println("Find tlf: ");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Intast navn: ");
			String navn = inLine.readLine();

			Connection minConnection;
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://COLUMBIDAE\\SQLEXPRESS;databaseName=Lek_03_Tidsregistrering;user=sa;password=cookie;");

			String sql = "select m.mobil from Medarbejder m where m.navn = (?)";// preparedStatement
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();

			prestmt.setString(1, navn);

			ResultSet res = prestmt.executeQuery();
			while (res.next()) {
				System.out.println("Tlf: " + res.getString(1) + "\t");
			}

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
