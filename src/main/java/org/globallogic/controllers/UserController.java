package org.globallogic.controllers;

import org.globallogic.beans.response.LoginResponse;
import org.globallogic.beans.response.SignUpResponse;
import org.globallogic.beans.resquest.LoginRequest;
import org.globallogic.beans.resquest.SignUpRequest;
import org.globallogic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint para endpoint de creación de un usuario
     * @param signInRQ
     * @return ResponseEntity<SignUpResponse
     */
    @PostMapping(
            value = "/sign-up",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doSignIn(@Valid @RequestBody final SignUpRequest signInRQ) {
       return ResponseEntity.ok().body(userService.signUp(signInRQ));
    }

    /**
     * Endpoint el cual será para consultar el usuario,
     * @param loginRQ
     * @return ResponseEntity<LoginResponse>
     */
    @PostMapping(
            value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doLogin(@Valid @RequestBody final LoginRequest loginRQ) {
        return ResponseEntity.ok().body(userService.login(loginRQ));
    }
}
