package trainschedule;

import java.util.*;

public class TrainSchedule {
    private final Set<Train> trains;

    public TrainSchedule(Set<Train> trains) {
        this.trains = trains;
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public void removeTrain(String nameOfTrain) {
        trains.removeIf(train -> train.getName().equals(nameOfTrain));
    }

    public void addStation(String nameOfTrain, String nameOfStation, String time) {
        for (Train train : trains)
            if (train.getName().equals(nameOfTrain))
                train.getStations().put(nameOfStation, time);
    }

    public void removeStation(String nameOfTrain, String nameOfStation) {
        for (Train train : trains)
            if (train.getName().equals(nameOfTrain))
                train.getStations().remove(nameOfStation);
    }

    private int timeStrToMinutes(String timeInString) {
        String[] s = timeInString.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    public String nearestTrain(String nameOfStation, String timeInString) {
        int time = timeStrToMinutes(timeInString);
        int minTime = 1440;
        String result = "";
        for (Train train : trains) {
            for (int j = 0; j < train.getStations().size(); j++) {
                if (train.getStations().containsKey(nameOfStation) &&
                        timeStrToMinutes(train.getDepartureTime()) >= time &&
                        timeStrToMinutes(train.getStations().get(nameOfStation)) < minTime) {
                    minTime = timeStrToMinutes(train.getStations().get(nameOfStation));
                    result = train.getName();
                }
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
        return "TrainSchedule{" + trains + '}';
    }
}