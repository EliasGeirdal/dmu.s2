package bibliotek;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bog {
	private LocalDate afleveringsDato;

	public Bog(LocalDate afleveringsdato) {
		this.afleveringsDato = afleveringsdato;
	}

	public int beregnGebyr(LocalDate date, boolean voksen) {
		int gebyr = 0;
		if (afleveringsDato.isBefore(date)) {

			if (ChronoUnit.DAYS.between(afleveringsDato, date) > 0) {
				if (voksen) {
					gebyr = 20;
				} else {
					gebyr = 10;
				}
			}
			if (ChronoUnit.DAYS.between(afleveringsDato, date) > 7) {
				if (voksen) {
					gebyr = 60;
				} else {
					gebyr = 30;
				}
			}
			if (ChronoUnit.DAYS.between(afleveringsDato, date) >= 15) {
				if (voksen) {
					gebyr = 90;
				} else {
					gebyr = 45;
				}
			}
		}
		return gebyr;
	}

}
