package trainschedule;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

public class TrainScheduleTest {

    @Test
    public void addTrain() throws Exception {
        HashSet<Train> trains1 = new HashSet<>();
        HashSet<Train> trains2 = new HashSet<>();
        HashSet<Train> trains3 = new HashSet<>();

        HashMap<String, String> stations1 = new HashMap<String, String>();
        stations1.put("st01", "11:27");
        stations1.put("st03", "12:48");
        stations1.put("st04", "14:40");
        stations1.put("st07", "17:15");
        stations1.put("st09", "20:32");
        trains1.add(new Train("train1", "09:54", stations1));

        HashMap<String, String> stations2 = new HashMap<String, String>();
        stations2.put("st01", "13:20");
        stations2.put("st02", "15:19");
        stations2.put("st04", "16:36");
        stations2.put("st05", "19:31");
        stations2.put("st07", "20:25");
        stations2.put("st08", "21:18");
        stations2.put("st10", "22:50");
        trains1.add(new Train("train2", "12:36", stations2));
        trains2.add(new Train("train2", "12:36", stations2));

        HashMap<String, String> stations3 = new HashMap<String, String>();
        stations3.put("st02", "15:37");
        stations3.put("st03", "16:10");
        stations3.put("st05", "18:23");
        stations3.put("st06", "20:05");
        stations3.put("st09", "21:18");
        stations3.put("st10", "23:40");
        trains1.add(new Train("train3", "14:20", stations3));
        trains2.add(new Train("train3", "14:20", stations3));
        trains3.add(new Train("train3", "14:20", stations3));

        TrainSchedule schedule1 = new TrainSchedule(trains1);
        TrainSchedule schedule2 = new TrainSchedule(trains2);
        TrainSchedule schedule3 = new TrainSchedule(trains3);

        schedule2.addTrain(new Train("train1", "09:54", stations1));
        assertEquals(schedule1, schedule2);

        schedule3.addTrain(new Train("train2", "12:36", stations2));
        schedule3.addTrain(new Train("train1", "09:54", stations1));
        assertEquals(schedule1, schedule3);
    }

    @Test
    public void removeTrain() throws Exception {
        HashSet<Train> trains1 = new HashSet<>();
        HashSet<Train> trains2 = new HashSet<>();
        HashSet<Train> trains3 = new HashSet<>();

        HashMap<String, String> stations1 = new HashMap<String, String>();
        stations1.put("st01", "11:27");
        stations1.put("st03", "12:48");
        stations1.put("st04", "14:40");
        stations1.put("st07", "17:15");
        stations1.put("st09", "20:32");
        trains1.add(new Train("train1", "09:54", stations1));
        trains2.add(new Train("train1", "09:54", stations1));
        trains3.add(new Train("train1", "09:54", stations1));

        HashMap<String, String> stations2 = new HashMap<String, String>();
        stations2.put("st01", "13:20");
        stations2.put("st02", "15:19");
        stations2.put("st04", "16:36");
        stations2.put("st05", "19:31");
        stations2.put("st07", "20:25");
        stations2.put("st08", "21:18");
        stations2.put("st10", "22:50");
        trains1.add(new Train("train2", "12:36", stations2));

        HashMap<String, String> stations3 = new HashMap<String, String>();
        stations3.put("st02", "15:37");
        stations3.put("st03", "16:10");
        stations3.put("st05", "18:23");
        stations3.put("st06", "20:05");
        stations3.put("st09", "21:18");
        stations3.put("st10", "23:40");
        trains1.add(new Train("train3", "14:20", stations3));
        trains2.add(new Train("train3", "14:20", stations3));

        TrainSchedule schedule1 = new TrainSchedule(trains1);
        TrainSchedule schedule2 = new TrainSchedule(trains2);
        TrainSchedule schedule3 = new TrainSchedule(trains3);

        schedule2.removeTrain("train3");
        assertEquals(schedule3, schedule2);

        schedule1.removeTrain("train2");
        schedule1.removeTrain("train3");
        assertEquals(schedule3, schedule1);
    }

