package com.swagnik.recipeapi.models;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("recipe")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    private UUID id;
    private String recipeName;
    private String cuisine;
    private List<String> ingredients;
    private List<String> instructions;
    private Integer serves;
    private Integer time;
    private Integer calories;
    private String description;
}
