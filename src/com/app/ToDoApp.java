
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class ToDoApp {
    private static final String FILE_NAME = "task.txt";
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        loadTasks();
        Scanner sc = new Scanner(System.in);


// what we task to do  all List here.
        while(true){
            System.out.println("\nTo-Do-List");
            System.out.println("1. Add Task");
            System.out.println("2. view Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.println("choose an option");

//            Take input by user
            int choice= sc.nextInt();
            sc.nextLine();

// using swtich case to perform a task
            switch(choice){
                case 1:
                    System.out.println("Enter task :");
                    String task = sc.nextLine();
                    tasks.add(task);
                    saveTasks();
                    System.out.println("Task added successfully");
                    break;

                case 2: viewTasks();
                break;

                case 3: viewTasks();
                    System.out.println("Enter task number to remove :");
                    int index = sc.nextInt();
                    if (index>0 && index<= tasks.size()){
                        tasks.remove(index-1);
                        saveTasks();
                        System.out.println("Task removed successfully");

                    } else {
                        System.out.println("invaliod task number");
                    }
                    break;

                case 4:
                    System.out.println("Exitimg .... Good Bye");
                    sc.close();
                    return;

                default :
                    System.out.println("invaild choice. Please try again");
            }
        }
    }
  
  // For visiting the all task 
    private static void viewTasks(){
        if(tasks.isEmpty()){
            System.out.println("no tasks available");
        } else {
            System.out.println("Your tasks :");
            for(int i=0; i<tasks.size();i++){
                System.out.println((i+1) + "." + tasks.get(i));
            }
        }
    }
  
  //  To save the task 
    private static void saveTasks(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            for(String task : tasks){
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e){
            System.out.println("Error saving tasks : " + e.getMessage());
        }
    }
  
  //  For adding the new task
    private static void loadTasks(){
        File file = new File(FILE_NAME);
        if(file.exists()){
            try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
                String line ;
                while((line = reader.readLine())!= null){
                    tasks.add(line);
                }
            } catch (IOException e){
                System.out.println("Error loading tasks : " + e.getMessage());
            }
        }
    }
}


