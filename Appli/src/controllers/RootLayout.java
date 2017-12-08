package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import metier.Sensor;
import model.SensorModel;

import static java.awt.SystemColor.window;

public class RootLayout{

    @FXML private ListView<Sensor> sensors;
    @FXML private ChoiceBox displayType;
    @FXML Button button_valid;

    SensorModel data = new SensorModel();
    ObservableList<Sensor> sensorObservableList = data.getSensors();



    public void initialize(){
        sensors.setItems(sensorObservableList);
    }

    public void display(){
        Sensor selectedSensor = sensors.getSelectionModel().getSelectedItem(); //get Sensor
        button_valid.setOnAction(event -> {
            Stage window = new Stage();
            Label random = new Label();
            random.setText(selectedSensor.getSensorName());
            VBox layout = new VBox(10);
            layout.getChildren().add(random);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout, 480, 480);
            window.setScene(scene);
            window.show();
        });
    }
    

 }