    @Test
    public void addStation() throws Exception {
        HashSet<Train> trains1 = new HashSet<>();
        HashSet<Train> trains2 = new HashSet<>();
        HashSet<Train> trains3 = new HashSet<>();

        HashMap<String, String> stations1_1 = new HashMap<String, String>();
        stations1_1.put("st01", "11:27");
        stations1_1.put("st03", "12:48");
        stations1_1.put("st04", "14:40");
        stations1_1.put("st07", "17:15");
        stations1_1.put("st09", "20:32");
        trains1.add(new Train("train1", "09:54", stations1_1));

        HashMap<String, String> stations1_2 = new HashMap<String, String>();
        stations1_2.put("st01", "11:27");
        stations1_2.put("st03", "12:48");
        stations1_2.put("st07", "17:15");
        stations1_2.put("st09", "20:32");
        trains2.add(new Train("train1", "09:54", stations1_2));

        HashMap<String, String> stations1_3 = new HashMap<String, String>();
        stations1_3.put("st03", "12:48");
        stations1_3.put("st04", "14:40");
        stations1_3.put("st09", "20:32");
        trains3.add(new Train("train1", "09:54", stations1_3));

        HashMap<String, String> stations2_1 = new HashMap<String, String>();
        stations2_1.put("st01", "13:20");
        stations2_1.put("st02", "15:19");
        stations2_1.put("st04", "16:36");
        stations2_1.put("st05", "19:31");
        stations2_1.put("st07", "20:25");
        stations2_1.put("st08", "21:18");
        stations2_1.put("st10", "22:50");
        trains1.add(new Train("train2", "12:36", stations2_1));

        HashMap<String, String> stations2_2 = new HashMap<String, String>();
        stations2_2.put("st02", "15:19");
        stations2_2.put("st04", "16:36");
        stations2_2.put("st05", "19:31");
        stations2_2.put("st08", "21:18");
        stations2_2.put("st10", "22:50");
        trains2.add(new Train("train2", "12:36", stations2_2));

        HashMap<String, String> stations2_3 = new HashMap<String, String>();
        stations2_3.put("st01", "13:20");
        stations2_3.put("st04", "16:36");
        stations2_3.put("st05", "19:31");
        stations2_3.put("st07", "20:25");
        stations2_3.put("st10", "22:50");
        trains3.add(new Train("train2", "12:36", stations2_3));

        HashMap<String, String> stations3_1 = new HashMap<String, String>();
        stations3_1.put("st02", "15:37");
        stations3_1.put("st03", "16:10");
        stations3_1.put("st05", "18:23");
        stations3_1.put("st06", "20:05");
        stations3_1.put("st09", "21:18");
        stations3_1.put("st10", "23:40");
        trains1.add(new Train("train3", "14:20", stations3_1));

        HashMap<String, String> stations3_2 = new HashMap<String, String>();
        stations3_2.put("st02", "15:37");
        stations3_2.put("st03", "16:10");
        stations3_2.put("st05", "18:23");
        stations3_2.put("st06", "20:05");
        stations3_2.put("st10", "23:40");
        trains2.add(new Train("train3", "14:20", stations3_2));

        HashMap<String, String> stations3_3 = new HashMap<String, String>();
        stations3_3.put("st02", "15:37");
        stations3_3.put("st03", "16:10");
        stations3_3.put("st05", "18:23");
        stations3_3.put("st09", "21:18");
        stations3_3.put("st10", "23:40");
        trains3.add(new Train("train3", "14:20", stations3_3));

        TrainSchedule schedule1 = new TrainSchedule(trains1);
        TrainSchedule schedule2 = new TrainSchedule(trains2);
        TrainSchedule schedule3 = new TrainSchedule(trains3);

        schedule2.addStation("train1", "st04", "14:40");
        schedule2.addStation("train2", "st01", "13:20");
        schedule2.addStation("train2", "st07", "20:25");
        schedule2.addStation("train3", "st09", "21:18");
        assertEquals(schedule1, schedule2);

        schedule3.addStation("train3", "st06", "20:05");
        schedule3.addStation("train2", "st02", "15:19");
        schedule3.addStation("train2", "st08", "21:18");
        schedule3.addStation("train1", "st01", "11:27");
        schedule3.addStation("train1", "st07", "17:15");
        assertEquals(schedule1, schedule3);
    }

