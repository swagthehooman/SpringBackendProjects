package com.swagnik.recipeapi.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.swagnik.recipeapi.models.Recipe;

public interface IRecipeRepository extends MongoRepository<Recipe, UUID> {
    @Query("{recipeName:'?0'}")
    public Recipe findByName(String recipeName);

    @Query(value = "{cuisine: '?0'}")
    public List<Recipe> findRecipiesByCuisine(String cuisine);

    @Query(value = "{cuisine: '?0'}", count = true)
    public Long countRecipeByCuisine(String cuisine);

    @Query(value = "{cuisine:'?0'}", fields = "{'id':1, 'recipeName':1, 'cuisine':1, 'ingredients':1, 'serves':1, 'time':1, 'calories:1', 'description':1}")
    public List<Recipe> findDescriptionsByCuisine(String cuisine);
}
