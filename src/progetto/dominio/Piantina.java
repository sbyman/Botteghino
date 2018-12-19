package dominio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Piantina {
	private static HashMap<Posto, Boolean> listaPosti = new HashMap<Posto, Boolean>();
	
	public static boolean aggiungiPosto(Posto p) {
		if (!listaPosti.containsKey(p)){
			listaPosti.put(p, !p.isOccupato());
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean aggiornaPosto(Posto p) throws EccezionePrecondizioni {
		if(!listaPosti.containsKey(p)) {
			throw new EccezionePrecondizioni("Il posto specificato non esiste");
		} else {
			listaPosti.replace(p, !p.isOccupato());
			return true;
		}
	}
	
	public static Set<Posto> getPostoDaStato(boolean stato) {
		HashSet<Posto> tmp = new HashSet<Posto>();
		for (HashMap.Entry<Posto, Boolean> entry : listaPosti.entrySet()) {
			if(entry.getValue() == stato) {
				tmp.add(entry.getKey());
			}
		}
		return tmp;
	}
	
	public static Set<Posto> getListaPosti(){
		return listaPosti.keySet();
	}
}
