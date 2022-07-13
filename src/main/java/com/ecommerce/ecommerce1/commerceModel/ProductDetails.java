package com.ecommerce.ecommerce1.commerceModel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "name")
@Entity
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Category")
    private String category;
    @Column(name = "BrandName")
    private String brandName;
    @Column(name = "ProductName")
    private String productName;
    @Min(1)
    @Max(100)
    @Column(name = "ProductQuantity")
    private Long productQuantity;
    @Column(name = "ProductPrice")
    private Long productPrice;
    @Column(name = "ProductLogo")
    private String productLogo;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="seller_id", referencedColumnName = "id")
    private SellerRegistration sellerRegistrationList;
}
