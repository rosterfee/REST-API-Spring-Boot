package ru.itis.javalab.impl.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.api.enums.ProjectStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 05.02.2022
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Date startDate;

    private Date completionDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectStatus projectStatus;

    private int priority;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

}
