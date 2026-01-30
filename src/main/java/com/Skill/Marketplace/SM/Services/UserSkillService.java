package com.Skill.Marketplace.SM.Services;
import com.Skill.Marketplace.SM.DTO.userDTO.AssignSkillDTO;
import com.Skill.Marketplace.SM.Entities.Skill;
import com.Skill.Marketplace.SM.Entities.UserModel;
import com.Skill.Marketplace.SM.Entities.UserSkill;
import com.Skill.Marketplace.SM.Repo.SkillsRepo;
import com.Skill.Marketplace.SM.Repo.UserRepo;
import com.Skill.Marketplace.SM.Repo.UserSkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSkillService {

    @Autowired
    private UserSkillRepo userSkillRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SkillsRepo skillsRepo;

    public Void assignSkills(String username, AssignSkillDTO dto){

        UserModel user = userRepo.getUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        for (Long skillId : dto.getSkillIds()) {

            Skill skill = skillsRepo.findById(skillId)
                    .orElseThrow(() -> new RuntimeException("No skills found"));

            UserSkill userSkill = new UserSkill();
            userSkill.setUser(user);
            userSkill.setSkill(skill);

            userSkillRepo.save(userSkill);
        }
        return null;
    }
}
