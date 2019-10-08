package com.example.hp.isthree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        final EditText e1 = (EditText)findViewById(R.id.editText1);
        final EditText e2 = (EditText) findViewById(R.id.editText2);
        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/html");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"chaitanyamunje@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback from App");
                i.putExtra(Intent.EXTRA_TEXT, "Name : " + e1.getText() + "\nMessage : " + e2.getText());
                try {
                    startActivity(Intent.createChooser(i, "Please send by using Email"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Feedback.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
