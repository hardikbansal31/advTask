package com.adv.task.Service;

import com.adv.task.Entities.Task;
import com.adv.task.Entities.User;
import com.adv.task.Repository.TaskRepo;
import com.adv.task.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;
    private final UserRepo userRepo;

    public TaskService(TaskRepo taskRepo, UserRepo userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }

    public Task createTask(Task task, String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
        task.setAssignedTo(user);
        return taskRepo.save(task);
    }

    public List<Task> listAll() {
        return taskRepo.findAll();
    }

    public List<Task> listByName(String username){
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
        return taskRepo.findByAssignedTo(user);
    }
}
