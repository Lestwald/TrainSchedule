package trainschedule;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

public class TrainScheduleTest {
    private Set<Train> trains = new HashSet<>();
    private Map<String, LocalTime> stations1 = new HashMap<>();
    private Map<String, LocalTime> stations2 = new HashMap<>();
    private Map<String, LocalTime> stations3 = new HashMap<>();

    @Before
    public void setUpTrains() {
        stations1.clear();
        stations1.put("st01", LocalTime.of(11, 27));
        stations1.put("st03", LocalTime.of(12, 48));
        stations1.put("st04", LocalTime.of(14, 40));
        stations1.put("st07", LocalTime.of(17, 15));
        stations1.put("st09", LocalTime.of(20, 32));

        stations2.clear();
        stations2.put("st01", LocalTime.of(13, 20));
        stations2.put("st02", LocalTime.of(15, 19));
        stations2.put("st04", LocalTime.of(16, 36));
        stations2.put("st05", LocalTime.of(19, 31));
        stations2.put("st07", LocalTime.of(20, 25));
        stations2.put("st08", LocalTime.of(21, 18));
        stations2.put("st10", LocalTime.of(22, 50));

        stations3.clear();
        stations3.put("st02", LocalTime.of(15, 37));
        stations3.put("st03", LocalTime.of(16, 10));
        stations3.put("st05", LocalTime.of(18, 23));
        stations3.put("st06", LocalTime.of(20, 5));
        stations3.put("st09", LocalTime.of(21, 18));
        stations3.put("st10", LocalTime.of(23, 40));

        trains.clear();
        trains.add(new Train("train1", LocalTime.of(9, 54), stations1));
        trains.add(new Train("train2", LocalTime.of(12, 36), stations2));
        trains.add(new Train("train3", LocalTime.of(14, 20), stations3));
    }


    @Test
    public void addTrain() throws Exception {
        TrainSchedule schedule = new TrainSchedule(trains);

        schedule.addTrain(new Train("train4", LocalTime.of(10, 23), stations1));
        assertEquals(new Train("train4", LocalTime.of(10, 23), stations1),
                schedule.trains.get("train4"));

        schedule.addTrain(new Train("train5", LocalTime.of(11, 56), stations2));
        assertEquals(new Train("train5", LocalTime.of(11, 56), stations2),
                schedule.trains.get("train5"));

        schedule.addTrain(new Train("train6", LocalTime.of(13, 48), stations3));
        assertEquals(new Train("train6", LocalTime.of(13, 48), stations3),
                schedule.trains.get("train6"));
    }

    @Test
    public void removeTrain() throws Exception {
        TrainSchedule schedule = new TrainSchedule(trains);

        schedule.removeTrain("train1");
        assertFalse(schedule.trains.containsKey("train1"));

        schedule.removeTrain("train2");
        assertFalse(schedule.trains.containsKey("train2"));

        schedule.removeTrain("train3");
        assertFalse(schedule.trains.containsKey("train3"));
    }

    @Test
    public void addStation() throws Exception {
        TrainSchedule schedule = new TrainSchedule(trains);

        schedule.addStation("train1", "st05", LocalTime.of(15, 23));
        assertEquals(LocalTime.of(15, 23), schedule.trains.get("train1").arrivalTime("st05"));

        schedule.addStation("train2", "st09", LocalTime.of(22, 10));
        assertEquals(LocalTime.of(22, 10), schedule.trains.get("train2").arrivalTime("st09"));

        schedule.addStation("train3", "st04", LocalTime.of(17, 48));
        assertEquals(LocalTime.of(17, 48), schedule.trains.get("train3").arrivalTime("st04"));
    }

    @Test
    public void removeStation() throws Exception {
        TrainSchedule schedule = new TrainSchedule(trains);

        schedule.removeStation("train1", "st07");
        assertFalse(schedule.trains.get("train1").doesArriveAtTheStation("st07"));

        schedule.removeStation("train2", "st01");
        assertFalse(schedule.trains.get("train2").doesArriveAtTheStation("st01"));

        schedule.removeStation("train3", "st03");
        assertFalse(schedule.trains.get("train3").doesArriveAtTheStation("st03"));
    }

    @Test
    public void nearestTrain() throws Exception {
        TrainSchedule schedule = new TrainSchedule(trains);

        assertEquals("train3", schedule.nearestTrain("st05", LocalTime.of(13, 20)));
        assertEquals("train2", schedule.nearestTrain("st02", LocalTime.of(11, 45)));
        assertEquals("train1", schedule.nearestTrain("st07", LocalTime.of(9, 36)));
        assertEquals("train2", schedule.nearestTrain("st04", LocalTime.of(11, 12)));
        assertEquals("train1", schedule.nearestTrain("st01", LocalTime.of(8, 0)));
    }
}