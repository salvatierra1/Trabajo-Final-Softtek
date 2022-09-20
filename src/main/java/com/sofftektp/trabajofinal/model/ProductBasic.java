package com.sofftektp.trabajofinal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@Table (name = "product_basic")
@SQLDelete(sql = "UPDATE product_basic SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class ProductBasic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "production_time")
    private Long productionTime;

    @CreationTimestamp
    @Column(name = "creation_date",updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Manager manager;

    @ManyToMany(cascade = {
            CascadeType.MERGE

    },
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "productBasic_areaEnabled",
            joinColumns = @JoinColumn(
                    name = "productBasic_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "areaEnabled_id", referencedColumnName = "id")
    )
    private Collection<AreaEnabled>areasEnabled;

    public ProductBasic() {
        this.areasEnabled = new ArrayList<>();
    }
    public void addAreaToBaseProduct(AreaEnabled enabledArea) {
        areasEnabled.add(enabledArea);
    }

}
