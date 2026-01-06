package com.Skill.Marketplace.SM.Controllers;
import com.Skill.Marketplace.SM.DTO.userDTO.AssignSkillDTO;
import com.Skill.Marketplace.SM.Services.UserSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-skills")
public class UserSkillController {

    @Autowired
    private UserSkillService userSkillService;

    @PostMapping("/{id}")
    public ResponseEntity<String> assignSkillToUser(@PathVariable Long id , @RequestBody AssignSkillDTO dto){
        userSkillService.assignSkills(id ,dto);
        return ResponseEntity.ok("Skill(s) assigned to user");
    }
}
