package com.ecommerce.ecommerce1.commerceModel;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "UserDetails")
public class UserSignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "FirstName")
    @NotNull(message = "User FirstName Should Not Be Null ")
    private String userFirstName;
    @Column(name = "LastName")
    @NotNull(message = "User LastName Should Not Be Null")
    private String userLastName;
    @Column(name = "PhoneNumber")
    @NotNull
    private Long phone;
    @Column(name = "Email")
    @NotNull
    String email;
    @Column(name = "PassWord")
    @NotNull
    private String passWord;



}
