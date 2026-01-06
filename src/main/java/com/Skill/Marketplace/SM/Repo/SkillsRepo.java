package com.Skill.Marketplace.SM.Repo;
import com.Skill.Marketplace.SM.Entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepo extends JpaRepository<Skill,Long> {
}
