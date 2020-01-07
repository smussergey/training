package ua.training.system_what_where_when.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String email;
    private String password;
}
