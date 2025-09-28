package com.adv.task.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String assignedBy;

    private String deadline = "30 days";

    private String status = "Not Started Yet";

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User assignedTo;
}
