package ru.itis.javalab.api.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.itis.javalab.api.enums.TaskStatus;
import ru.itis.javalab.api.validation.ValidTaskStatus;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 05.02.2022
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TaskDTO {

    @ApiModelProperty(name = "id", value = "573843732")
    private Long id;

    @ApiModelProperty(name = "name", value = "Implement authentication", required = true)
    @NotBlank(message = "The name must not be empty")
    @Length(max = 50, message = "Maximum name length is 50 characters")
    private String name;

    @ValidTaskStatus
    @ApiModelProperty(name = "taskStatus", value = "TO_DO", required = true,
            allowableValues = "TO_DO, IN_PROGRESS, DONE", notes = "Task status")
    private TaskStatus taskStatus;

    @Length(max = 255, message = "Maximum description length is 255 characters")
    @ApiModelProperty(name = "description", value = "Implement OAuth2 authentication in Spring Security",
        notes = "Task description")
    private String description;

    @Min(0)
    @Max(Integer.MAX_VALUE)
    @ApiModelProperty(name = "priority", value = "1", notes = "Task priority",
            allowableValues = "0 to 2147483647")
    private int priority;

}
