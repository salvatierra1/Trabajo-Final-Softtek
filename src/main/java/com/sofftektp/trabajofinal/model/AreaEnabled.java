package com.sofftektp.trabajofinal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;


@Entity
@Data
@AllArgsConstructor
@Table(name = "area_enabled")
@SQLDelete(sql = "UPDATE area_enabled SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class AreaEnabled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @Column(name = "name")
    private String name;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @ManyToMany(cascade = {
            CascadeType.MERGE

    },
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "areaEnabled_permittedCustomization",
            joinColumns = @JoinColumn(
                    name = "area_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "customization_id", referencedColumnName = "id")
    )
    private Collection<PermittedCustomization> permittedCustomizationCollection;


    public AreaEnabled() {

    }

    public void addCustomizationToArea(PermittedCustomization permittedCustomization) {
        permittedCustomizationCollection.add(permittedCustomization);
    }

}
