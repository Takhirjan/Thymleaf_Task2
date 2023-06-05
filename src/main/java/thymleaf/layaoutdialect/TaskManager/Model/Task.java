package thymleaf.layaoutdialect.TaskManager.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
  Long id;
  String name;
  String deadlineDate;
  String description;
  boolean isCompleted;
}
