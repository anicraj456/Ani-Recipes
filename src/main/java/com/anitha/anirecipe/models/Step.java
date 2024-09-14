package com.anitha.anirecipe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Step extends AbstractEntity{
    private String instructions;
    private int stepNumber;

    public Step(String instructions, int stepNumber) {
        this.instructions = instructions;
        this.stepNumber = stepNumber;
    }

    public Step() {
    }

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}