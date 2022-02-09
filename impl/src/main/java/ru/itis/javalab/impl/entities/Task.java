package ru.itis.javalab.impl.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.api.enums.TaskStatus;

import javax.persistence.*;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 05.02.2022
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus taskStatus;

    private String description;

    private int priority;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

}
