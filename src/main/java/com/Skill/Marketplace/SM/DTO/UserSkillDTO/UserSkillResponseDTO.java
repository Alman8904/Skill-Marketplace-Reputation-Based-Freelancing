package com.Skill.Marketplace.SM.DTO.UserSkillDTO;

import com.Skill.Marketplace.SM.Entities.ServiceMode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSkillResponseDTO {

    private Long userSkillId;
    private String skillName;
    private String description;
    private double rate;
    private int experience;
    private ServiceMode serviceMode;
}
