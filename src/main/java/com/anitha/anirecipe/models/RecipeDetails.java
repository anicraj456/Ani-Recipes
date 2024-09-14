package com.anitha.anirecipe.models;

import jakarta.persistence.Entity;

@Entity
public class RecipeDetails extends AbstractEntity{
    @Size(max = 500, message = "Description too long!")
    private String description;

    public RecipeDetails(String description) {
        this.description = description;
    }
    public RecipeDetails() {
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
