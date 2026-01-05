package com.Skill.Marketplace.SM.DTO.userDTO;
import com.Skill.Marketplace.SM.Entities.UserType;
import lombok.Data;

@Data
public class UpdateUserDTO {
    private String username;
    private String password;
    private String FirstName;
    private String LastName;
    private UserType UserType;
}
