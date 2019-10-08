package com.example.hp.isthree;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Confirm_Order extends AppCompatActivity {
TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm__order);
         txt1=(TextView)findViewById(R.id.txt);
        txt2=(TextView)findViewById(R.id.txt2);
        txt3=(TextView)findViewById(R.id.txt3);
        txt4=(TextView)findViewById(R.id.txt4);
        txt5=(TextView)findViewById(R.id.txt5);
        txt6=(TextView)findViewById(R.id.txt6);
        txt7=(TextView)findViewById(R.id.txt7);
        txt8=(TextView)findViewById(R.id.txt8);
        txt9=(TextView)findViewById(R.id.txt9);
        txt10=(TextView)findViewById(R.id.txt10);
        txt11=(TextView)findViewById(R.id.txt11);
        Button btn=(Button)findViewById(R.id.orderbtn);
        txt11.setText("Total Amount is : "+getIntent().getStringExtra("Total"));
        txt10.setText("Salwar : "+getIntent().getStringExtra("Salwar"));
        txt1.setText("T-Shirt : "+getIntent().getStringExtra("T-Shirt"));//1//
        txt2.setText("Shirt : "+getIntent().getStringExtra("Shirt"));//2//
        txt3.setText("Pants : "+getIntent().getStringExtra("Pants"));//3//
        txt4.setText("Shorts : "+getIntent().getStringExtra("Shorts"));//4//
        txt5.setText("Suit : "+getIntent().getStringExtra("Suit"));//5//
        txt6.setText("Top : "+getIntent().getStringExtra("Top"));//6//
        txt7.setText("Skirt : "+getIntent().getStringExtra("Skirt"));//7//
        txt8.setText("Saree : "+getIntent().getStringExtra("Saree"));//8//
        txt9.setText("Gown : "+getIntent().getStringExtra("Gown"));//9//
        final String Total=txt11.getText().toString();
        final String salwar=txt10.getText().toString();
        final String tshirt=txt1.getText().toString();
        final String shirt=txt2.getText().toString();
        final String pant=txt3.getText().toString();
        final String shorts=txt4.getText().toString();
        final String suit=txt5.getText().toString();
        final String top=txt6.getText().toString();
        final String skirt=txt7.getText().toString();
        final String saree=txt8.getText().toString();
        final String gown=txt9.getText().toString();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserOrder userOrder=new UserOrder(
Total,salwar,tshirt,shirt,pant,shorts,suit,top,skirt,saree,gown
                );
                FirebaseDatabase.getInstance().getReference("User_Order").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(userOrder).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Confirm_Order.this, "Order Placed Succesfully", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Confirm_Order.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
