package ua.training.system_what_where_when.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ua.training.system_what_where_when.model.User;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String nameUa;
    private String nameEn;
    private String email;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setNameUa(nameUa);
        user.setNameEn(nameEn);
        user.setEmail(email);

        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setNameUa(user.getNameUa());
        adminUserDto.setNameEn(user.getNameEn());
        adminUserDto.setEmail(user.getEmail());

        return adminUserDto;
    }
}
