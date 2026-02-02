package com.Skill.Marketplace.SM.DTO.skillDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateSkillDTO {

    @NotBlank
    private String skillName;
    @NotNull
    private Long categoryId;
}
