package account;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongRequest extends RuntimeException{

    public WrongRequest(String cause) {
        super(cause);
    }
}
