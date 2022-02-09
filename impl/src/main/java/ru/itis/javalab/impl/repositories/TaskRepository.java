package ru.itis.javalab.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.impl.entities.Task;

import java.util.List;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 06.02.2022
 */

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> getAllByProjectId(Long id);

}
