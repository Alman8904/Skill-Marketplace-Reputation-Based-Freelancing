package com.Skill.Marketplace.SM.Entities;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String skillName;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "skill" )
    private List<UserSkill> userSkills;

}
