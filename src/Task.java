import java.util.ArrayList;

public class Task {
    private String name;
    private int multipleTimes;
    private String dwm;
    private boolean status; //true means completed, false otherwise
    ArrayList<Integer> indices;
    private int weightage;



    public Task(String name, int times, String dayWeekMonth, int weight){
        this.name = name;
        this.multipleTimes = times;
        this.dwm = dayWeekMonth;
        this.status = false;
        this.indices = new ArrayList<>();
        this.weightage = weight;
    }

    public String getName() {
        return name;
    }

    public void setTaskName(String taskName) {
        this.name = taskName;
    }

    public int getMultipleTimes() {
        return multipleTimes;
    }

    public void setMultipleTimes(int multipleTimes) {
        this.multipleTimes = multipleTimes;
    }

    public String getDwm() {
        return dwm;
    }

    public void setDwm(String dwm) {
        this.dwm = dwm;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus() {
        this.status = !this.status;
    }

    public int getWeightage() {
        return weightage;
    }

    public void setWeightage(int weightage) {
        this.weightage = weightage;
    }
}
