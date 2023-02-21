import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class Test {
	public static void main(String[] args) {
		int mes = 2;
		int anio = 2024;
		Month m = Month.of(mes);
		int days = m.length(Year.of(anio).isLeap());
		
		LocalDate inicio = LocalDate.of(anio, mes, 1);
		LocalDate fin = LocalDate.of(anio, mes, days);
		System.out.println(inicio);
		System.out.println(fin);
	}
}
