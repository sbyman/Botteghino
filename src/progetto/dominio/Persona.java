package dominio;

import java.util.HashSet;
import java.util.Set;

public class Persona {
	private final String nome;
	private final String cognome;
	
	private HashSet<TipoLinkAcquista> insiemeAcquisti = new HashSet<TipoLinkAcquista>();
	
	public Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}
	
	public void inserisciLinkAcquista(TipoLinkAcquista l) {
		if(l != null && l.getPersona() == this) {
			ManagerAcquista.inserisci(l);
		}
	}
	
	public void eliminaLinkAcquista(TipoLinkAcquista l) {
		if(l != null && l.getPersona() == this) {
			ManagerAcquista.elimina(l);
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
