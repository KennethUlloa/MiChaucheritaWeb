package utilities;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class DateRange {
	private LocalDate inicio;
	private LocalDate fin;
	
	public DateRange(int mes, int anio) {
		Month m = Month.of(mes);
		int days = m.length(Year.of(anio).isLeap());
		inicio = LocalDate.of(anio, mes, 1);
		fin = LocalDate.of(anio, mes, days);
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public LocalDate getFin() {
		return fin;
	}
	
}
