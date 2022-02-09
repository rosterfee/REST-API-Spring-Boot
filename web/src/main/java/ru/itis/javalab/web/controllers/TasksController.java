package ru.itis.javalab.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.javalab.api.dtos.TaskDTO;
import ru.itis.javalab.api.services.TaskService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 05.02.2022
 */

@RestController
@RequestMapping("tasks")
public class TasksController {

    private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("all/{project_id}")
    @ApiOperation(value = "Get all project tasks", response = TaskDTO.class)
    @ApiResponse(code = 422, message = "Project with such ID does not exist")
    public ResponseEntity<List<TaskDTO>> getAllProjectTasks(
            @PathVariable("project_id") Long projectId) {
        return ResponseEntity.ok(taskService.getAllProjectTasks(projectId));
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Get task by ID", response = TaskDTO.class)
    @ApiResponse(code = 422, message = "Task with such ID does not exist")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping("create/{projectId}")
    @ApiOperation(value = "Create new task")
    @ApiResponses({
            @ApiResponse(code = 400, message = "Invalid request body"),
            @ApiResponse(code = 422, message = "Project with such ID does not exist")
    })
    public ResponseEntity<String> createTask(@Valid @RequestBody TaskDTO taskDTO,
                                             @PathVariable("projectId") Long projectId) {
        taskService.createTask(taskDTO, projectId);
        return ResponseEntity.ok("Task has been successfully created");
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "Delete task by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Task has been successfully deleted"),
            @ApiResponse(code = 422, message = "Task with such ID does not exist")
    })
    public ResponseEntity<String> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.ok("Task has been successfully deleted");
    }

    @PutMapping("edit/{id}")
    @ApiOperation(value = "Edit task")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Task has been successfully deleted"),
            @ApiResponse(code = 400, message = "Invalid request body"),
            @ApiResponse(code = 422, message = "Task with such ID does not exist")
    })
    public ResponseEntity<String> editTaskById(@Valid @RequestBody TaskDTO taskDTO) {
        taskService.editTask(taskDTO);
        return ResponseEntity.ok("Task has been successfully edited");
    }

}