    @Test
    public void removeStation() throws Exception {
        HashSet<Train> trains1 = new HashSet<>();
        HashSet<Train> trains2 = new HashSet<>();
        HashSet<Train> trains3 = new HashSet<>();

        HashMap<String, String> stations1_1 = new HashMap<String, String>();
        stations1_1.put("st01", "11:27");
        stations1_1.put("st03", "12:48");
        stations1_1.put("st04", "14:40");
        stations1_1.put("st07", "17:15");
        stations1_1.put("st09", "20:32");
        trains1.add(new Train("train1", "09:54", stations1_1));

        HashMap<String, String> stations1_2 = new HashMap<String, String>();
        stations1_2.put("st01", "11:27");
        stations1_2.put("st03", "12:48");
        stations1_2.put("st07", "17:15");
        stations1_2.put("st09", "20:32");
        trains2.add(new Train("train1", "09:54", stations1_2));

        HashMap<String, String> stations1_3 = new HashMap<String, String>();
        stations1_3.put("st03", "12:48");
        stations1_3.put("st07", "17:15");
        stations1_3.put("st09", "20:32");
        trains3.add(new Train("train1", "09:54", stations1_3));

        HashMap<String, String> stations2_1 = new HashMap<String, String>();
        stations2_1.put("st01", "13:20");
        stations2_1.put("st02", "15:19");
        stations2_1.put("st04", "16:36");
        stations2_1.put("st05", "19:31");
        stations2_1.put("st07", "20:25");
        stations2_1.put("st10", "22:50");
        trains1.add(new Train("train2", "12:36", stations2_1));

        HashMap<String, String> stations2_2 = new HashMap<String, String>();
        stations2_2.put("st01", "13:20");
        stations2_2.put("st02", "15:19");
        stations2_2.put("st04", "16:36");
        stations2_2.put("st05", "19:31");
        stations2_2.put("st08", "21:18");
        stations2_2.put("st10", "22:50");
        trains2.add(new Train("train2", "12:36", stations2_2));

        HashMap<String, String> stations2_3 = new HashMap<String, String>();
        stations2_3.put("st02", "15:19");
        stations2_3.put("st04", "16:36");
        stations2_3.put("st05", "19:31");
        stations2_3.put("st10", "22:50");
        trains3.add(new Train("train2", "12:36", stations2_3));

        HashMap<String, String> stations3_1 = new HashMap<String, String>();
        stations3_1.put("st03", "16:10");
        stations3_1.put("st05", "18:23");
        stations3_1.put("st06", "20:05");
        stations3_1.put("st09", "21:18");
        stations3_1.put("st10", "23:40");
        trains1.add(new Train("train3", "14:20", stations3_1));

        HashMap<String, String> stations3_2 = new HashMap<String, String>();
        stations3_2.put("st02", "15:37");
        stations3_2.put("st03", "16:10");
        stations3_2.put("st05", "18:23");
        stations3_2.put("st06", "20:05");
        stations3_2.put("st10", "23:40");
        trains2.add(new Train("train3", "14:20", stations3_2));

        HashMap<String, String> stations3_3 = new HashMap<String, String>();
        stations3_3.put("st03", "16:10");
        stations3_3.put("st05", "18:23");
        stations3_3.put("st06", "20:05");
        stations3_3.put("st10", "23:40");
        trains3.add(new Train("train3", "14:20", stations3_3));

        TrainSchedule schedule1 = new TrainSchedule(trains1);
        TrainSchedule schedule2 = new TrainSchedule(trains2);
        TrainSchedule schedule3 = new TrainSchedule(trains3);

        schedule2.removeStation("train1", "st01");
        schedule2.removeStation("train2", "st01");
        schedule2.removeStation("train2", "st08");
        schedule2.removeStation("train3", "st02");
        assertEquals(schedule3, schedule2);

        schedule1.removeStation("train1", "st01");
        schedule1.removeStation("train1", "st04");
        schedule1.removeStation("train2", "st01");
        schedule1.removeStation("train2", "st07");
        schedule1.removeStation("train3", "st09");
        assertEquals(schedule3, schedule1);
    }

    @Test
    public void nearestTrain() throws Exception {
        HashSet<Train> trains = new HashSet<>();

        HashMap<String, String> stations1 = new HashMap<String, String>();
        stations1.put("st01", "11:27");
        stations1.put("st03", "12:48");
        stations1.put("st04", "14:40");
        stations1.put("st07", "17:15");
        stations1.put("st09", "20:32");
        trains.add(new Train("train1", "09:54", stations1));

        HashMap<String, String> stations2 = new HashMap<String, String>();
        stations2.put("st01", "13:20");
        stations2.put("st02", "15:19");
        stations2.put("st04", "16:36");
        stations2.put("st05", "19:31");
        stations2.put("st07", "20:25");
        stations2.put("st08", "21:18");
        stations2.put("st10", "22:50");
        trains.add(new Train("train2", "12:36", stations2));

        HashMap<String, String> stations3 = new HashMap<String, String>();
        stations3.put("st02", "15:37");
        stations3.put("st03", "16:10");
        stations3.put("st05", "18:23");
        stations3.put("st06", "20:05");
        stations3.put("st09", "21:18");
        stations3.put("st10", "23:40");
        trains.add(new Train("train3", "14:20", stations3));

        TrainSchedule schedule = new TrainSchedule(trains);

        assertEquals("train3", schedule.nearestTrain("st05", "13:20"));
        assertEquals("train2", schedule.nearestTrain("st02", "11:45"));
        assertEquals("train1", schedule.nearestTrain("st07", "09:36"));
        assertEquals("train2", schedule.nearestTrain("st04", "11:12"));
        assertEquals("train1", schedule.nearestTrain("st01", "08:00"));
    }
}