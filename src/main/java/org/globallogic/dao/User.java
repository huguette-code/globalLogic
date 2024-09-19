package org.globallogic.dao;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.globallogic.beans.others.Phone;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.*;

@Entity
@Table(name = "USERS")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(unique = true, name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PHONES")
    @ElementCollection
    private List<Phone> phones;

    @Column(name = "CREATED")
    private String created;

    @Column(name = "MODIFIED")
    private String modified;

    @Column(name = "LAST_LOGIN")
    private String lastLogin;

    @Column(name = "TOKEN")
    private String token;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @Column(name = "ACTIVE")
    private boolean active;

    public User() {}

    public User(
            final String name,
            final String email,
            final String password,
            final List<Phone> phones,
            final String created,
            final String modified,
            final String lastLogin,
            final String token) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.token = token;
        this.active = true;
    }

    public User(
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

    public User(
            final UUID id,
            final String name,
            final String email,
            final String password,
            final List<Phone> phones,
            final String created,
            final String modified,
            final String lastLogin,
            final String token,
            final boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.token = token;
        this.active = active;
    }

    public User(
            final String name,
            final String email,
            final String password,
            final List<Phone> phones,
            final String created,
            final String modified,
            final String lastLogin,
            final String token,
            final boolean active) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.token = token;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public String getCreated() {
        return created;
    }

    public String getModified() {
        return modified;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public String getToken() {
        return token;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isActive() == user.isActive()
                && Objects.equals(getId(), user.getId())
                && Objects.equals(getName(), user.getName())
                && Objects.equals(getEmail(), user.getEmail())
                && Objects.equals(getPassword(), user.getPassword())
                && Objects.equals(getPhones(), user.getPhones())
                && Objects.equals(getCreated(), user.getCreated())
                && Objects.equals(getModified(), user.getModified())
                && Objects.equals(getLastLogin(), user.getLastLogin())
                && Objects.equals(getToken(), user.getToken());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(),
                getName(),
                getEmail(),
                getPassword(),
                getPhones(),
                getCreated(),
                getModified(),
                getLastLogin(),
                getToken(),
                isActive());
    }

    @Override
    public String toString() {
        return "User{"
                + "id="
                + getId()
                + ", name='"
                + getName()
                + '\''
                + ", email='"
                + getEmail()
                + '\''
                + ", password='"
                + getPassword()
                + '\''
                + ", phones='"
                + getPhones()
                + '\''
                + ", created='"
                + getCreated()
                + '\''
                + ", modified='"
                + getModified()
                + '\''
                + ", lastLogin='"
                + getLastLogin()
                + '\''
                + ", token='"
                + getToken()
                + '\''
                + ", isActive="
                + isActive()
                + '}';
    }
}