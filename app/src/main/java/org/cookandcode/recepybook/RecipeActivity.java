package org.cookandcode.recepybook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    protected Recipe recipe;

    protected TextView recipeInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int recipeIndex = this.getIntent().getIntExtra("recipeIndex", 0);
        Recipe[] recipes = Recipes.getRecipes();
        this.recipe = recipes[recipeIndex];

        setContentView(R.layout.activity_recipe);

        this.setTitle(this.recipe.getName());
        this.recipeInstructions = (TextView)findViewById(R.id.recipeInstructions);
        this.recipeInstructions.setText(this.recipe.getInstructions());
    }
}
