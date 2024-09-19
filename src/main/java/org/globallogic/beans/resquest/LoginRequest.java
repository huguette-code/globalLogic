package org.globallogic.beans.resquest;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static org.globallogic.constant.Constant.TOKEN_EMPTY_ERROR_MESSAGE;
import static org.globallogic.constant.Constant.TOKEN_NULL_ERROR_MESSAGE;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LoginRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = TOKEN_NULL_ERROR_MESSAGE)
    @NotBlank(message = TOKEN_EMPTY_ERROR_MESSAGE)
    protected String token;

    public LoginRequest() {
    }

    public LoginRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
