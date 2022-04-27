package account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    @PostMapping("api/auth/signup")
    public User signUp(@RequestBody @Valid User user) {
        return new User();
    }
}
