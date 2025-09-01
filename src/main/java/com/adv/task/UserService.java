package com.adv.task;

import com.adv.task.Entities.User;
import com.adv.task.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        if (userRepo.existsByUsername(user.getUsername())) throw new RuntimeException("user already exists");
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepo.findById(id)
                .map(user -> {
                    if (updatedUser.getUsername() != null) {
                        user.setUsername(updatedUser.getUsername());
                    }
                    if (updatedUser.getPass() != null) {
                        user.setPass(updatedUser.getPass());
                    }
                    if (updatedUser.getRole() != null) {
                        user.setRole(updatedUser.getRole());
                    }
                    return userRepo.save(user);
                })
                .orElseThrow(() -> new RuntimeException("could not update user"));
    }

    public void deleteUser(Long id) {
        if (!userRepo.existsById(id)) throw new RuntimeException("user not found");
        userRepo.deleteById(id);
    }
}
