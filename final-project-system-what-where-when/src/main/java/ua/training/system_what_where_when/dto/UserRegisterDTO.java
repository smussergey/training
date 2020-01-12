package ua.training.system_what_where_when.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ua.training.system_what_where_when.model.User;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegisterDTO {
    @NotBlank(message = "validation.name.ua.cannot.be.blank")
    private String nameUa;
    @NotBlank(message = "validation.name.en.cannot.be.blank")
    private String nameEn;
    @NotBlank(message = "validation.email.cannot.be.blank")
    private String email;
    @NotBlank(message = "validation.password.cannot.be.blank")
    private String password;
}
