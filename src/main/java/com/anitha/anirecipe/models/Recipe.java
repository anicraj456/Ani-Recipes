package com.anitha.anirecipe.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity{
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private RecipeDetails recipeDetails;

    @ManyToOne
    @NotNull(message = "Category is required")
    private RecipeCategory recipeCategory;

    //@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recipe")
    private List<Ingredient> ingredients = new ArrayList<>();

    //@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recipe")
    private List<Step> steps = new ArrayList<>();

    public Recipe(String name, RecipeDetails recipeDetails, RecipeCategory recipeCategory, List<Ingredient> ingredients, List<Step> steps) {
        this.name = name;
        this.recipeDetails = recipeDetails;
        this.recipeCategory = recipeCategory;
        this.ingredients = ingredients;
        this.steps = steps;
    }
    public Recipe() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecipeDetails getRecipeDetails() {
        return recipeDetails;
    }

    public void setRecipeDetails(RecipeDetails recipeDetails) {
        this.recipeDetails = recipeDetails;
    }

    public RecipeCategory getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(RecipeCategory recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
