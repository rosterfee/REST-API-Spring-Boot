package ru.itis.javalab.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.impl.entities.Project;
import ru.itis.javalab.impl.entities.Task;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 05.02.2022
 */

public interface ProjectRepository extends JpaRepository<Project, Long> {



}
