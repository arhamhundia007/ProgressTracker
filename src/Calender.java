import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Calender {

    ArrayList<Task>[] task;
    ArrayList<Task> names;
    Scanner s = new Scanner(System.in);

    public Calender(String dwm){
        this.names = new ArrayList<>();
        if (dwm.equalsIgnoreCase("daily")){
            this.task = new ArrayList[24];
        } else if (dwm.equalsIgnoreCase("weekly")){
            this.task = new ArrayList[7];
        } else if (dwm.equalsIgnoreCase("monthly")){
            System.out.println("For which month you wanna add the task?");
            String month;
            month = s.nextLine();
            month = month.toLowerCase();
            switch (month){
                case "january": {
                    this.task = new ArrayList[31];
                }
                case "february": {
                    this.task = new ArrayList[28];
                }

                case "march": {
                    this.task = new ArrayList[31];
                }

                case "april": {
                    this.task = new ArrayList[30];
                }

                case "may": {
                    this.task = new ArrayList[31];
                }

                case "june": {
                    this.task = new ArrayList[30];
                }

                case "july": {
                    this.task = new ArrayList[31];
                }

                case "august": {
                    this.task = new ArrayList[31];
                }

                case "september": {
                    this.task = new ArrayList[30];
                }

                case "october": {
                    this.task = new ArrayList[31];
                }

                case "november": {
                    this.task = new ArrayList[30];
                }

                case "december": {
                    this.task = new ArrayList[31];
                }
            }
        }

        for (int i = 0; i < task.length; i++) {
            task[i] = new ArrayList<Task>();
        }
    }

    public void addTask(Task toAdd){
        if (toAdd == null){
            return;
        }
        int num = task.length - 1;
        for (int i = 0; i < toAdd.getMultipleTimes(); i++) {
            System.out.printf("Type a number corresponding from 0(First instance) to %d(Last instance) corresponding to %s where you would like to add your task: ", num, toAdd.getDwm());
            int index = s.nextInt();
            task[index].add(toAdd);
            toAdd.indices.add(index);
        }

        if(isNameFound(toAdd.getName()) == -1){
            names.add(toAdd);
        }
    }

    public int removeTask(Task toRemove){
        if (toRemove == null){
            return -1;
        } else if(isNameFound(toRemove.getName()) == -1){
            return -1;
        }

        int num = task.length - 1;
        System.out.printf("Type a number corresponding from 0(First instance) to %d(Last instance) corresponding to %s from where you want to delete the task: ", num, toRemove.getDwm());
        int index = s.nextInt();

        int indicesIndex = isFound(toRemove, index);

        if (indicesIndex == -1){
            return -1;
        }

        int taskIndex = isFoundInTask(toRemove, index);
        task[index].remove(taskIndex);
        toRemove.indices.remove(indicesIndex);
        toRemove.setMultipleTimes(toRemove.getMultipleTimes() - 1);

        if (toRemove.getMultipleTimes() == 0){
            deleteAllTasks(toRemove);
        }

        return toRemove.getMultipleTimes();

    }

    public void deleteAllTasks(Task toDelete){
        while(!toDelete.indices.isEmpty()){
            int index1 = toDelete.indices.get(0);
            int index2 = isFoundInTask(toDelete, index1);
            task[index1].remove(index2);
            toDelete.indices.remove(0);
        }

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).getName().equals(toDelete.getName())){
                names.remove(i);
                return;
            }
        }
    }

    public int isFound(Task toFind, int index){
        for (int i = 0; i < toFind.indices.size(); i++) {
            if (toFind.indices.get(i) == index){
                return i;
            }
        }

        return -1;
    }

    public int isFoundInTask(Task toFind, int index){
        for (int i = 0; i < task[index].size(); i++) {
            if (toFind.getName().equals(task[index].get(i).getName())){
                return i;
            }
        }
        return -1;

    }

    public int isNameFound(String name){
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).getName().equals(name)){
                return i;
            }
        }

        return -1;
    }
}



