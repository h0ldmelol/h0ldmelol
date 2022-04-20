package account.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/auth")
public class AuthController {

    @PostMapping("signup")
    public String userMap(@Valid @RequestBody String user) {
        return user;
    }

    @PostMapping("changepass")
    public String changePass() {
        return "pass";
    }


}
