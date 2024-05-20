import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        // creating object of TaskList class
        TaskList toDoList = new TaskList();

        int TaskID = 0;


        // Making interactive menu
        while (true) {

            System.out.println("1. Add Task ");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Mark Task as Pending");
            System.out.println("5. Display All Tasks [IDs]");
            System.out.println("6. Display Pending Tasks");
            System.out.println("7. Display Completed Tasks");
            System.out.println("8. Exit");

            System.out.println();
            System.out.print("Choose an option: ");
            int option = Integer.valueOf(reader.nextLine());
            System.out.println();

            if (option == 8) break;

            switch (option) {
                case 1:
                    System.out.print("Enter Task title: ");
                    String title = reader.nextLine();

                    System.out.print("Enter task description: ");
                    String description = reader.nextLine();

                    toDoList.addTask(TaskID + 1, title, description);

                    // Increasing task id
                    TaskID++;
                    break;

                case 2:

                    if (TaskID == 0) {
                        System.out.println("There is no task added to ToDoList!");
                        System.out.println();
                        break;
                    }

                    System.out.print("Enter the id of task to remove: ");

                    int id = Integer.valueOf(reader.nextLine());


                    if (!toDoList.isEmpty()) {

                        toDoList.removeTask(id - 1);
                        System.out.println("Task has been removed!");
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.println("List is empty");
                        System.out.println();
                    }
                    break;


                case 3:
                    System.out.print("Enter the id of task to mark as completed: ");
                    int iD = Integer.valueOf(reader.nextLine());

                    if (TaskID == 0) {
                        System.out.println("There is no task added to ToDoList!");
                        System.out.println();
                        break;
                    }

                    toDoList.markTaskAsCompleted(iD - 1);
                    break;

                case 4:
                    System.out.print("Enter the id of task to mark as pending: ");
                    int Id = Integer.valueOf(reader.nextLine());

                    if (TaskID == 0) {
                        System.out.println("There is no task added to ToDoList!");
                        System.out.println();
                        break;
                    }

                    toDoList.markTaskAsPending(Id - 1);
                    break;

                case 5:
                    // Display all tasks

                    if (TaskID == 0) {
                        System.out.println("There is no task added to ToDoList!");
                        System.out.println();
                        break;
                    }

                    toDoList.displayAllTask();
                    break;

                case 6:
                    // Display pending tasks

                    if (TaskID == 0) {
                        System.out.println("There is no task added to ToDoList!");
                        System.out.println();
                        break;
                    }
                    toDoList.displayPendingTasks();
                    break;

                case 7:
                    // Display completed Task

                    if (TaskID == 0) {
                        System.out.println("There is no task added to ToDoList!");
                        System.out.println();
                        break;
                    }
                    toDoList.displayCompletedTask();
                    break;

                default:
                    System.out.println("Please Input valid option!");
                    System.out.println();
            }

        }

        System.out.println("Program end!");
        reader.close();

    }
}

class Task {

    // Properties
    private int id;
    private String title;
    private String taskDescription;
    private boolean taskStatus;


    // Constructor to set initial value of properties
    Task(int id, String title, String task) {
        this.id = id;
        this.title = title;
        this.taskDescription = task;
    }

    // Setting Status of task
    public void markAsCompleted() {
        this.taskStatus = true;
        System.out.println("Task marked as completed!");
        System.out.println("");
    }

    public void markAsPending() {
        this.taskStatus = false;
        System.out.println("Task mark as pending!");
        System.out.println();
    }

    // Getting status of current task
    public boolean isTaskStatus() {
        return this.taskStatus;
    }


    // Using toString method of object class and override it
    public String toString() {
        return "ID: " + this.id + "\n" + "Title: " + this.title + "\n" + "Description: " + this.taskDescription + "\n" + "Completed: " + this.taskStatus;
    }

} // class end

class TaskList {

    // Properties
    private ArrayList<Task> tasks;

    // Constructor to allocate heap memory to arraylist
    TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(int id, String title, String taskDescription) {
        tasks.add(new Task((id), title, taskDescription));
        System.out.println("Task added successfully!");
        System.out.println();
    }

    public void removeTask(int id) {
        tasks.remove(id);
    }

    public void markTaskAsCompleted(int id) {
        tasks.get(id).markAsCompleted();
    }

    public void markTaskAsPending(int id) {
        tasks.get(id).markAsPending();
    }

    public void displayAllTask() {

        System.out.println("******************");
        for (Task target : tasks) {
            System.out.println(target);
            System.out.println();
        }
        System.out.println("*******************");
    }

    // checking arraylist is empty or not
    public boolean isEmpty() {
        if (tasks.isEmpty()) return true;
        else return false;
    }

    public void displayPendingTasks() {

        boolean isFlag = true;

        for (Task target : tasks) {
            if (!target.isTaskStatus()) {
                System.out.println(target);
                System.out.println();
                System.out.println();
                isFlag = false;
            }
        }
        if (isFlag) {
            System.out.println("You have completed all task!");
            System.out.println();
        }
    }

    public void displayCompletedTask() {

        boolean isFlag = false;

        for (Task target : tasks) {
            if (target.isTaskStatus()) {
                System.out.println(target);
                isFlag = true;
                System.out.println();
                System.out.println();
            }
        }

        if (!isFlag) {
            System.out.println("You do not have completed any tasks!");
            System.out.println();
        }
    }

} // class end



