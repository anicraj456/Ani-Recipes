package com.anitha.anirecipe.data;

import com.anitha.anirecipe.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}