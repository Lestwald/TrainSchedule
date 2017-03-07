package trainschedule;

import java.time.LocalTime;
import java.util.Map;

public class Train {
    final String name;
    private final LocalTime departureTime;
    private final Map<String, LocalTime> stations;

    Train(final String name, final LocalTime departureTime, final Map<String, LocalTime> stations) {
        this.name = name;
        this.departureTime = departureTime;
        this.stations = stations;
    }

    LocalTime getDepartureTime() {
        return departureTime;
    }

    boolean doesArriveAtTheStation(final String nameOfStation) {
        return stations.containsKey(nameOfStation);
    }

    LocalTime arrivalTime(final String nameOfStation) {
        return stations.get(nameOfStation);
    }

    void addStation(final String nameOfStation, final LocalTime time) {
        stations.put(nameOfStation, time);
    }

    void removeStation(final String nameOfStation) {
        stations.remove(nameOfStation);
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
