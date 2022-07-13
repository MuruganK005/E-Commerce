package com.ecommerce.ecommerce1.commerceController;

import com.ecommerce.ecommerce1.commerceException.CommerceException;
import com.ecommerce.ecommerce1.commerceModel.ProductDetails;
import com.ecommerce.ecommerce1.commerceRepository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/product")
public class ProductController {
    //private int a = 0;
    @Autowired
    private ProductRepository productRepository;
    @PostMapping
    public ProductDetails createProductDetails(@RequestBody ProductDetails productDetails) throws Exception {
        ProductDetails productDetails1 = productRepository.findByCategory(productDetails.getCategory());
        if (productDetails1 != null && productDetails1.getId() !=productDetails.getId()) {
            throw new CommerceException(HttpStatus.FORBIDDEN,"Category Already Exist in another Id");
        }
        ProductDetails productDetails2 = productRepository.findByProductName(productDetails.getProductName());
        if (productDetails2 != null&& productDetails2.getId() !=productDetails.getId()) {
            throw new CommerceException(HttpStatus.FORBIDDEN,"ProductName Already Exist in another Id");
        }
        ProductDetails productDetails3 = productRepository.findByBrandName(productDetails.getBrandName());
        if (productDetails3 != null&& productDetails3.getId() !=productDetails.getId()) {
            throw new CommerceException(HttpStatus.FORBIDDEN,"BrandName Already Exist in another Id");
        }
        return productRepository.save(productDetails);
    }
    @PutMapping
    public ProductDetails updateProductDetails(@RequestBody ProductDetails productDetails) {
        return productRepository.save(productDetails);
    }
    @DeleteMapping("{id}")
    public void deleteProductDetails(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
    @GetMapping("/productAll")
    public List<ProductDetails> getProductDetailsAll() {
        return productRepository.findAll();
    }
    @GetMapping("{id}")
    public Optional<ProductDetails> getProductDetailsById(@PathVariable Long id) {
        return productRepository.findById(id);
    }
    @PostMapping("/logo")
    public ProductDetails getProductLogo(@RequestBody ProductDetails productDetails){
        return productRepository.save(productDetails);
    }
    @DeleteMapping("/all")
    public void deleteProductDetails() {
        productRepository.deleteAll();
    }
    @PostMapping("/productList")
    public List<ProductDetails> controlProductDetails(@RequestBody List<ProductDetails> productDetails){
        ArrayList<ProductDetails> productDetailsArrayList=new ArrayList<>();
        for (ProductDetails productDetails1: productDetails){
            productDetailsArrayList.add(productRepository.save(productDetails1));
        }
        return productDetailsArrayList;
    }
}