package meteo;
/**
* Rete di rilevamento meteo
* @author 4A ITI
* @version 1.0
*/
public class ReteMeteo {

    final String  NOME_RETE = "RETE RILEVAMENTO VENETO";
    private CentralinaMeteo centraline[];
	private int numeroMaxCentraline;
	private int numeroCentraline;

    /**
    * Costruttore dell'array delle centraline: si limita solo alla allocazione (new)
    * della memoria necessaria per memorizzare i valori di ogni oggetto
    * (di tipo CentralinaMeteo) dell'array
    * @param numeroCentraline numero di elementi dell'array
    */  
    public ReteMeteo(int numeroMaxCentraline) {
        // Allocazione nella memoria heap dello spazio necessario per un numeroCentraline
        // di oggetti pari al valore del parametro (numeroCentraline) passato.
        centraline = new CentralinaMeteo[numeroMaxCentraline];
		this.numeroMaxCentraline = numeroMaxCentraline;
		this.numeroCentraline = 0;
    }
    
    /**
    * Riceve come parametro un'oggetto di classe centralina e lo inserisce 
    * nell'array centraline nella posizione passata come parametro
    * @param pos posizione nella quale si vuole inserire l'oggetto CentralinaMeteo
    * @param CentralinaMeteo centralina da inserire nell'array centraline 
    */
    public void setCentralina(int pos, CentralinaMeteo centralina) {
        
        // L'oggetto centralina (quindi gia creato) viene inserito nell'array nella posizione pos (parametro)  
        centraline[pos] = centralina;
        numeroCentraline++;
    }
    
    /**
    * Riceve come parametro un'oggetto di classe centralina e lo inserisce 
    * nell'array centraline nella prima posizione libera (null)
    * @param CentralinaMeteo centralina da inserire nell'array centraline 
    */
    public void setCentralina(CentralinaMeteo centralina) {
        
        // L'oggetto centralina (quindi gia creato) viene inserito nell'array nella posizione pos (parametro)  
		int i = 0;
		// Il ciclo termina quando viene trovato un posto libero (null) oppure
		// si è arrivati alla fine dell'array (i == numeroCentraline)
		// senza aver trovato un posto libero.
		while (centraline[i] != null && i < numeroMaxCentraline)
			i++;
		if (i < numeroMaxCentraline)
			centraline[i] = centralina;
			numeroCentraline++;
    }
    
    /**
    * Crea un'oggetto di classe CentralinaMeteo mediante gli attributi passati come parametri e lo 
    * inserisce nell'array centraline nella posizione passata come parametro 
    * @param pos posizione nella quale si vuole inserire l'oggetto CentralinaMeteo
    * @param String id Identificativo
    * @param float velocitaVento Velocità del vento
    * @param int quantitaPioggia Quantità di pioggia caduta
    * @param float temperatura temperatura rilevata
    */
    public void setCentralina(int pos, String id, float velocitaVento, int quantitaPioggia, float temperatura) {
        
        centraline[pos] = new CentralinaMeteo(id, velocitaVento, quantitaPioggia, temperatura);
        numeroCentraline++;
    }
    
    /**
    * Restituisce la centralina che si trova nella posizione indicata dal parametro "pos"
    * @param pos posizione (indice) nell'array della centralina
    */
    public CentralinaMeteo getCentralina(int pos) {
        
        return centraline[pos];
    }
	
	/**
    * Restituisce la centralina corrispondente all'identificativo passato come parametro (id)
    * della memoria necessaria per memorizzare i valori di ogni oggetto
    * (di tipo CentralinaMeteo) dell'array
    * @param id Identificativo della centralina da ricercare nell'array
    */
    public CentralinaMeteo getCentralina(String id) {
        
		// Modificare il ciclo for oppure utilizzare un ciclo while
		// in modo che non si sia costretti a scorrere tutto l'array
		// nel caso in cui la centralina sia trovata prima che il ciclo
		// sia giunto alla fine
		CentralinaMeteo cent = null;
		boolean trovata = false;
	
        for (int i = 0; i < numeroMaxCentraline; i++)
			if (centraline[i].getId().equals(id)) {
				cent = centraline[i];
				break;
			}

			// ATTENZIONE: restituisce il riferimento, quindi, le modifiche
		// che verranno fatte sull'oggetto restituito verranno fatte anche
		// all'oggetto che si trova sull'array (perche si tratta dello stesso oggetto)
		// Per evirare questo problema si deve restituire una copia creata invocando il
		// costruttore di copia: return CentralinaMeteo(cent);
		return cent;	
    }
    

	/**
    * Restituisce la centralina corrispondente all'identificativo passato come parametro (id)
    * della memoria necessaria per memorizzare i valori di ogni oggetto
    * (di tipo CentralinaMeteo) dell'array
    * @param id Identificativo della centralina da ricercare nell'array
    */
    public CentralinaMeteo getCentralina2(String id) {
        
		// Modificare il ciclo for oppure utilizzare un ciclo while
		// in modo che non si sia costretti a scorrere tutto l'array
		// nel caso in cui la centralina sia trovata prima che il ciclo
		// sia giunto alla fine
		CentralinaMeteo cent = null;
		boolean trovata = false;
	
        for (int i = 0; (i < numeroMaxCentraline && !trovata); i++)
			if (centraline[i].getId().equals(id)) {
				cent = centraline[i];
				trovata = true;
			}
		return cent;	
    }
    
    public int getNumeroMaxCentraline() {
    	return this.numeroMaxCentraline;
    }
    
    public int getNumeroCentraline() {
    	return this.numeroCentraline;
    }

	public void setNumeroCentraline(int numeroCentraline2) {
		this.numeroCentraline = numeroCentraline;	
	}   
	
	public CentralinaMeteo[] getCentraline() {
		return this.centraline;
	}
        
}