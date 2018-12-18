package dominio;

public class ManagerSiede {
	private TipoLinkSiede link;
	
	private ManagerSiede(TipoLinkSiede l) {
		this.link = l;
	}
	
	public TipoLinkSiede getLink() {
		return link;
	}
	
	public static void inserisci(TipoLinkSiede l) {
		if(l != null) {
			ManagerSiede k = new ManagerSiede(l);
			k.link.getPosto().inserisciPerManagerSiede(k);
			k.link.getSpettatore().inserisciPerManagerSiede(k);
		}
	}
	
	public static void elimina(TipoLinkSiede l) {
		if(l != null) {
			ManagerSiede k = new ManagerSiede(l);
			k.link.getPosto().eliminaPerManagerSiede(k);
			k.link.getSpettatore().eliminaPerManagerSiede(k);
		}
	}

}
