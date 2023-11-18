package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class mClass {

	public static void main(String[] args) {
		Movies movies[] = new Movies[12];
		
		movies[0]= new Movies ("Волк с Уолл-стрит", "Мартин Скорсезе", 2013, 8.0);
		movies[1]= new Movies ("Достать ножи", "Райан Джонсон", 2019, 8.1);
		movies[2]= new Movies ("Оппенгеймер", "Кристофер Нолан", 2023, 8.4);
		movies[3]= new Movies ("Однажды в… Голливуде", "Квентин Тарантино", 2019, 7.7);
		movies[4]= new Movies ("Аватар", "Джеймс Кэмерон", 2009, 8.0);
		movies[5]= new Movies ("Сумерки", "Кэтрин Хардвик", 2008, 6.7);
		movies[6]= new Movies ("Жмурки", "Алексей Балабанов", 2005, 7.2);
		movies[7]= new Movies ("Сияние", "Стэнли Кубрик", 1980, 7.8);
		movies[8]= new Movies ("Бойцовский клуб", "Дэвид Финчер", 1999, 8.7);
		movies[9]= new Movies ("Убить Билла", "Квентин Тарантино", 2003, 7.7);
		movies[10]= new Movies ("Титаник", "Джеймс Кэмерон", 1997, 8.4);
		movies[11]= new Movies ("Лицо со шрамом", "Брайан Де Пальма", 1983, 8.2);
		
		for (int i = 0; i < movies.length; i++) {
			int j_max = i;
			for(int j = i + 1; j < movies.length; ++j) {
				if (movies[j_max].year < movies[j].year) {
					j_max = j;
				}
			}
			Movies temp = movies[i];
			movies[i] = movies[j_max];
			movies[j_max] = temp;
		}
		try {
			PrintStream out = new PrintStream (new File ("C:\\Users\\hjkkk\\eclipse-workspace\\lab1\\src\\lab1\\table_y.txt"));
			for (Movies movie : movies) {
				movie.printToFile(out);
			}
		}
		catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		for (int i = 0; i < movies.length; i++) {
			int j_max = i;
			for(int j = i + 1; j < movies.length; ++j) {
				if (movies[j_max].rate < movies[j].rate) {
					j_max = j;
				}
			}
			Movies temp = movies[i];
			movies[i] = movies[j_max];
			movies[j_max] = temp;
		}
		try {
			PrintStream out = new PrintStream (new File ("C:\\Users\\hjkkk\\eclipse-workspace\\lab1\\src\\lab1\\table_r.txt"));
			for (Movies movie : movies) {
				movie.printToFile(out);
			}
		}
		catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}

	}

}
