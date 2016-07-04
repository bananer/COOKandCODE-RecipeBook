package org.cookandcode.recepybook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        final EditText textName = (EditText)findViewById(R.id.textName);
        final EditText textInstructions = (EditText)findViewById(R.id.textInstructions);
        final Button buttonSave = (Button)findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe r = new Recipe(textName.getText().toString(),
                        textInstructions.getText().toString());
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("recipes").push();
                ref.setValue(r);

                finish();
            }
        });
    }
}
