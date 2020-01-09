package ua.training.system_what_where_when.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ua.training.system_what_where_when.model.User;

import javax.persistence.Column;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegisterDto {
    private String nameUa;
    private String nameEn;
    private String email;
    private String password;
}
