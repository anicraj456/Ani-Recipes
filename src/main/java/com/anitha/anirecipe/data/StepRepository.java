package com.anitha.anirecipe.data;

import com.anitha.anirecipe.models.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Integer> {
}
