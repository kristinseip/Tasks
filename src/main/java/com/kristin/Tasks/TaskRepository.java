package com.kristin.Tasks;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class TaskRepository {

    ArrayList<User> lists;

    public TaskRepository(){
        lists = new ArrayList<>();
        lists = taskGenerator();
        for (User task: lists){
            System.out.println("\nNamn: " + task.getName() + "\nE-post: " + task.getEmail() + "\nTask: " + task.getTasks());
        }
    }

        public ArrayList<User> getLists() {
            return lists;
        }

        public void addList(User taskList) {
            lists.add(taskList);
        }


        public ArrayList<User> taskGenerator() {

            //Arrays of names and possible wishes
            String[] names = new String[]{"Ida", "Emelie", "Jonas", "Kristin", "Helga"};
            String[] taskArr = new String[]{"Tömma diskmaskinen", "Dammsuga", "Tvätta", "Laga middag", "Städa rummet", "Klippa gräsmattan", "Vattna blommor", "Diska"};

            // List of numbers used to generate tasklists
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < taskArr.length; i++) {
                numbers.add(i);
            }
            for (int i = 0; i < names.length; i++) {
                ArrayList<String> tasks = new ArrayList<>();     // List to store wishes
                Collections.shuffle(numbers);   // Shuffle numbers to pick random tasks for each user

                User user = new User(names[i], names[i].toLowerCase() + "@epost.se");

                for (int j = 0; j < 5; j++) {
                    Tasks task = new Tasks();
                    task.setUser(user);
                    task.setTask(taskArr[numbers.get(j)]);
                    user.addTask(task);

                    tasks.add(taskArr[numbers.get(j)]); // Get task at (random) number and add to list
                }
                lists.add(user);    // Create object and add to lists array
            }

            return lists;
    }
  /*  public User getTaskList(String email) {
        for (User task : lists) {
            if (Objects.equals(task.getEmail(), email)) {
                return task;
            }
        }
        return null;
    }*/
}
