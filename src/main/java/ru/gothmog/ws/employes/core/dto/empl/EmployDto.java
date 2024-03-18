package ru.gothmog.ws.employes.core.dto.empl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import ru.gothmog.ws.employes.core.dto.AbstractDto;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link ru.gothmog.ws.employes.core.model.empl.Employ}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonRootName(value = "employ")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployDto extends AbstractDto {

    @NotNull
    @JsonProperty(value = "publicId", access = JsonProperty.Access.READ_ONLY)
    private UUID publicId = UUID.randomUUID();
    @NotNull
    @Size(max = 200)
    @JsonProperty(value = "firstName")
    private String firstName;
    @NotNull
    @Size(max = 200)
    @JsonProperty(value = "lastName")
    private String lastName;
}
