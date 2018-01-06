package metier.sensor;


import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.persistence.DataManager;

/**
 * Façade de la partie Metier
 */
public class SensorsManager {

    private static DataManager dataManager;

    private static final ListProperty<ISensors> sensorsCollection = new SimpleListProperty<>();
        public static ObservableList<ISensors> getSensors() { return sensorsCollection.get(); }
        public static void setSensors(ObservableList<ISensors> value){sensorsCollection.set(value);}
        public static ListProperty<ISensors> sensorsProperty(){return sensorsCollection; }

    public static void setDataManager(DataManager dm){ dataManager = dm; }

    /**
     * le manager récupère la collection de capteurs en déléguant cette
     * responsabilité au dataManager
     */
    public static void loadSensors(){
        if(dataManager != null){
            setSensors(FXCollections.observableList(dataManager.loadSensors()));
        }
    }

    /**
     * le manager récupère la collection de capteurs en déléguant cette
     * responsabilité au dataManager
     */
    public static void writeSensors(){
        if(dataManager != null){
            dataManager.writeSensors(getSensors());
        }
    }



}