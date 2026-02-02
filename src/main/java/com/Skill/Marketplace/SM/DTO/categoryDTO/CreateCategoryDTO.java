package com.Skill.Marketplace.SM.DTO.categoryDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCategoryDTO {
    @NotBlank
    private String categoryName;
}
