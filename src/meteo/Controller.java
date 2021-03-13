package meteo;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Controller {

    Model model;
    
    public void setModel(Model model) {
    	this.model = model;
    }
	
    @FXML
    private ListView<String> listaStazioni;    
    
	@FXML
    private Label msg;

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        // Le stazioni potrebbero venir caricate qui
    }
    
    @FXML
    void doCaricaStazioni(ActionEvent event) {
    	listaStazioni.setVisible(true);
    	CentralinaMeteo centraline[] = model.getReteMeteo().getCentraline();
    	listaStazioni.getItems().setAll(toArrayList(centraline));
    }

    @FXML
    void doElimina(ActionEvent event) {

    }

    @FXML
    void doInfo(ActionEvent event) {

    }
    
    /**
     * Converte un array di centraline in un ArrayList di stringhe
     * @param centraline[] array di centraline da trasformare in ArrayList
     * @return Lista convertita nel tipo ArrayList 
     */  
    public ArrayList<String> toArrayList(CentralinaMeteo centraline[]) {
    	ArrayList<String> list = new ArrayList<String>();
        for(CentralinaMeteo centralina : centraline) {
        	if (centralina != null)
        		list.add(centralina.toString2());
         }
        return list;
    }
    
}