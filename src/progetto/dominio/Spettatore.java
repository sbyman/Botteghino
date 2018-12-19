package dominio;

public class Spettatore extends Persona {
	private TipoLinkSiede linkSiede;
	private TipoLinkPossiede linkPossiede;
	private int eta;
	
	public Spettatore(String nome, String cognome, int eta) {
		super(nome, cognome);
		this.eta = eta;
	}

	public int getEta() {
		return eta;
	}
	
	public Posto getPosto() throws EccezionePrecondizioni {
		if(linkSiede != null) {
			return linkSiede.getPosto();
		} else {
			throw new EccezionePrecondizioni("Lo spettatore non è stato assegnato a nessun posto.");
		}
	}
	
	public Biglietto getBiglietto() throws EccezionePrecondizioni {
		if(linkPossiede != null) {
			return linkPossiede.getBiglietto();
		} else {
			throw new EccezionePrecondizioni("Lo spettatore non possiede un biglietto.");
		}
	}
	
	public void inserisciLinkPossiede(TipoLinkPossiede l) throws EccezioneMolteplicita{
		if(l != null && l.getSpettatore() == this && linkPossiede == null) {
			ManagerPossiede.inserisci(l);
		} else {
			throw new EccezioneMolteplicita("Molteplicita' massima violata");
		}
	}

	public void eliminaLinkPossiede(TipoLinkPossiede l) throws EccezioneMolteplicita{
		if(l != null && l.getSpettatore()== this && linkPossiede != null) {
			ManagerPossiede.elimina(l);
		} else {
			throw new EccezioneMolteplicita("Molteplicita' minima violata");
		}
	}

	public void inserisciPerManagerPossiede(ManagerPossiede k) {
		if(k != null && linkPossiede == null) {
			linkPossiede = k.getLink();
		}
	}

	public void eliminaPerManagerPossiede(ManagerPossiede k) {
		if(k != null && linkPossiede != null) {
			linkPossiede = null;
		}
	}
	
	public void inserisciLinkSiede(TipoLinkSiede l) throws EccezioneMolteplicita{
		if(l != null && l.getSpettatore() == this && linkSiede == null) {
			ManagerSiede.inserisci(l);
		} else {
			throw new EccezioneMolteplicita("Molteplicita' massima violata");
		}
	}

	public void eliminaLinkSiede(TipoLinkSiede l) throws EccezioneMolteplicita{
		if(l != null && l.getSpettatore() == this && linkSiede != null) {
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
