// Lavoro svolto nella room 2
// Milestone 2
package it.biglietti;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

public class Biglietto {

	
//		Alla classe Biglietto aggiungere i seguenti attributi:
//		data: LocalDate
//		flessibile: boolean
//		Entrambi gli attributi vanno valorizzati nel costruttore.
//		
//		Aggiungere due costanti:
//		durata normale: 30 giorni (int)
//		durata flessibile: 90 giorni (int)
//		
//		Aggiungere un metodo (calcolaDataScadenza: LocalDate) che calcola la data di scadenza del biglietto, applicando la durata normale o flessibile in base al parametro flessibile(boolean).
//		
//		Nel metodo che calcola il prezzo, se il biglietto è flessibile, maggiorare il prezzo del 10%.
//		
//		Modificare la classe Biglietteria in modo che, alla creazione del Biglietto, valorizzi la data con la data odierna e il parametro flessibile in base alla scelta dell’utente.
//		Dopo aver stampato il prezzo del biglietto, stampare a video anche la data di scadenza.



//	costanti
	private final static BigDecimal COSTO_PER_KM = new BigDecimal(0.21);
	private final static BigDecimal SCONTO_OVER = new BigDecimal(0.4);
	private final static BigDecimal SCONTO_UNDER = new BigDecimal(0.2);
	private final static int DURATA_NORMALE = 30; //30gg
	private final static int DURATA_FLESSIBILE = 90; //00gg
	
//	attributi
	private int km, eta;
	private LocalDate data;
	private boolean flessibile;
	 
//	costruttori
	public Biglietto(int km, int eta, LocalDate data, boolean flessibile) {
		this.km = km;
		this.eta = eta;
		this.data = data;
		this.flessibile = flessibile;
	}
	
	
//	metodi
	 public boolean isValidKm() throws Exception {
		 if(km <= 0) {
			 throw new Exception("Km not valid");
		 } return true;
	 }
	 public boolean isValidEta() throws Exception {
		 if(eta <= 0) {
			 throw new Exception("Eta not valid");
		 } return true;
	 }
	 
	 private BigDecimal calcolaSconto() {
		 if (eta < 18) {
			 return SCONTO_UNDER;
		 } 
		 if (eta > 65) {
			 return SCONTO_OVER; 
		 } 
		 return new BigDecimal(0);
	 }
	 
	 public BigDecimal calcolaPrezzo() {
		 MathContext context = new MathContext(3);
		 BigDecimal kmBD = new BigDecimal(km);
		 BigDecimal costo = COSTO_PER_KM.multiply(kmBD);
		 BigDecimal sconto = costo.multiply(calcolaSconto());
		 if (flessibile == false) {
		 return costo.subtract(sconto,context);
		 } else {
			 BigDecimal prezzoPerFlessibile = new BigDecimal(1.1);
			 return (costo.subtract(sconto,context)).multiply(prezzoPerFlessibile,context);
		 }
	 }
	 
	/*
	 * Aggiungere un metodo (calcolaDataScadenza: LocalDate) 
	 * che calcola la data di scadenza del biglietto, 
	 * applicando la durata normale o flessibile in base 
	 * al parametro flessibile(boolean).
	 */
	 
	 // metodo per calcolare la scadenza del biglietto
	 public LocalDate calcolaDataScadenza() {
		 if (flessibile == false) {
			 data = LocalDate.now().plusDays(DURATA_NORMALE);
		 } else {
			 data = LocalDate.now().plusDays(DURATA_FLESSIBILE);
		 }
		 return data;
		 
	 }
	 

	 
	 
	 

}
