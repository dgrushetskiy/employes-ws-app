package ru.gothmog.ws.employes.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "sequence_id_auto_gen", allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id_auto_gen")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @Column(name = "active", nullable = false, columnDefinition = "boolean default false")
    private Boolean active = false;

    @PrePersist
    public void toCreate() {
        setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void toUpdate() {
        setUpdatedAt(LocalDateTime.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {return false;}
        AbstractEntity that = (AbstractEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
