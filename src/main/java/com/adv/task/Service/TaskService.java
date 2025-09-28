package com.adv.task.Service;

import com.adv.task.Entities.Task;
import com.adv.task.Repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    public List<Task> listAll() {
        return taskRepo.findAll();
    }
}
