package dominio;

public class TipoLinkPossiede {
	private Spettatore loSpettatore;
	private Biglietto ilBiglietto;
	
	public TipoLinkPossiede(Spettatore s, Biglietto b) throws EccezionePrecondizioni{
		if(b == null || s == null) {
			throw new EccezionePrecondizioni("Gli oggetti devono essere inizializzati");
		} else {
			this.loSpettatore = s;
			this.ilBiglietto = b;
		}
	}

	public Spettatore getSpettatore() {
		return loSpettatore;
	}

	public Biglietto getBiglietto() {
		return ilBiglietto;
	}
	
	public boolean equals(Object o) {
		if(o != null && getClass().equals(o.getClass())) {
			TipoLinkPossiede p = (TipoLinkPossiede) o;
			return p.ilBiglietto == this.ilBiglietto && p.loSpettatore == this.loSpettatore;
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		return this.ilBiglietto.hashCode() + this.loSpettatore.hashCode();
	}

}
