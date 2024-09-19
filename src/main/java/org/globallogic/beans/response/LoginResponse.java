package org.globallogic.beans.response;

import org.globallogic.beans.others.Phone;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class LoginResponse implements Serializable {
    private UUID id;
    private String created;
    private String modified;
    private String lastLogin;
    private String token;
    private boolean active;
    private String name;
    private String email;
    private String password;
    private List<Phone> phones;

    public LoginResponse() {}

    public LoginResponse(
            final UUID id,
            final String created,
            final String modified,
            final String lastLogin,
            final String token,
            final boolean active) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.token = token;
        this.active = active;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setName(String name) {
         this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
