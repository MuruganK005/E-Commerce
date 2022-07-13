package com.ecommerce.ecommerce1.commerceController;
import com.ecommerce.ecommerce1.commerceException.UserException;
import com.ecommerce.ecommerce1.commerceModel.UserSignUp;
import com.ecommerce.ecommerce1.commerceRepository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Getter
@Setter
@RestController
@RequestMapping("/api/userSignUp")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/SignUp")
    public UserSignUp getUserDetails(@RequestBody UserSignUp userSignUp)throws Exception{
        UserSignUp emailValid= userRepository.findByEmail(userSignUp.getEmail());
        if (emailValid!=null ) {
            throw new UserException(HttpStatus.FORBIDDEN, "Email Already Exist in another Id");
        }
        UserSignUp phoneValid=userRepository.findByPhone(userSignUp.getPhone());
        if (phoneValid!=null ) {
            throw new UserException(HttpStatus.FORBIDDEN, "PhoneNumber Already Exist in another Id");
        }
        return userRepository.save(userSignUp);
    }
    @GetMapping("/logIn")
    public UserSignUp userLogInAuth(@RequestParam String email,@RequestParam String passWord) throws UserException {
        UserSignUp logInEmail=userRepository.findByEmailAndPassWord(email,passWord);
        if (logInEmail==null){
            throw new UserException(HttpStatus.FORBIDDEN, "Email and PassWord InCorrect");
        }
        return userRepository.findByEmail(email);
    }
    @DeleteMapping("/DeleteAll")
    public void deleteAllUser(){
         userRepository.deleteAll();
    }
    @GetMapping("/ShowAllUser")
    public List<UserSignUp> getAllUser(){
        return userRepository.findAll();
    }
}
