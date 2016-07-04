package org.cookandcode.recepybook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RecipeActivity extends AppCompatActivity {

    protected TextView recipeInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        this.recipeInstructions = (TextView)findViewById(R.id.recipeInstructions);

        String recipeKey = this.getIntent().getStringExtra("recipeKey");

        DatabaseReference recipeRef = FirebaseDatabase.getInstance().getReference("recipes").child(recipeKey);

        recipeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Recipe r = dataSnapshot.getValue(Recipe.class);
                showRecipe(r);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showRecipe(Recipe recipe) {
        this.setTitle(recipe.getName());
        this.recipeInstructions.setText(recipe.getInstructions());
    }
}
