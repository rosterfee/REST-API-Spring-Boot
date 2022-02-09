package ru.itis.javalab.api.services;

import ru.itis.javalab.api.dtos.TaskDTO;

import java.util.List;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 07.02.2022
 */

public interface TaskService {

    List<TaskDTO> getAllProjectTasks(Long projectId);

    TaskDTO getTaskById(Long id);

    Long createTask(TaskDTO taskDTO, Long projectId);

    void deleteTaskById(Long id);

    void editTask(TaskDTO taskDTO);

}
