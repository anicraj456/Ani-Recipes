package com.anitha.anirecipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @GetMapping
    public String displayEvents(@RequestParam(required = false) Integer categoryId, Model model) {

        if (categoryId == null) {
            model.addAttribute("title", "All recipes");
            model.addAttribute("recipes", recipeRepository.findAll());
        } else {
            Optional<RecipeCategory> result = recipeCategoryRepository.findById(categoryId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Category ID: " + categoryId);
            } else {
                RecipeCategory category = result.get();
                model.addAttribute("title", "Recipes in this category: " + category.getName());
                model.addAttribute("events", category.getRecipes());
            }
        }
        return "recipes/index";
    }

    @GetMapping("create")
    public String displayCreateRecipeForm(Model model) {
        model.addAttribute("title", "Create Recipe");
        model.addAttribute(new Recipe());
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        return "recipes/create";
    }

    @PostMapping("create")
    public String processCreateRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                          Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Recipe");
            return "recipes/create";
        }

        recipeRepository.save(newRecipe);
        return "redirect:/recipes";
    }

    @GetMapping("delete")
    public String displayDeleteRecipeForm(Model model) {
        model.addAttribute("title", "Delete Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/delete";
    }

    @PostMapping("delete")
    public String processDeleteRecipeForm(@RequestParam(required = false) int[] recipeIds) {

        if (recipeIds != null) {
            for (int id : recipeIds) {
                recipeRepository.deleteById(id);
            }
        }
        return "redirect:/recipes";
    }

    @GetMapping("detail")
    public String displayRecipeDetails(@RequestParam Integer recipeId, Model model) {

        Optional<Recipe> result = recipeRepository.findById(recipeId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Recipe ID: " + recipeId);
        } else {
            Recipe recipe = result.get();
            model.addAttribute("title", recipe.getName() + " Details");
            model.addAttribute("recipe", recipe);
        }
        return "recipes/detail";
    }

}

