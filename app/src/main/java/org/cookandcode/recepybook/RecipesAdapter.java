package org.cookandcode.recepybook;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

public class RecipesAdapter extends FirebaseListAdapter<Recipe> {
    public RecipesAdapter(Activity activity) {
        super(activity, Recipe.class, R.layout.recipe_list_item,
                FirebaseDatabase.getInstance().getReference("recipes"));
    }

    @Override
    protected void populateView(View v, Recipe model, int position) {
        TextView t = (TextView)v;
        t.setText(model.getName());
    }
}
