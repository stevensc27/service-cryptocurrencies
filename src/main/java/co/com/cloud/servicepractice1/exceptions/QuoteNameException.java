package co.com.cloud.servicepractice1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuoteNameException extends RuntimeException{

    public QuoteNameException(String message) {
        super(message);
    }
}
