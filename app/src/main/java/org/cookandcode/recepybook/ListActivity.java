package org.cookandcode.recepybook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ListActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        this.list = (ListView) findViewById(R.id.recipesList);

        DatabaseReference db = FirebaseDatabase.getInstance().getReference("recipes");

        final ArrayAdapter<Recipe> adapter = new ArrayAdapter<Recipe>(this,
                R.layout.recipe_list_item);
        this.list.setAdapter(adapter);

        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemClicked(position);
            }
        });

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter.clear();
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for(DataSnapshot child : children) {
                    Recipe r = child.getValue(Recipe.class);
                    adapter.add(r);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ListActivity.this, "Fehler beim Laden: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    protected void itemClicked(int position) {
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("recipeIndex", position);
        this.startActivity(i);
    }
}
