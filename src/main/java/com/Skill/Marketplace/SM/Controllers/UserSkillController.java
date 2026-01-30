package com.Skill.Marketplace.SM.Controllers;
import com.Skill.Marketplace.SM.DTO.userDTO.AssignSkillDTO;
import com.Skill.Marketplace.SM.Services.UserSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-skills")
public class UserSkillController {

    @Autowired
    private UserSkillService userSkillService;

    @PreAuthorize("hasRole('PROVIDER')")
    @PostMapping("/{id}")
    public ResponseEntity<String> assignSkillToUser( @RequestBody AssignSkillDTO dto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        userSkillService.assignSkills(username ,dto);
        return ResponseEntity.ok("Skill(s) assigned to user");
    }
}
