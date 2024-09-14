package com.anitha.anirecipe.data;

import com.anitha.anirecipe.models.RecipeCategory;
import org.springframework.data.repository.CrudRepository;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {
}
