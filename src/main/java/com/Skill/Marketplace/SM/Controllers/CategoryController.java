package com.Skill.Marketplace.SM.Controllers;
import com.Skill.Marketplace.SM.DTO.categoryDTO.CreateCategoryDTO;
import com.Skill.Marketplace.SM.DTO.categoryDTO.UpdateCategoryDTO;
import com.Skill.Marketplace.SM.Entities.Category;
import com.Skill.Marketplace.SM.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryDTO dto){
        return ResponseEntity.ok(categoryService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id , @RequestBody UpdateCategoryDTO dto){
        return ResponseEntity.ok(categoryService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id){
         categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
