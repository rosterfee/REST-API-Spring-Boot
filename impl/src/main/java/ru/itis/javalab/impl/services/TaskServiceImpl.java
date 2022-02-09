package ru.itis.javalab.impl.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.itis.javalab.api.dtos.TaskDTO;
import ru.itis.javalab.api.services.ProjectService;
import ru.itis.javalab.api.services.TaskService;
import ru.itis.javalab.impl.entities.Project;
import ru.itis.javalab.impl.entities.Task;
import ru.itis.javalab.impl.repositories.ProjectRepository;
import ru.itis.javalab.impl.repositories.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 07.02.2022
 */

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskRepository, ProjectRepository projectRepository,
                           ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TaskDTO> getAllProjectTasks(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project with such ID does not exist"));
        //map each task to data transfer object
        return project.getTasks().stream().map(task -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task with such ID does not exist"));
        return modelMapper.map(task, TaskDTO.class);
    }

    @Override
    public Long createTask(TaskDTO taskDTO, Long projectId) {
        Task task = modelMapper.map(taskDTO, Task.class);
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project with such ID does not exist"));
        //add task into the project
        task.setProject(project);
        taskRepository.save(task);
        //save task returning generated id
        return task.getId();
    }

    @Override
    public void deleteTaskById(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else throw new IllegalArgumentException("Task with such ID does not exist");
    }

    @Override
    public void editTask(TaskDTO taskDTO) {
        Long id = taskDTO.getId();
        if (id == null) {
            throw new IllegalArgumentException("Please enter an id");
        }
        //get old task
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task with such ID does not exist"));
        Task taskToSave = modelMapper.map(taskDTO, Task.class);
        //attach project to the new task
        taskToSave.setProject(task.getProject());
        taskRepository.save(taskToSave);
    }

}
