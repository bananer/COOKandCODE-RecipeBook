package org.cookandcode.recepybook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        this.list = (ListView) findViewById(R.id.recipesList);

        this.list.setAdapter(new ArrayAdapter<Recipe>(this,
                R.layout.recipe_list_item, Recipes.getRecipes()));


        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            itemClicked(position);
            }
        });
    }

    protected void itemClicked(int position) {
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("recipeIndex", position);
        this.startActivity(i);
    }
}
