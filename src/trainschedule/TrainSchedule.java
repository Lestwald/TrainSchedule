package trainschedule;

import java.time.LocalTime;
import java.util.*;

public class TrainSchedule {
    final Map<String, Train> trains = new HashMap<>();

    public TrainSchedule(Set<Train> trains) {
        for (Train train : trains) {
            this.trains.putAll(train.mapOfTrain());
        }
    }

    public void addTrain(Train train) {
        trains.putAll(train.mapOfTrain());
    }

    public void removeTrain(String nameOfTrain) {
        trains.remove(nameOfTrain);
    }

    public void addStation(String nameOfTrain, String nameOfStation, LocalTime time) {
        trains.get(nameOfTrain).addStation(nameOfStation, time);
    }

    public void removeStation(String nameOfTrain, String nameOfStation) {
        trains.get(nameOfTrain).removeStation(nameOfStation);
    }

    public String nearestTrain(String nameOfStation, LocalTime currentTime) {
        LocalTime minTime = LocalTime.MAX;
        String result = "";
        for (Map.Entry<String, Train> entry : trains.entrySet()) {
            Train train = entry.getValue();
            if (train.isArriveAtTheStation(nameOfStation) &&
                    train.getDepartureTime().isAfter(currentTime) &&
                    train.arrivalTime(nameOfStation).isBefore(minTime)) {
                minTime = train.arrivalTime(nameOfStation);
                result = entry.getKey();
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other instanceof TrainSchedule) {
            TrainSchedule schedule = (TrainSchedule) other;
            return trains.equals(schedule.trains);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return trains.hashCode();
    }

    @Override
    public String toString() {
        return "TrainSchedule{" + trains.values() + '}';
    }
}