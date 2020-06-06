import java.util.ArrayList;

public class Tracker {
    ArrayList<Task> tasks;

    public Tracker(Calender c){
        this.tasks = c.names;
    }

    public double trackList(ArrayList<Task> tasks){
        double avg;
        int totSum = 0;
        int completeSum = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isStatus()){
                completeSum += tasks.get(i).getWeightage();
            }
            totSum += tasks.get(i).getWeightage();
        }

        avg = (double)(completeSum/totSum) * 100;

        return avg;
    }

}
