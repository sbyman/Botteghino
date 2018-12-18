package dominio;

public class ManagerAcquista {
	private TipoLinkAcquista link;
	
	private ManagerAcquista(TipoLinkAcquista link) {
		this.link = link;
	}
	
	public static void inserisci(TipoLinkAcquista link) {
		if(link != null) {
			ManagerAcquista k = new ManagerAcquista(link);
			k.link.getPersona().inserisciPerManagerAcquista(k);
			k.link.getBiglietto().inserisciPerManagerAcquista(k);
		}
	}
	
	public static void elimina(TipoLinkAcquista link) {
		if(link != null) {
			ManagerAcquista k = new ManagerAcquista(link);
			k.link.getPersona().eliminaPerManagerAcquista(k);
			k.link.getBiglietto().eliminaPerManagerAcquista(k);
		}
	}
	
	public TipoLinkAcquista getLink() {
		return link;
	}
}
