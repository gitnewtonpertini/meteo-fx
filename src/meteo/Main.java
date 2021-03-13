package meteo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;

public class Main extends Application {

	/**
	 * Crea il modello e lo assegna al controller
	 * 
	 *
	 */	
    @Override
    public void start(Stage stage) throws Exception {
    	
    	Model model = new Model("centraline_padova.csv", Locale.ITALIAN, 100);
    	Controller controller;
    	
    	// FXMLLoader analizza il file XML e crea (metodo load) gli oggetti corrispondenti 
    	// agli elementi grafici e il Controller definiti/dichiarati nel file XML.
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("meteo.fxml"));
    	// Il metodo load crea effettivamente gli oggetti ed il Controller
        Parent root = loader.load();
    	// Tramite il loader (FMXLoader) è possibile ottenere un riferimento al Controller
    	controller = loader.getController();
    	// Assegno il Mole al Controller
    	controller.setModel(model);
    	
    	stage.setScene(new Scene(root));
    	stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
