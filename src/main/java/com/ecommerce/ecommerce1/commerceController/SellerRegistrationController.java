package com.ecommerce.ecommerce1.commerceController;

import com.ecommerce.ecommerce1.commerceModel.SellerRegistration;
import com.ecommerce.ecommerce1.commerceRepository.CommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/commerce")
public class SellerRegistrationController {
    @Autowired
    private CommerceRepository commerceRepository;
    @PostMapping
    public SellerRegistration createRegistration(@RequestBody SellerRegistration sellerRegistration) throws Exception {
        SellerRegistration sellerRegistration1 = commerceRepository.findByEmail(sellerRegistration.getEmail());
        if (sellerRegistration1 != null) {
            throw new Exception();
        }
        SellerRegistration sellerRegistration2 = commerceRepository.findByPhoneNumber(sellerRegistration.getPhoneNumber());
        if (sellerRegistration2 != null) {
            throw new Exception();
        }
        return commerceRepository.save(sellerRegistration);
    }
    @GetMapping("/{id}")
    public Optional<SellerRegistration> getByIdSeller(@PathVariable Long id){
        return commerceRepository.findById(id);
    }
    @PutMapping
    public SellerRegistration updateRegistration(@RequestBody SellerRegistration sellerRegistration){
        return commerceRepository.save(sellerRegistration);
    }
    @DeleteMapping("{id}")
    public void deleteRegistration(@PathVariable Long id){
        commerceRepository.deleteById(id);
    }
    @GetMapping("/all")
    public List<SellerRegistration> getRegistration(){
        return commerceRepository.findAll();
    }
    @DeleteMapping("/delete")
    public void deleteRegistration(){
        commerceRepository.deleteAll();
    }
    @GetMapping("/sellerAll")
    public List<SellerRegistration> getAllSeller() {
        return commerceRepository.findAll();
    }

}
