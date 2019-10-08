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

public class ChangeAddress extends AppCompatActivity {
EditText addressedt,landmarkedt,stateedt,pincodeedt,namedt,mobileedt,altmobilenoedt;
Button savebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_address);
        mobileedt=(EditText)findViewById(R.id.mobileedt);
        altmobilenoedt=(EditText)findViewById(R.id.altphnoedt);
        namedt=(EditText)findViewById(R.id.name);
        addressedt=(EditText)findViewById(R.id.address);
        landmarkedt=(EditText)findViewById(R.id.landmark);
        stateedt=(EditText)findViewById(R.id.state);
        pincodeedt=(EditText)findViewById(R.id.pincode);
        savebtn=(Button)findViewById(R.id.savebtn);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=namedt.getText().toString().trim();
                String address=addressedt.getText().toString().trim();
                String landmark=landmarkedt.getText().toString().trim();
                String state=stateedt.getText().toString().trim();
                String pincode=pincodeedt.getText().toString().trim();
                String mobile=mobileedt.getText().toString().trim();
                String altmobileno=altmobilenoedt.getText().toString().trim();
                if (name.isEmpty()){
                    namedt.setError("Please enter name");
                    namedt.requestFocus();
                    return;
                }
                if (address.isEmpty()){
                    addressedt.setError("Please enter Address");
                    addressedt.requestFocus();
                    return;
                }
                if (landmark.isEmpty()){
                    landmarkedt.setError("Please Enter Landmark");
                    landmarkedt.requestFocus();
                    return;
                }
                if (state.isEmpty()){
                    stateedt.setError("Enter State");
                    stateedt.requestFocus();
                    return;
                }
                if (pincode.isEmpty()){
                    pincodeedt.setError("Pincode is missing");
                    pincodeedt.requestFocus();
                    return;
                }
                if (mobile.isEmpty()) {
                    mobileedt.setError("Mobile no is missing");
                    mobileedt.requestFocus();
                    return;


                }
                if (altmobileno.isEmpty()){
                    altmobilenoedt.setError("Alternate Mobile no is missing");
                    altmobilenoedt.requestFocus();
                    return;
                }
                UserAddress userAddress=new UserAddress(

                        name,address,landmark,state,pincode,mobile,altmobileno
                );
                FirebaseDatabase.getInstance().getReference("User_Address").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(userAddress).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ChangeAddress.this, "Updated Succes", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ChangeAddress.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }

        });

    }

}
