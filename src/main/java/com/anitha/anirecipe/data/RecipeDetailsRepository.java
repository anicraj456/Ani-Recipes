package com.anitha.anirecipe.data;

import com.anitha.anirecipe.models.RecipeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeDetailsRepository extends JpaRepository<RecipeDetails, Integer> {
}

