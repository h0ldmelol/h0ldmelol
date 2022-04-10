package account;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Map<String, String> userMap(@Valid @RequestBody Users user) {
        return Map.of(
                "name", user.getName(),
                "lastname", user.getLastname(),
                "email", user.getEmail()
        );
    }
}
