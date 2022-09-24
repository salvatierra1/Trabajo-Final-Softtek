package com.sofftektp.trabajofinal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@Table(name = "customization")
@SQLDelete(sql = "UPDATE customization SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Customization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;


    @CreationTimestamp
    @Column(name = "creation_date",updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @ManyToMany(mappedBy = "customizations")
    private Collection<Area> areas = new ArrayList<Area>();
    public Customization(){
        this.price = 0d;
    }

    public void addCustomizationToArea(Area area) {
        this.areas.add(area);
    }

}
