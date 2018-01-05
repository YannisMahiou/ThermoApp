package persistence.stub;

import metier.ISensors;
import metier.SensorsFactory;
import metier.DataManager;

import java.util.ArrayList;
import java.util.List;

public class StubDataManager implements DataManager {

    @Override
    public List<ISensors> loadSensors(){
        List<ISensors> sensors = new ArrayList<ISensors>();
        sensors.add(SensorsFactory.sensorFactory("Bureau", 20, 1));
        sensors.add(SensorsFactory.sensorFactory("Salon", 25, 4));
        sensors.add(SensorsFactory.sensorFactory("Cuisine", 28, 12));
        return sensors;
    }

    @Override
    public void writeSensors(List<ISensors> sensors){
        throw new UnsupportedOperationException("Not Supported Yet");
    }
}