package dominio;

import java.util.HashSet;
import java.util.Set;

public class Biglietto {
	private final int numero;
	private final Tipo tipo;
	private enum Tipo { INTERO, RIDOTTO }
	
	private HashSet<TipoLinkAcquista> insiemeAcquisti = new HashSet<TipoLinkAcquista>();
	
	public Biglietto(int numero) {
		//TODO: Gestire l'assegnazione del tipo in base allo spettatore
		this.tipo = null;
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}
	
	public int getCosto() { //Ottiene il costo di uno specifico biglietto
		switch (this.tipo){
		case RIDOTTO:
			return 10;
		default:
			return 13;
		}
	}
	
	public void inserisciLinkAcquista(TipoLinkAcquista link) {
		if(link != null && link.getBiglietto() == this) {
			ManagerAcquista.inserisci(link);
		}
	}
	
	public void eliminaLinkAcquista(TipoLinkAcquista link) {
		if(link != null && link.getBiglietto() == this) {
			ManagerAcquista.elimina(link);
		}
	}

	public void inserisciPerManagerAcquista(ManagerAcquista k) {
		if(k != null) {
			insiemeAcquisti.add(k.getLink());
		}
	}

	public void eliminaPerManagerAcquista(ManagerAcquista k) {
		if(k != null) {
			insiemeAcquisti.remove(k.getLink());
		}
	}
	
	@SuppressWarnings("unchecked")
	public Set<TipoLinkAcquista> getLinkAcquista(){
		return (HashSet<TipoLinkAcquista>) insiemeAcquisti.clone();
	}
	
}
