package ru.gothmog.ws.employes.core.model.empl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import ru.gothmog.ws.employes.core.model.AbstractEntity;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "employs",  indexes = {@Index(name = "idx_employ_public_id_unq", columnList = "public_id", unique = true)})
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
                     @AttributeOverride(name = "createdAt", column = @Column(name = "created_at", nullable = false)),
                     @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at", nullable = false))})
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employ extends AbstractEntity {

    @NotNull
    @Column(name = "public_id", nullable = false)
    private UUID publicId;

    @Size(max = 200)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 200)
    private String firstName;

    @Size(max = 200)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 200)
    private String lastName;

}
