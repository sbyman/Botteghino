package dominio;


public class Biglietto {
	private static int totale;
	private final int numero;
	private final Tipo tipo;
	private enum Tipo { INTERO, RIDOTTO };
	
	private TipoLinkPossiede linkPossiede;
		
	public Biglietto(int numero) {
		//TODO: Gestire l'assegnazione del tipo in base allo spettatore
		this.tipo = null;
		this.numero = numero;
		totale++;
	}
	
	public static int getTotale() {
		return totale;
	}

	public int getNumero() {
		return numero;
	}
	
	public void inserisciLinkPossiede(TipoLinkPossiede l) throws EccezioneMolteplicita{
		if(l != null && l.getBiglietto() == this && linkPossiede == null) {
			ManagerPossiede.inserisci(l);
		} else {
			throw new EccezioneMolteplicita("Molteplicita' massima violata");
		}
	}

	public void eliminaLinkPossiede(TipoLinkPossiede l) throws EccezioneMolteplicita{
		if(l != null && l.getBiglietto() == this && linkPossiede != null) {
			ManagerPossiede.elimina(l);
		} else {
			throw new EccezioneMolteplicita("Molteplicita' minima violata");
		}
	}
	
	public int getCosto() { //Ottiene il costo di uno specifico biglietto
		switch (this.tipo){
		case RIDOTTO:
			return 10;
		default:
			return 13;
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
}
