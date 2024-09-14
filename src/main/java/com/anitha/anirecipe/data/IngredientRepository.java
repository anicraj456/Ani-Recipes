package com.anitha.anirecipe.data;

import com.anitha.anirecipe.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
}