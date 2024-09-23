package org.globallogic.services;

import org.globallogic.beans.response.LoginResponse;
import org.globallogic.beans.response.SignUpResponse;
import org.globallogic.beans.resquest.LoginRequest;
import org.globallogic.beans.resquest.SignUpRequest;
import org.globallogic.dao.User;
import org.globallogic.dao.UserRepository;
import org.globallogic.exception.UserNotFoundException;
import org.globallogic.jwt.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Objects;

import static org.globallogic.constant.Constant.USERS_DOES_EXIST_EXCEPTION_MESSAGE;
import static org.globallogic.constant.Constant.USER_DOES_NOT_EXIST_EXCEPTION_MESSAGE;
import static org.globallogic.utils.Date.dateNow;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JWTTokenProvider jwtToken;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(
            final UserRepository userRepository,
            final JWTTokenProvider jwtTokenProvider,
            final PasswordEncoder passwordEncoder){

        this.jwtToken = jwtTokenProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(@Valid LoginRequest loginRQ) {
        User user = userRepository.findUserByToken(loginRQ.getToken());
        LoginResponse lr = new LoginResponse();
        if(user != null) {
            lr.setId(user.getId());
            lr.setCreated(user.getCreated());
            lr.setLastLogin(user.getLastLogin());
            lr.setModified(user.getModified());
            lr.setToken(user.getToken());
            lr.setActive(user.isActive());
            lr.setName(user.getName());
            lr.setEmail(user.getEmail());
            lr.setPassword(user.getPassword());//encriptado
            lr.setPhones(user.getPhones());

            String newToken = jwtToken.generateToken(user.getEmail());
            userRepository.updateUser(user.getEmail(), newToken, dateNow(), dateNow());
            lr.setToken(newToken);
            return lr;
        }
        throw new UserNotFoundException(USER_DOES_NOT_EXIST_EXCEPTION_MESSAGE);
    }


    public SignUpResponse signUp(@Valid SignUpRequest signInRQ) {
        User user = userRepository.findByEmail(signInRQ.getEmail());
        if(user == null) {
            User newUser = new User(signInRQ.getName(),
                    signInRQ.getEmail(),
                    passwordEncoder.encode(signInRQ.getPassword()),
                    signInRQ.getPhones(),
                    dateNow(),
                    dateNow(),
                    dateNow(),
                    jwtToken.generateToken(signInRQ.getEmail()),
                    true);

            User userSave = userRepository.save(newUser);

            return new SignUpResponse(userSave.getId().toString(),
                    userSave.getCreated(),
                    userSave.getModified(),
                    userSave.getLastLogin(),
                    userSave.getToken(),
                    userSave.isActive());
        }
        throw new UserNotFoundException(USERS_DOES_EXIST_EXCEPTION_MESSAGE);
    }

}
