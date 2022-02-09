package ru.itis.javalab.api.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.itis.javalab.api.enums.ProjectStatus;
import ru.itis.javalab.api.validation.ValidProjectStatus;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 05.02.2022
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProjectDTO {

    @ApiModelProperty(name = "id", value = "573843732")
    private Long id;

    @ApiModelProperty(name = "name", value = "СберЗдоровье", required = true)
    @NotBlank(message = "The name must not be empty")
    @Length(max = 50, message = "Maximum name length is 50 characters")
    private String name;

    @ApiModelProperty(name = "startDate", value = "2022-01-09T10:13:20+0300",
            notes = "Project start date in ISO 8601 format")
    private Date startDate;

    @ApiModelProperty(name = "completeDate", value = "2022-01-13T10:13:20+0300",
            notes = "Project start date in ISO 8601 format")
    private Date completionDate;

    @ValidProjectStatus
    @ApiModelProperty(name = "projectStatus", value = "NOT_STARTED", required = true,
    allowableValues = "NOT_STARTED, ACTIVE, COMPLETED", notes = "Project status")
    private ProjectStatus projectStatus;

    @Min(0)
    @Max(Integer.MAX_VALUE)
    @ApiModelProperty(name = "priority", value = "1", notes = "Project priority",
            allowableValues = "0 to 2147483647")
    private int priority;

}
