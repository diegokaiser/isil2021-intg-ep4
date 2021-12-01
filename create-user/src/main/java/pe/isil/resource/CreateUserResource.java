package pe.isil.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.isil.model.User;
import pe.isil.service.CreateUserEvent;

@RestController
@RequestMapping("/api/create-user")
public class CreateUserResource {

    private final CreateUserEvent createUserEvent;

    public CreateUserResource(CreateUserEvent createUserEvent) {
        this.createUserEvent = createUserEvent;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) {
        createUserEvent.sendEvent(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
