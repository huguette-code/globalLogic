package org.globallogic.beans.resquest;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.globallogic.beans.others.Phone;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import static org.globallogic.constant.Constant.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SignUpRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    @NotNull(message = EMAIL_NULL_ERROR_MESSAGE)
    @NotBlank(message = EMAIL_EMPTY_ERROR_MESSAGE)
    @Email(message = EMAIL_FORMAT_ERROR_MESSAGE)
    private String email;

    @NotNull(message = CREDENTIALS_NULL_ERROR_MESSAGE)
    @NotBlank(message = CREDENTIALS_EMPTY_ERROR_MESSAGE)
    @Pattern(regexp = PATTERN_CREDENTIALS, message = CREDENTIALS_FORMAT_ERROR_MESSAGE)
    private String password;

    @Valid
    private List<Phone> phones;

    public SignUpRequest() {}

    public SignUpRequest(
            final String name, final String email, final String password, final List<Phone> phones) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SignUpRequest that = (SignUpRequest) o;
        return Objects.equals(getName(), that.getName())
                && Objects.equals(getEmail(), that.getEmail())
                && Objects.equals(getPassword(), that.getPassword())
                && Objects.equals(getPhones(), that.getPhones());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), getPassword(), getPhones());
    }

    @Override
    public String toString() {
        return "SignInRequest{"
                + "name='"
                + getName()
                + '\''
                + ", email='"
                + getEmail()
                + '\''
                + ", password='"
                + getPassword()
                + '\''
                + ", phones="
                + getPhones()
                + '}';
    }
}
