package dominio;

@SuppressWarnings("serial")
public class EccezioneMolteplicita extends Exception {
	private String messaggio;
	
	public EccezioneMolteplicita() {
		this.messaggio = "Errore di molteplicita'";
	}
	
	public EccezioneMolteplicita(String m) {
		this.messaggio = m;
	}
	
	public String toString() {
		return messaggio;
	}
}
