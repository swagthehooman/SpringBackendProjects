package com.swagnik.recipeapi.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swagnik.recipeapi.models.Recipe;
import com.swagnik.recipeapi.repositories.IRecipeRepository;

@RestController
@RequestMapping("/api/v1/")
public class RecipeControllers {

    @Autowired
    private IRecipeRepository recipeRepository;

    // get method to get count of recipies in each cuisine
    @GetMapping("/recipe/cuisine/count")
    public Long getRecipeCountByCuisine(@RequestParam String cuisine) {
        return recipeRepository.countRecipeByCuisine(cuisine);
    }

    // get recipies by cuisine
    @GetMapping("/cuisines/recipies")
    public List<Recipe> getRecipesByCuisine(@RequestParam String cuisine) {
        return recipeRepository.findRecipiesByCuisine(cuisine);
    }

    // get recipe
    @GetMapping("/recipe")
    public Recipe getRecipe(@RequestParam String recipeName) {
        return recipeRepository.findByName(recipeName);
    }

    // get list of recipe descriptions
    @GetMapping("/cuisine/recipies/descriptions")
    public List<Recipe> getDescriptions(@RequestParam String cuisine) {
        return recipeRepository.findDescriptionsByCuisine(cuisine);
    }

    // get method to get all recipies
    @GetMapping("/get")
    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    // post method to store the data
    @PostMapping("/save")
    public Recipe saveRecipe(@RequestBody Recipe data) {
        data.setId(UUID.randomUUID());
        return recipeRepository.save(data);
    }
}
