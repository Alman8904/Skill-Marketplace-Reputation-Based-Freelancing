package com.Skill.Marketplace.SM.DTO.userDTO;
import com.Skill.Marketplace.SM.Entities.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserDTO {

    @NotBlank
    @Size(min=3, max=20)
    private String username;
    private String firstName;
    private String lastName;

    @NotBlank
    @Size(min=8)
    private String password;
    @NotNull
    private UserType userType;
}
