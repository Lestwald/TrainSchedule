package trainschedule;

import java.util.Map;

public class Train {
    private final String name;
    private final String departureTime;
    private final Map<String, String> stations;

    public Train(String name, String departureTime, Map<String, String> stations) {
        this.name = name;
        this.departureTime = departureTime;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public Map<String, String> getStations() {
        return stations;
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
