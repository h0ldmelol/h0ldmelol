package account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RegistrationController {
    @Autowired
    UserDao newUser;
    @Autowired
    PasswordEncoder encoder;

    @PostMapping("api/signup")
    public void signUp(@Valid @RequestParam String name, @RequestParam String lastname, @RequestParam String email, @RequestParam String password) {
        User user  = new User(name, lastname, email, encoder.encode(password));
        System.out.println(user.getEmail());;
    }
}
