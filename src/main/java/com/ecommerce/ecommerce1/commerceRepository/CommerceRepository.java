package com.ecommerce.ecommerce1.commerceRepository;


import com.ecommerce.ecommerce1.commerceModel.SellerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommerceRepository extends JpaRepository<SellerRegistration, Long> {

    SellerRegistration findByEmail(String email);

    SellerRegistration findByPhoneNumber(long phoneNumber);
}
