package com.anitha.anirecipe.data;

import com.anitha.anirecipe.models.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory, Integer> {
}
