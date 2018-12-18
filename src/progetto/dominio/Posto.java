package dominio;

public class Posto {
	private final String codice;
	private Stato stato;
	private enum Stato { LIBERO, OCCUPATO };
	
	private TipoLinkSiede linkSiede;
	
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
	
	public void inserisciLinkSiede(TipoLinkSiede l) throws EccezioneMolteplicita{
		if(l != null && l.getPosto() == this && linkSiede == null) {
			ManagerSiede.inserisci(l);
		} else {
			throw new EccezioneMolteplicita("Molteplicita' massima violata");
		}
	}

	public void eliminaLinkSiede(TipoLinkSiede l) throws EccezioneMolteplicita{
		if(l != null && l.getPosto()== this && linkSiede != null) {
			ManagerSiede.elimina(l);
		} else {
			throw new EccezioneMolteplicita("Molteplicita' minima violata");
		}
	}

	public void inserisciPerManagerSiede(ManagerSiede k) {
		if(k != null) {
			linkSiede = k.getLink();
		}
	}

	public void eliminaPerManagerSiede(ManagerSiede k) {
		if(k != null) {
			linkSiede = null;
		}
	}
}
