package dominio;

@SuppressWarnings("serial")
public class EccezionePrecondizioni extends Exception {
	private String messaggio;
	
	public EccezionePrecondizioni() {
		this.messaggio = "Si e' verificato un errore";
	}
	
	public EccezionePrecondizioni(String messaggio) {
		this.messaggio = messaggio;
	}
	
	public String toString() {
		return messaggio;
	}
}
