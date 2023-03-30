package secret.santa.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import secret.santa.exceptions.NotEnoughUsers;

@RestController
public class ExceptionController {
    @ExceptionHandler(NotEnoughUsers.class)
    public ResponseEntity<?> notEnoughUsers() {
        return new ResponseEntity<>(HttpStatusCode.valueOf(409));
    }
}
