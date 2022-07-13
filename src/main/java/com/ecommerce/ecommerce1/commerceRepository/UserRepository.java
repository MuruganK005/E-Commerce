package com.ecommerce.ecommerce1.commerceRepository;

import com.ecommerce.ecommerce1.commerceModel.UserSignUp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.ListIterator;

public interface UserRepository extends JpaRepository<UserSignUp,Long> {
    UserSignUp findByEmail(String email);
    UserSignUp findByEmailAndPassWord(String email,String passWord);
    UserSignUp findByPhone(Long email);
}
