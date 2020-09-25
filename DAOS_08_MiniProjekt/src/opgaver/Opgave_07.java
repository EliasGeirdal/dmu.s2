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
			System.out.println("Indsæt karakterer for studerende til eksamen");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Karakter: ");
			String karakter = inLine.readLine();
			System.out.println("bestået: Ja/Nej ");
			String bestået = inLine.readLine();
			if (bestået.equalsIgnoreCase("ja")) {
				bestået = "" + 1;
			} else {
				bestået = "" + 0;
			}
			System.out.println("Fagets navn: ");
			String fagID = inLine.readLine();
			System.out.println("Studerendes navn: ");
			String studID = inLine.readLine();

			Connection minConnection;
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://COLUMBIDAE\\SQLEXPRESS;databaseName=MiniProjekt;user=sa;password=cookie;");

			// test proc: 10, ja, Programmering, TestBob
			String sql = "exec insert_eksamen ?, ?, ?, ?";// preparedStatement
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();

			prestmt.setString(1, karakter.trim());
			prestmt.setString(2, bestået.trim());
			prestmt.setString(3, fagID.trim());
			prestmt.setString(4, studID.trim());

			prestmt.executeUpdate();
			System.out.println("Eksamens information oprettet for studerende:" + studID);

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
