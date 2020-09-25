package eksJDBC20V;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EksPreparedStatement {

	public static void main(String[] args) {

		try {
			System.out.println("Opret Medlem ");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Indtast medlemsID: ");
			String medId = inLine.readLine();
			System.out.println("Intast navn: ");
			String navn = inLine.readLine();
			System.out.println("Indtast alder: ");
			String alder = inLine.readLine();

			Connection minConnection;
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://COLUMBIDAE\\SQLEXPRESS;databaseName=Lektion_02_OmformingAfKlassediagrammer;user=sa;password=cookie;");

			String sql = "insert into Medlem values(?,?,?) ";// preparedStatement
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();

			prestmt.setInt(1, Integer.parseInt(medId.trim()));
			prestmt.setString(2, navn);
			prestmt.setInt(3, Integer.parseInt(alder.trim()));

			prestmt.executeUpdate();
			System.out.println("Medlem indsat");

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
