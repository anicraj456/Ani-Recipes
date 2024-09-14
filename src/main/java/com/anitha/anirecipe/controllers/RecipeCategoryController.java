package com.anitha.anirecipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("recipeCategories")
public class RecipeCategoryController {

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        return "recipeCategories/index";
    }

    @GetMapping("create")
    public String renderCreateRecipeCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute(new RecipeCategory());
        return "recipeCategories/create";
    }

    @PostMapping("create")
    public String processCreateRecipeCategoryForm(@Valid @ModelAttribute RecipeCategory recipeCategory,
                                                  Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Category");
            model.addAttribute(new RecipeCategory());
            return "recipeCategories/create";
        }
        recipeCategoryRepository.save(recipeCategory);
        return "redirect:/recipeCategories";
    }

}