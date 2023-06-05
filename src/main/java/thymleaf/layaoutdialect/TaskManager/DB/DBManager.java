package thymleaf.layaoutdialect.TaskManager.DB;

import thymleaf.layaoutdialect.TaskManager.Model.Task;

import java.util.ArrayList;

public class DBManager {
  private static final ArrayList<Task> tasks=new ArrayList<>();
  private static Long id =5L;
  static{
    tasks.add(new Task(1L,"Complete the task 7 from Spring Boot till the end of the lesson",
        "24.06.2023","asdf",true));
    tasks.add(new Task(2L,"Clear home and buy foods",
        "25.10.2020","sdf",false));
    tasks.add(new Task(3L,"Complete all tasks at the weekend",
        "05.06.2023","ffds",false));
    tasks.add(new Task(4L,"Develop simple project on Spring Boot",
        "04.05.2023","dffd",true));
  }
  public static ArrayList<Task> getTasks(){
    return tasks;
  }
  public static void addTask(Task task){
    task.setId(id);
    id++;
    tasks.add(task);
  }
  public static  Task getAllTask(int id){
    return tasks.stream().filter(task -> task.getId()==id).findFirst().orElse(null);
  }
  public static void  deleteTask(int id){
    for(int i=0;i< tasks.size();i++){
      if(tasks.get(i).getId()==id){
        tasks.remove(i);
        break;
      }
    }
  }
  public static void updateTask(Task task) {
    for(int i=0;i<tasks.size();i++){
      if(tasks.get(i).getId()==task.getId()){
        tasks.set(i,task);
        break;
      }
    }
  }
}
