package ru.itis.javalab.impl.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.itis.javalab.api.dtos.ProjectDTO;
import ru.itis.javalab.api.services.ProjectService;
import ru.itis.javalab.impl.entities.Project;
import ru.itis.javalab.impl.repositories.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 05.02.2022
 */

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProjectDTO> getAll() {
        List<Project> projects = projectRepository.findAll();
        //map all projects to data transfer objects
        return projects.stream().map(project -> modelMapper.map(project, ProjectDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project with such ID does not exist"));
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public Long createProject(ProjectDTO projectDTO) {
        Project project = modelMapper.map(projectDTO, Project.class);
        //save project returning generated id
        return projectRepository.save(project).getId();
    }

    @Override
    public void editProject(ProjectDTO projectDTO) {
        Long id = projectDTO.getId();
        if (id == null) {
            throw new IllegalArgumentException("Please enter an id");
        }
        //get old project
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project with such ID does not exist"));
        Project projectToSave = modelMapper.map(projectDTO, Project.class);
        //attach old project tasks to the new project
        projectToSave.setTasks(project.getTasks());
        projectRepository.save(projectToSave);
    }

    @Override
    public void deleteProjectById(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
        } else throw new IllegalArgumentException("Project with such ID does not exist");
    }

}
