// Lavoro svolto nella room 2
// Fino a Milestone 2 compreso
package it.biglietti;

import java.time.LocalDate;
import java.util.Scanner;

public class Biglietteria {

	public static void main(String[] args) {
		int km, eta;
		LocalDate data = null;
		boolean flessibile;
		Scanner input = new Scanner(System.in);
		System.out.print("Inserire km:");
		km = input.nextInt();
		System.out.print("Inserire eta: ");
		eta = input.nextInt();
		//to fix: boolean works but rn needs true/false input. find better solution?
		System.out.print("Si desidera un biglietto flessibile? (Utilizzare true / false): ");
		flessibile = input.nextBoolean();
		
		Biglietto biglietto = new Biglietto(km, eta, data, flessibile);
		try {
			biglietto.isValidKm();
		}catch (Exception e) {
			System.out.println("Si e' verificato un errore: " + e.getMessage());
		}
		try {
			biglietto.isValidEta();
		}catch (Exception eD) {
			System.out.println("Si e' verificato un errore: " + eD.getMessage());
		}

		
		input.close();
		
		System.out.println("$" + biglietto.calcolaPrezzo());
		System.out.println("Data di scadenza: " + biglietto.calcolaDataScadenza());
	}

}
