package com.example.hp.isthree;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Cancel extends AppCompatActivity {
EditText reason;
Button ca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);
        reason=(EditText)findViewById(R.id.reason);
        ca=(Button)findViewById(R.id.cancel);
        final String reas=reason.getText().toString().trim();

        ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reas.isEmpty()){
                    reason.setError("Please Enter Reason");
                    reason.requestFocus();
                    return;
                }

                FirebaseDatabase.getInstance().getReference("User_Order").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(reas).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                        Toast.makeText(Cancel.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                    else {
                            Toast.makeText(Cancel.this, "FAiled", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }
}
