package thymleaf.layaoutdialect.TaskManager.Controllers;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thymleaf.layaoutdialect.TaskManager.DB.DBManager;
import thymleaf.layaoutdialect.TaskManager.Model.Task;

import java.util.ArrayList;

@Controller
public class HomeController {
  @GetMapping(value = "/main-page")
  public String mainPage(Model model) {
    ArrayList<Task> tasks = DBManager.getTasks();
    model.addAttribute("tasksy", tasks);
    return "mainpage";
  }

  @PostMapping(value = "/add-task")
    public String addTask(Task task) {
    DBManager.addTask(task);
    return "redirect:/main-page";
  }
  @GetMapping(value = "/details/{taskId}")
  public String taskDetails(@PathVariable(name="taskId")int id,Model model){
  Task task=DBManager.getAllTask(id);
  model.addAttribute("tasky",task);
  return "details";
  }
  @PostMapping(value = "/delete-task")
  public String deleteTask(int id){
    DBManager.deleteTask(id);
    return "redirect:/main-page";
  }
  @PostMapping(value = "/save-task")
  public String editTask(
      @RequestParam(name="id")int id,
      @RequestParam(name = "name") String name,
      @RequestParam(name="description") String description,
      @RequestParam(name="deadlineDate")String deadlineDate,
      @RequestParam(name="isCompleted") boolean isCompleted
  ){
    Task task=DBManager.getAllTask(id);
    task.setName(name);
    task.setDescription(description);
    task.setDeadlineDate(deadlineDate);
    task.setCompleted(isCompleted);
    DBManager.updateTask(task);
    return "redirect:/main-page";
  }
}

