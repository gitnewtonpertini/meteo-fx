package meteo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Model {

	private ReteMeteo reteMeteo;
	
	Model(String fileCentraline, Locale locale, int numeroMaxCentraline) {
		reteMeteo = new ReteMeteo(numeroMaxCentraline);
		int numeroCentraline = leggiFileCSV(fileCentraline, locale);
		reteMeteo.setNumeroCentraline(numeroCentraline);	
	}
	
	public int leggiFileCSV(String fileCentraline, Locale locale) {

		// TODO: modificare il ciclo in modo che ad ogni iterazione lo scanner
		// esegua la lettura di  3 token: il primo di tipo Int, i due rimanenti di tipo String
		Scanner scanner = null;
		CentralinaMeteo centralina = null;
		int nRighe = 0;
		try {
			scanner = new Scanner(new File(fileCentraline));
			// scanner.useDelimiter(";");
			scanner.useLocale(locale);
			scanner.useDelimiter("[;\r\n]+");

			while (scanner.hasNext() && nRighe < reteMeteo.getNumeroMaxCentraline()) {
				String id = scanner.next();
				float velocitaVento = scanner.nextFloat();
				int quantitaPioggia = scanner.nextInt();
				float temperatura = scanner.nextFloat();
				centralina = new CentralinaMeteo(id, velocitaVento, quantitaPioggia, temperatura);
				reteMeteo.setCentralina(centralina);
				centralina = null;
				nRighe++;
			}
		} catch (FileNotFoundException e) {
			Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, e);
		} catch (InputMismatchException e) {
			System.out.println("InputMismatchException. Errore nei dati" + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException. Errore nei dati" + e.getStackTrace());
		} finally {
			if (scanner != null) {
				scanner.close();
			}
			return nRighe;
		}
	}
	
	public ReteMeteo getReteMeteo() {
		return this.reteMeteo;
	}
}
