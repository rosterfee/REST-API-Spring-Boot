package ru.itis.javalab.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.javalab.api.dtos.ProjectDTO;
import ru.itis.javalab.api.services.ProjectService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 05.02.2022
 */

@RestController
@RequestMapping("projects")
public class ProjectsController {

    private final ProjectService projectService;

    public ProjectsController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("all")
    @ApiOperation(value = "Get all projects in the system", response = ProjectDTO.class)
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAll());
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Get project by ID", response = ProjectDTO.class)
    @ApiResponse(code = 422, message = "Project with such ID does not exist")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getById(id));
    }

    @PostMapping("create")
    @ApiOperation(value = "Create new project")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Project has been successfully created"),
            @ApiResponse(code = 400, message = "Invalid request body")
    })
    public ResponseEntity<String> createProject(@Valid @RequestBody ProjectDTO projectDTO) {
        projectService.createProject(projectDTO);
        return ResponseEntity.ok("Project has been successfully created");
    }

    @PutMapping("edit")
    @ApiOperation(value = "Edit project")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Project has been successfully edited"),
            @ApiResponse(code = 400, message = "Invalid request body"),
            @ApiResponse(code = 422, message = "Project with such ID does not exist")
    })
    public ResponseEntity<String> editProject(@Valid @RequestBody ProjectDTO projectDTO) {
        projectService.editProject(projectDTO);
        return ResponseEntity.ok("Project information has been successfully changed");
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "delete project by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Project has been successfully edited"),
            @ApiResponse(code = 422, message = "Project with such ID does not exist")
    })
    public ResponseEntity<String> deleteProjectById(@PathVariable Long id) {
        projectService.deleteProjectById(id);
        return ResponseEntity.ok("Project has been successfully deleted");
    }

}
