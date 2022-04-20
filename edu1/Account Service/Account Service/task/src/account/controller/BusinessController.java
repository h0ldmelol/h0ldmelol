package account.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class BusinessController {

    @GetMapping("api/empl/payment")
    public String emplPayment() {
        return "auth is tested";
    }

//    @PostMapping("api/acct/payments")
//    public String uploadPayment() {
//        return "user is tested";
//    }
//
//    @PutMapping("api/acct/payments")
//    public String updatePayment() {
//        return "admin is tested";
//    }
}
