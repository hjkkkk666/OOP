package lab1;

import java.io.PrintStream;

public class Movies {
	String title;
	String director;
	int year;
	double rate;
	
	public Movies(String title, String director, int year, double rate) {
		this.title = title;
		this.director = director;
		this.year = year;
		this.rate = rate;
	}

	void print() {
		System.out.printf("%30s %30s %4d %2.1f\n", title, director, year, rate);
	}
	
	void printToFile(PrintStream stream) {
		stream.printf("%30s %30s %4d %2.1f\n", title, director, year, rate);
	}
}
