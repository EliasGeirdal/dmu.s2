package opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Opgave_06 {

	public static void main(String[] args) {

		try {
			System.out.println("Opret tidsregistrering");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Start tid: ");
			String start = inLine.readLine();
			System.out.println("Slut tid: ");
			String slut = inLine.readLine();
			System.out.println("Beskrivelse: ");
			String beskrivelse = inLine.readLine();

			System.out.println("Er dato for i dag?");
			String datoIdag = inLine.readLine();
			String dato;
			if (datoIdag == "nej") {
				System.out.println("Dato: (år/måned/dag)");
				dato = inLine.readLine();
			} else {
				dato = "" + LocalDate.now();
			}

			System.out.println("Medarbejder nr: ");
			String MedNr = inLine.readLine();
			System.out.println("Opgave nr: ");
			String OpgNr = inLine.readLine();

			// insert into Tidsregistrering values
			// ('8:30', '16:00', 'Godt arbejde', '2019-08-02', 2, 1)

			Connection minConnection;
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://COLUMBIDAE\\SQLEXPRESS;databaseName=Lek_03_Tidsregistrering;user=sa;password=cookie;");

			String sql = "insert into Tidsregistrering values(?, ?, ?, ?, ?, ?)";// preparedStatement
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();

			prestmt.setString(1, start.trim());
			prestmt.setString(2, slut.trim());
			prestmt.setString(3, beskrivelse.trim());
			prestmt.setString(4, dato.trim());
			prestmt.setInt(5, Integer.parseInt(MedNr.trim()));
			prestmt.setInt(6, Integer.parseInt(OpgNr.trim()));

			prestmt.executeUpdate();
			System.out.println("Tidsregistrering oprettet for Medarbejder:" + MedNr);

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
