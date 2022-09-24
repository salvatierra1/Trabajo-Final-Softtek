package com.sofftektp.trabajofinal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "creation_date",updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH} )
    @JoinTable(name = "area_customization",
            joinColumns = @JoinColumn(name = "area_id"),
            inverseJoinColumns = @JoinColumn(name = "customization_id"))
    private List<Customization> customizations;
    @ManyToOne
    @JoinColumn(name = "enabled_area_id", referencedColumnName = "id")
    private AreaEnabled enabledArea;
    public Area(){
        this.customizations= new ArrayList<>();
    }
    public Area(AreaEnabled enabledArea){
        this.enabledArea = enabledArea;
    }

    public void addCustomizationToArea(Customization customization) {
        customizations.add(customization);
    }


}
