package com.Skill.Marketplace.SM.DTO.userDTO;
import com.Skill.Marketplace.SM.Entities.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateUserDTO {

    @NotBlank
    @Size(min = 3, max = 50)
    private String username;
    @NotBlank
    @Size(min=8)
    private String password;
    private String firstName;
    private String lastName;
    @NotNull
    private UserType userType;
}
