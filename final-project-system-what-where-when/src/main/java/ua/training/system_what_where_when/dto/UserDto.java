package ua.training.system_what_where_when.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ua.training.system_what_where_when.model.User;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String nameUa;
    private String nameEn;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setNameUa(nameUa);
        user.setNameEn(nameEn);

        return user;
    }

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setNameUa(user.getNameUa());
        userDto.setNameEn(user.getNameEn());

        return userDto;
    }
}
