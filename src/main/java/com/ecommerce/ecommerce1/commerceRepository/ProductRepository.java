package com.ecommerce.ecommerce1.commerceRepository;

import com.ecommerce.ecommerce1.commerceModel.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDetails,Long> {
    ProductDetails findByCategory(String category);
    ProductDetails findByBrandName(String brandName);
    ProductDetails findByProductName(String  productName);
}
