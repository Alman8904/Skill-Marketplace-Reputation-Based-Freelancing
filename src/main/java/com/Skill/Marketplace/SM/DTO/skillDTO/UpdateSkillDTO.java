package com.Skill.Marketplace.SM.DTO.skillDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateSkillDTO {

    @NotBlank
    private String skillName;
    @NotNull
    private Long categoryId;
}
