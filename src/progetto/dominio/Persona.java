package dominio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
	
	public int quantiBiglietti() {
		return insiemeAcquisti.isEmpty() ? 0 : insiemeAcquisti.size();
	}
	
	public HashMap<Integer, Integer> tipoBiglietti() throws EccezionePrecondizioni {
		if(insiemeAcquisti.isEmpty()) {
			throw new EccezionePrecondizioni("La persona non ha acquistato alcun biglietto");
		} else {
			Iterator<TipoLinkAcquista> it = insiemeAcquisti.iterator();
			HashMap<Integer, Integer> listaBiglietti = new HashMap<Integer, Integer>();
			while(it.hasNext()) {
				Biglietto temp = it.next().getBiglietto();
				listaBiglietti.put(temp.getNumero(), temp.getCosto());
			}
			return listaBiglietti;
		}
	}
	
	public void inserisciLinkAcquista(TipoLinkAcquista l) {
		if(l != null && l.getPersona() == this) {
			insiemeAcquisti.add(l);
		}
	}
	
	public void eliminaLinkAcquista(TipoLinkAcquista l) {
		if(l != null && l.getPersona() == this) {
			insiemeAcquisti.remove(l);
		}
	}

	@SuppressWarnings("unchecked")
	public Set<TipoLinkAcquista> getLinkAcquista(){
		return (HashSet<TipoLinkAcquista>) insiemeAcquisti.clone();
	}
	
}
