package com.Skill.Marketplace.SM.Mapper;
import com.Skill.Marketplace.SM.DTO.skillDTO.SkillResponseDTO;
import com.Skill.Marketplace.SM.Entities.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    public SkillResponseDTO toResponse(Skill skill){
        SkillResponseDTO response = new SkillResponseDTO();

        response.setId(skill.getId());
        response.setSkillName(skill.getSkillName());
        response.setCategory(categoryMapper.toResponse(skill.getCategory()));

        return response;
    }
}
