package controller;

import business_logic.sensor.ISensor;
import business_logic.sensor.SensorFactory;
import business_logic.sensor.SensorsManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddSensorController {

    @FXML private TextField name;
    @FXML private TextField temp;
    @FXML private TextField frequency;
    @FXML private Label errorMessage;
    @FXML public Button quitButton;
    @FXML public Button addButton;


    public void addSensor(){
        if(name.getText().isEmpty()|| frequency.getText().isEmpty() || temp.getText().isEmpty()){
            errorMessage.setVisible(true);
        }else{
            SensorsManager.getSensors().add(SensorFactory.create(name.getText(),Integer.parseInt(temp.getText()),Integer.parseInt(frequency.getText())));
            quit();
        }
    }

    public void quit() {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }
}
