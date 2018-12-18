package dominio;

public class Posto {
	private final String codice;
	private Stato stato;
	private enum Stato { LIBERO, OCCUPATO };
	
	public Posto(String codice) {
		this.codice = codice;
		stato = Stato.OCCUPATO;
	}
	
	public String getCodice() {
		return codice;
	}
	
	public boolean isOccupato() { //Verifica se un posto è libero
		return this.stato == Stato.OCCUPATO;
	}
	
	public void setStato(Stato stato) {
		this.stato = stato;
	}

}
