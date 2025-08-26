package application;

import entities.BRLClock;
import entities.Clock;
import entities.USClock;

public class Program {

	public static void main(String[] args) {
		Clock brlClock = new BRLClock();
		brlClock.setSecond(0);
		brlClock.setMinute(0);
		brlClock.setHour(23); // corrigido de 25 para 23 (última hora válida no formato 24h)
		
		System.out.println("Hora BRL: " + brlClock.getTime());
		System.out.println("Hora US: " + new USClock().convert(brlClock).getTime());
	}
}

