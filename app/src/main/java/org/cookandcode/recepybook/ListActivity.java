package org.cookandcode.recepybook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    ListView list;

    RecipesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        this.list = (ListView) findViewById(R.id.recipesList);
        this.adapter = new RecipesAdapter(this);
        this.list.setAdapter(this.adapter);

        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemClicked(position);
            }
        });

        Button buttonCreate = (Button) findViewById(R.id.buttonCreate);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListActivity.this, CreateActivity.class);
                startActivity(i);
            }
        });
    }

    protected void itemClicked(int position) {
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("recipeKey", adapter.getRef(position).getKey());
        this.startActivity(i);
    }
}
