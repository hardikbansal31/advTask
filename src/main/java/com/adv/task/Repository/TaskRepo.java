package com.adv.task.Repository;

import com.adv.task.Entities.Task;
import com.adv.task.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByAssignedTo(User user);
}
