package trainschedule;

import java.time.LocalTime;
import java.util.*;

public class TrainSchedule {
    final Map<String, Train> trains = new HashMap<>();

    public TrainSchedule(final Set<Train> trains) {
        for (Train train : trains) {
            this.trains.put(train.name, train);
        }
    }

    public void addTrain(final Train train) {
        trains.put(train.name, train);
    }

    public void removeTrain(final String nameOfTrain) {
        trains.remove(nameOfTrain);
    }

    public void addStation(final String nameOfTrain, final String nameOfStation, final LocalTime time) {
        trains.get(nameOfTrain).addStation(nameOfStation, time);
    }

    public void removeStation(final String nameOfTrain, final String nameOfStation) {
        trains.get(nameOfTrain).removeStation(nameOfStation);
    }

    public String nearestTrain(final String nameOfStation, final LocalTime currentTime) {
        LocalTime minTime = LocalTime.MAX;
        String result = "";
        for (final Map.Entry<String, Train> entry : trains.entrySet()) {
            Train train = entry.getValue();
            if (train.doesArriveAtTheStation(nameOfStation) &&
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