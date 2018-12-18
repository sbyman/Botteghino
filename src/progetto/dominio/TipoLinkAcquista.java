package dominio;

public class TipoLinkAcquista {
	private int quantita;
	private Persona laPersona;
	private Biglietto ilBiglietto;
	
	public TipoLinkAcquista(Persona p, Biglietto b, int quantita) throws EccezionePrecondizioni{
		if(b == null || p == null) {
			throw new EccezionePrecondizioni("Gli oggetti devono essere inizializzati");
		} else if (quantita <= 0) {
			throw new EccezionePrecondizioni("La quantita' deve essere positiva");
		} else {
			this.laPersona = p;
			this.ilBiglietto = b;
			this.quantita = quantita;
		}
	}

	public int getQuantita() {
		return quantita;
	}

	public Persona getPersona() {
		return laPersona;
	}

	public Biglietto getBiglietto() {
		return ilBiglietto;
	}
	
	public boolean equals(Object o) {
		if(o != null && getClass().equals(o.getClass())) {
			TipoLinkAcquista a = (TipoLinkAcquista) o;
			return a.laPersona == this.laPersona && a.ilBiglietto == this.ilBiglietto;
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		return this.laPersona.hashCode() + this.ilBiglietto.hashCode();
	}
}
