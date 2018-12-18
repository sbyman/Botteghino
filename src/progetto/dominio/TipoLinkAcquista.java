package dominio;

public class TipoLinkAcquista {
	private Biglietto biglietto;
	private Persona persona;
	private int quantita;
	
	public TipoLinkAcquista(Persona persona, Biglietto biglietto, int quantita) throws EccezionePrecondizioni {
		if(persona == null || biglietto == null) {
			throw new EccezionePrecondizioni("I valori di tipo link acquista devono essere dichiarati");
		} else if (quantita <= 0) {
			throw new EccezionePrecondizioni("La quantita deve avere un valore positivo");
		} else {
			this.persona = persona;
			this.biglietto = biglietto;
			this.quantita = quantita;
		}
	}
	
	public Persona getPersona() {
		return persona;
	}
	
	public Biglietto getBiglietto() {
		return biglietto;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public boolean equals(Object o) {
		if(o != null && getClass().equals(o.getClass())) {
			TipoLinkAcquista a = (TipoLinkAcquista) o;
			return a.persona == this.persona && a.biglietto == this.biglietto;
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		return this.persona.hashCode() + this.biglietto.hashCode();
	}

}
