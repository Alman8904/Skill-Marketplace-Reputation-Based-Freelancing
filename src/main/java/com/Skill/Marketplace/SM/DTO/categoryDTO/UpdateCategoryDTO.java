package com.Skill.Marketplace.SM.DTO.categoryDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCategoryDTO {
    @NotBlank
    private String categoryName;
}
