package account.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("api/admin")
public class ServiceController {

    @GetMapping("/user")
    public void getAllUsers(@AuthenticationPrincipal UserDetails details) {
        System.out.println(details.isEnabled());
    }

    @DeleteMapping("user")
    public String deleteUser() {
        return "admin is tested";
    }

    @PutMapping("user/role")
    public String userRole() {
        return "admin is tested";
    }
}
