package org.globallogic.controllers;

import org.globallogic.beans.response.ErrorResponse;
import org.globallogic.beans.resquest.LoginRequest;
import org.globallogic.beans.resquest.SignUpRequest;
import org.globallogic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(
            value = "/sign-up",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doSignIn(@Valid @RequestBody final SignUpRequest signInRQ) {
       return ResponseEntity.ok().body(userService.signUp(signInRQ));
    }

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doLogin(@Valid @RequestBody final LoginRequest loginRQ) {
        return ResponseEntity.ok().body(userService.login(loginRQ));
    }
}
