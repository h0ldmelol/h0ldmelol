package account;

import org.springframework.web.bind.annotation.*;

@RestController
public class BusinessController {

    @GetMapping("api/empl/payment")
    public String emplPayment() {
        return "auth is tested";
    }
}
