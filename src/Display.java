import java.util.Scanner;

public class Display {
    int option;
    public static Scanner scanner;
    Calender calender;

    public Display(Calender c){
        scanner = new Scanner(System.in);
        this.calender = c;
    }

    public void mainMenu(){
        System.out.println("-------------------- Welcome to your personalized progress tracker! --------------------");
        System.out.println();
        System.out.print("What would you like to do today?(Type the option's corresponding number)\n1) Display\n2) Edit\n3) Add\n4) Exit\n");

        option = scanner.nextInt();
        scanner.nextLine();
        while(option != 4){
            if (option == 1){
                displayMenu();
            } else if (option == 2){
                editMenu();
            } else if (option == 3){
                addMenu();
            } else {
                System.out.println("Please type an acceptable value!(from 1 to 4)");

            }
            System.out.print("What would you like to do today?(Type the option's corresponding number)\n1) Display\n2) Edit\n3) Add\n4) Exit\n");
            option = scanner.nextInt();
        }

        System.out.println("Thank you for using my tracker!!!");
    }

    public void displayMenu(){
        System.out.println();
        System.out.println("Display");
        System.out.print("1) Progress report\n2) Calender\n3) Completed & not-completed task\n4) Task names\n5) Back\n6) Exit\n ");
        int choose;
        choose = scanner.nextInt();
        while (choose < 1 || choose > 6){
            System.out.println("Please type an acceptable value!(from 1 to 6)");
            choose = scanner.nextInt();
        }
        System.out.println();
        if (choose == 1){
            Tracker t = new Tracker(calender);
            double avg = t.trackList(calender.names);
            System.out.printf("You have completed %.2f % of the tasks you have enlisted.", avg);
        } else if (choose == 2){

            for (int i = 0; i < calender.task.length; i++) {
                System.out.printf("%d: ", i + 1);
                for (int j = 0; j < calender.task[i].size(); j++) {
                    System.out.printf("%s |", calender.task[i].get(j).getName());
                }
                System.out.println();
            }
        } else if (choose == 3){
            for (int i = 0; i < calender.names.size(); i++) {
                if (calender.names.get(i).isStatus()){
                    System.out.printf("The task %s is COMPLETED!!\n", calender.names.get(i).getName());
                } else {
                    System.out.printf("The task %s is NOT-COMPLETED!!\n", calender.names.get(i).getName());
                }
            }
        } else if (choose == 4){
            for (int i = 0; i < calender.names.size(); i++) {
                System.out.println(calender.names.get(i).getName());
            }
        } else if (choose == 6){
            option = 4;
        }

    }


    public void editMenu(){
        System.out.println();
        System.out.println("Edit");
        System.out.println("1) Edit a task\n2) Delete Task");
        int choose = scanner.nextInt();
        while(choose < 1 || choose > 2){
            System.out.println("Please type an acceptable value!(from 1 to 6)");
            choose = scanner.nextInt();
        }

        if (choose == 1) {
            System.out.print("1) Task name\n2) Task repetition\n3) Calender type\n4) Task status\n5) Task weight-age\n6) Exit\n");
            int choice;
            choice = scanner.nextInt();

            while (choice < 1 || choice > 6) {
                System.out.println("Please type an acceptable value!(from 1 to 6)");
                choice = scanner.nextInt();

            }

            scanner.nextLine();

            System.out.print("Enter the name of the task you want to edit: ");
            String name = scanner.nextLine();
            if (choice == 1) {
                System.out.print("Enter the name of you want to change into: ");
                String name2 = scanner.nextLine();
                Task t = calender.names.get(calender.isNameFound(name));
                calender.names.get(calender.isNameFound(name)).setTaskName(name2);
                for (int i = 0; i < t.indices.size(); i++) {
                    for (int j = 0; j < calender.task[i].size(); j++) {
                        String naam = calender.task[i].get(j).getName();
                        if (naam.equals(name)) {
                            calender.task[i].get(j).setTaskName(name2);
                        }
                    }
                }
            } else if (choice == 2) {
                System.out.print("Enter the new repetition number: ");
                int rep2 = scanner.nextInt();
                Task t = calender.names.get(calender.isNameFound(name));
                calender.names.get(calender.isNameFound(name)).setMultipleTimes(rep2);
                for (int i = 0; i < t.indices.size(); i++) {
                    for (int j = 0; j < calender.task[i].size(); j++) {
                        String naam = calender.task[i].get(j).getName();
                        if (naam.equals(name)) {
                            calender.task[i].get(j).setMultipleTimes(rep2);
                        }
                    }
                }
            } else if (choice == 3) {
                System.out.print("Enter the new calender type: ");
                String type = scanner.nextLine();
                Task t = calender.names.get(calender.isNameFound(name));
                calender.names.get(calender.isNameFound(name)).setDwm(type);
                for (int i = 0; i < t.indices.size(); i++) {
                    for (int j = 0; j < calender.task[i].size(); j++) {
                        String naam = calender.task[i].get(j).getName();
                        if (naam.equals(name)) {
                            calender.task[i].get(j).setDwm(type);
                        }
                    }
                }
            } else if (choice == 4) {
                Task t = calender.names.get(calender.isNameFound(name));

                for (int i = 0; i < t.indices.size(); i++) {
                    for (int j = 0; j < calender.task[i].size(); j++) {
                        String naam = calender.task[i].get(j).getName();
                        if (naam.equals(name)) {
                            calender.task[i].get(j).setStatus();
                        }
                    }
                }
            } else if (choice == 5) {
                System.out.print("Enter the new weight: ");
                int weight = scanner.nextInt();
                Task t = calender.names.get(calender.isNameFound(name));
                calender.names.get(calender.isNameFound(name)).setWeightage(weight);
                for (int i = 0; i < t.indices.size(); i++) {
                    for (int j = 0; j < calender.task[i].size(); j++) {
                        String naam = calender.task[i].get(j).getName();
                        if (naam.equals(name)) {
                            calender.task[i].get(j).setWeightage(weight);
                        }
                    }
                }
            } else {
                option = 4;
            }
        } else{
            System.out.print("1) Delete one instance\n2) Delete all instances\n3) Exit\n");
            int choice;
            choice = scanner.nextInt();
            while (choice < 1 || choice > 3) {
                System.out.println("Please type an acceptable value!(from 1 to 3)");
                choice = scanner.nextInt();

            }
            scanner.nextLine();
            System.out.print("Enter the name of the task to be removed: ");
            String name = scanner.nextLine();
            Task t = calender.names.get(calender.isNameFound(name));
            if (choice == 1){
                calender.removeTask(t);
            }else if(choice == 2){
                calender.deleteAllTasks(t);
            } else{
                option = 4;
            }
        }
    }

    //Have to complete this
    public void addMenu() {
        System.out.println("\nAdd");
        System.out.println("1) Add task\n2) Exit");
        int choose = scanner.nextInt();
        while (choose < 1 || choose > 2) {
            System.out.println("Please type an acceptable value!(from 1 to 2)");
            choose = scanner.nextInt();
        }
        scanner.nextLine();
        if (choose == 1) {
            System.out.print("Enter name of the task: ");
            String name = scanner.nextLine();
            System.out.print("Enter number of times you wanna repeat the task: ");
            int multiple = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter daily/weekly/monthly: ");
            String dwm = scanner.nextLine();
            System.out.print("Enter weight of the task: ");
            int weight = scanner.nextInt();
            scanner.nextLine();

            Task toAdd = new Task(name, multiple, dwm, weight);
            calender.addTask(toAdd);
        } if (choose == 2){
            option = 4;

        }

    }


}
