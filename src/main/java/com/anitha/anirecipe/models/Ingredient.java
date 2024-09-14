package com.anitha.anirecipe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingredient extends AbstractEntity{
    private String name;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}

