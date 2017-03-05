package trainschedule;

import java.time.LocalTime;
import java.util.Map;
import java.util.HashMap;

public class Train {
    private final String name;
    private final LocalTime departureTime;
    private final Map<String, LocalTime> stations;

    Train(String name, LocalTime departureTime, Map<String, LocalTime> stations) {
        this.name = name;
        this.departureTime = departureTime;
        this.stations = stations;
    }

    LocalTime getDepartureTime() {
        return this.departureTime;
    }

    boolean isArriveAtTheStation(String nameOfStation) {
        return this.stations.containsKey(nameOfStation);
    }

    LocalTime arrivalTime(String nameOfStation) {
        return this.stations.get(nameOfStation);
    }

    void addStation(String nameOfStation, LocalTime time) {
        stations.put(nameOfStation, time);
    }

    void removeStation(String nameOfStation) {
        stations.remove(nameOfStation);
    }

    Map<String, Train> mapOfTrain() {
        Map<String, Train> mapOfTrain = new HashMap<>();
        mapOfTrain.put(this.name, this);
        return mapOfTrain;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other instanceof Train) {
            Train train = (Train) other;
            return name.equals(train.name) &&
                    departureTime.equals(train.departureTime) &&
                    stations.equals(train.stations);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + departureTime.hashCode();
        result = 31 * result + stations.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Train{" +
                "name='" + name + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", stations=" + stations +
                '}';
    }
}
