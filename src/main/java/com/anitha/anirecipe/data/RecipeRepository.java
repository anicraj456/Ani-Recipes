package com.anitha.anirecipe.data;

import com.anitha.anirecipe.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}