// Lavoro svolto nella room 2
// Fino a Milestone 2 compreso
package it.biglietti;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

public class Biglietto {

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
			 throw new Exception("Numero km non valido");
		 } return true;
	 }
	 public boolean isValidEta() throws Exception {
		 if(eta <= 0) {
			 throw new Exception("Età non valida");
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
