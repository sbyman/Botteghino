package dominio;

public class TipoLinkSiede {
	private Spettatore loSpettatore;
	private Posto ilPosto;
	
	public TipoLinkSiede(Spettatore s, Posto p) throws EccezionePrecondizioni{
		if(s == null || p == null) {
			throw new EccezionePrecondizioni("Gli oggetti devono essere inizializzati");
		} else {
			this.ilPosto = p;
			this.loSpettatore = s;
		}
	}

	public Spettatore getSpettatore() {
		return loSpettatore;
	}

	public Posto getPosto() {
		return ilPosto;
	}
	
	public boolean equals(Object o) {
		if(o != null && getClass().equals(o.getClass())){
			TipoLinkSiede s = (TipoLinkSiede) o;
			return s.ilPosto == this.ilPosto && s.loSpettatore == this.loSpettatore;
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		return this.ilPosto.hashCode() + this.loSpettatore.hashCode();
	}

}
