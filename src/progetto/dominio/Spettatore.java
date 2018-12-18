package dominio;

public class Spettatore extends Persona {
	private int eta;
	
	public Spettatore(String nome, String cognome, int eta) {
		super(nome, cognome);
		this.eta = eta;
	}

	public int getEta() {
		return eta;
	}
	
}
