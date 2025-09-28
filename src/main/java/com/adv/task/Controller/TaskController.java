package com.adv.task.Controller;

import com.adv.task.Entities.Task;
import com.adv.task.Service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public List<Task> getAll() {
        return taskService.listAll();
    }

    @PostMapping("/create")
    public Task create(@RequestBody Task task){
        return taskService.createTask(task);
    }
}
