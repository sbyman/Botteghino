package dominio;

public class ManagerPossiede {
	private TipoLinkPossiede link;
	
	private ManagerPossiede(TipoLinkPossiede l) {
		this.link = l;
	}
	
	public TipoLinkPossiede getLink() {
		return link;
	}
	
	public static void inserisci(TipoLinkPossiede l) {
		if(l != null) {
			ManagerPossiede k = new ManagerPossiede(l);
			k.link.getBiglietto().inserisciPerManagerPossiede(k);
			k.link.getSpettatore().inserisciPerManagerPossiede(k);
		}
	}
	
	public static void elimina(TipoLinkPossiede l) {
		if(l != null) {
			ManagerPossiede k = new ManagerPossiede(l);
			k.link.getBiglietto().eliminaPerManagerPossiede(k);
			k.link.getSpettatore().eliminaPerManagerPossiede(k);
		}
	}

}
