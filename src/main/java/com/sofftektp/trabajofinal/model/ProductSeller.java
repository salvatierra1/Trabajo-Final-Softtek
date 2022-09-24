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
@Table(name = "product_seller")
@SQLDelete(sql = "UPDATE product_seller SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class ProductSeller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @Transient
    private Double priceFinal;
    private Double priceBasic;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "productBasic_id", referencedColumnName = "id")
    private ProductBasic productBasic;

    @ManyToMany(cascade = {
            CascadeType.MERGE

    },
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "productSeller_area",
            joinColumns = @JoinColumn(
                    name = "productSeller_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "area_id", referencedColumnName = "id")
    )
    private Collection<Area> areasSeller;

    @OneToMany()
    private Collection<Customization>customizations = new ArrayList<>();

    public ProductSeller() {
        this.areasSeller = new ArrayList<>();
    }

    public void addAreaToSellerProduct(Area area) {
        this.areasSeller.add(area);
    }

    public ProductSeller(Double basePrice){
        this.priceBasic = basePrice;
    }

    public Double getPriceFinal(){
        areasSeller.stream().forEach(areas -> {
            this.priceFinal = this.priceBasic + areas.getCustomizations().stream().mapToDouble(Customization::getPrice).sum();
        });
        return priceFinal;
    }


}
