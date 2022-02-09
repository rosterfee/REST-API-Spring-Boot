package ru.itis.javalab.api.services;

import ru.itis.javalab.api.dtos.ProjectDTO;

import java.util.List;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 05.02.2022
 */

public interface ProjectService {

    List<ProjectDTO> getAll();

    ProjectDTO getById(Long id);

    Long createProject(ProjectDTO projectDTO);

    void editProject(ProjectDTO projectDTO);

    void deleteProjectById(Long id);

}
