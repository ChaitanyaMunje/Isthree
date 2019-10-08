package com.example.hp.isthree;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.String.*;

public class Order extends AppCompatActivity {
    TextView totalamttxt;
    Button bt,confirm;

TextView quantity1,quantitytxt10
        ,quantitytxt2,quantitytxt3,quantitytxt4,quantitytxt5,quantitytxt6,quantitytxt7,quantitytxt8,quantitytxt9;
//1,3,5,7,9,11,13 are fab to decrease order
    //2,4,6,8,10 are to increase order
    int q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;
    double total;
FloatingActionButton fab1,fab2,fab3,fab4,fab5,fab6,fab7,fab8,fab9,fab10,fab11,fab12,fab13,fab14,fab15,
    fab16,fab17,fab18,fab19,fab20;

int i1=0,i2=0,i3=0,i4=0,i5=0,i6=0,i7=0,i8=0,i9=0,i10=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        totalamttxt=(TextView)findViewById(R.id.totlaamttxt);
        confirm=(Button)findViewById(R.id.confirm);
        bt=(Button)findViewById(R.id.btn);
        //to confirm the order
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 q1=Integer.parseInt(quantity1.getText().toString());
                 q2=Integer.parseInt(quantitytxt2.getText().toString());
                 q3= Integer.parseInt(quantitytxt3.getText().toString());
                 q4= Integer.parseInt(quantitytxt4.getText().toString());
                 q5= Integer.parseInt(quantitytxt5.getText().toString());
                 q6= Integer.parseInt(quantitytxt6.getText().toString());
                 q7= Integer.parseInt(quantitytxt7.getText().toString());
                  q8= Integer.parseInt(quantitytxt8.getText().toString());
                  q9= Integer.parseInt(quantitytxt9.getText().toString());
                 q10=Integer.parseInt(quantitytxt10.getText().toString());

                double shirt=5.00;
                final double pant=7.00;
                double suit=15.00;
                double top=5.00;
                double saree=10;
                double salwar=7.00;


                total =  (q1 * shirt)+(q2*shirt)+(q3*pant)+(q4*shirt)+(q5*suit)+(q6*shirt)+(q7*top)+(q8*saree)+(q9*pant)+(q10*saree);
                String amt=String.valueOf(total);
                totalamttxt.setText(amt);
                if(total!=0){
                    confirm.setEnabled(true);
                    confirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(Order.this, "hello", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Order.this,Confirm_Order.class);
                            String tshirt=quantity1.getText().toString();
                            String shirt=quantitytxt2.getText().toString();
                            String pants=quantitytxt3.getText().toString();
                            String shorts=quantitytxt4.getText().toString();
                            String suit=quantitytxt5.getText().toString();
                            String top=quantitytxt6.getText().toString();
                            String skirt=quantitytxt7.getText().toString();
                            String saree=quantitytxt8.getText().toString();
                            String salwar=quantitytxt9.getText().toString();
                            String gown=quantitytxt10.getText().toString();
                            String total=totalamttxt.getText().toString();
                            intent.putExtra("T-Shirt",tshirt);//9//
                            intent.putExtra("Shirt",shirt);//8//
                            intent.putExtra("Pants",pants);//7//
                            intent.putExtra("Shorts",shorts);//6//
                            intent.putExtra("Suit",suit);//5//
                            intent.putExtra("Top",top);//4//
                            intent.putExtra("Skirt",skirt);//3//
                            intent.putExtra("Saree",saree);//2//
                            intent.putExtra("Gown",gown);//1//
                            intent.putExtra("Salwar",salwar);//10//
                            intent.putExtra("Total",total);
                            startActivity(intent);

                        }
                    });



                }else {
                    confirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            confirm.setEnabled(false);
                            Toast.makeText(Order.this, "Please order anything", Toast.LENGTH_SHORT).show();



                        }
                    });
                }
            }
        });




        fab19=(FloatingActionButton)findViewById(R.id.fab19);
        fab20=(FloatingActionButton)findViewById(R.id.fab20);
        fab1=(FloatingActionButton)findViewById(R.id.fab1);
        fab2=(FloatingActionButton)findViewById(R.id.fab2);
        fab3=(FloatingActionButton)findViewById(R.id.fab3);
        fab4=(FloatingActionButton)findViewById(R.id.fab4);
        fab5=(FloatingActionButton)findViewById(R.id.fab5);
        fab6=(FloatingActionButton)findViewById(R.id.fab6);
        fab7=(FloatingActionButton)findViewById(R.id.fab7);
        fab8=(FloatingActionButton)findViewById(R.id.fab8);
        fab9=(FloatingActionButton)findViewById(R.id.fab9);
        fab10=(FloatingActionButton)findViewById(R.id.fab10);
        fab11=(FloatingActionButton)findViewById(R.id.fab11);
        fab12=(FloatingActionButton)findViewById(R.id.fab12);
        fab13=(FloatingActionButton)findViewById(R.id.fab13);
        fab14=(FloatingActionButton)findViewById(R.id.fab14);
        fab15=(FloatingActionButton)findViewById(R.id.fab15);
        fab16=(FloatingActionButton)findViewById(R.id.fab16);
        fab17=(FloatingActionButton)findViewById(R.id.fab17);
        fab18=(FloatingActionButton)findViewById(R.id.fab18);
        quantity1=(TextView)findViewById(R.id.quantity1);
        quantitytxt2=(TextView)findViewById(R.id.quantity2);
        quantitytxt3=(TextView)findViewById(R.id.quantity3);
        quantitytxt4=(TextView)findViewById(R.id.quantity4);
        quantitytxt5=(TextView)findViewById(R.id.quantity5);
        quantitytxt6=(TextView)findViewById(R.id.quantity6);
        quantitytxt7=(TextView)findViewById(R.id.quantity7);
        quantitytxt8=(TextView)findViewById(R.id.quantity8);
        quantitytxt9=(TextView)findViewById(R.id.quantity9);
        quantitytxt10=(TextView)findViewById(R.id.quantity10);
fab20.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       i10++;
       quantitytxt10.setText(Integer.toString(i10));
    }
});
fab19.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (i10>0){
            i10=i10-1;

        }
        else {
            Toast.makeText(Order.this, "less han 1", Toast.LENGTH_SHORT).show();

        }                quantitytxt10.setText(Integer.toString(i10));
    }
});

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i1>0){
                    i1=i1-1;

                }
                else {
                    Toast.makeText(Order.this, "less han 1", Toast.LENGTH_SHORT).show();

                }                quantity1.setText(Integer.toString(i1));
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i2>0){
                    i2=i2-1;

                }
                else {
                    Toast.makeText(Order.this, "less han 1", Toast.LENGTH_SHORT).show();

                }
                quantitytxt2.setText(Integer.toString(i2));
            }
        });
        fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i3>0){
                    i3=i3-1;

                }
                else {
                    Toast.makeText(Order.this, "less han 1", Toast.LENGTH_SHORT).show();

                }                quantitytxt3.setText(Integer.toString(i3));
            }
        });
        fab7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i4>0){
                    i4=i4-1;

                }
                else {
                    Toast.makeText(Order.this, "less han 1", Toast.LENGTH_SHORT).show();

                }                quantitytxt4.setText(Integer.toString(i4));
            }
        });
        fab9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i5>0){
                    i5=i5-1;

                }
                else {
                    Toast.makeText(Order.this, "less han 1", Toast.LENGTH_SHORT).show();

                }                quantitytxt5.setText(Integer.toString(i5));
            }
        });
        fab11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i6>0){
                    i6=i6-1;

                }
                else {
                    Toast.makeText(Order.this, "less han 1", Toast.LENGTH_SHORT).show();

                }                quantitytxt6.setText(Integer.toString(i6));
            }
        });
        fab13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i7>0){
                    i7=i7-1;

                }
                else {
                    Toast.makeText(Order.this, "less han 1", Toast.LENGTH_SHORT).show();

                }                quantitytxt7.setText(Integer.toString(i7));
            }
        });
        fab15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i8>0){
                    i8=i8-1;

                }
                else {
                    Toast.makeText(Order.this, "less han 1", Toast.LENGTH_SHORT).show();

                }                quantitytxt8.setText(Integer.toString(i8));
            }
        });
        fab17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i9>0){
                    i9=i9-1;

                }
                else {
                    Toast.makeText(Order.this, "less han 1", Toast.LENGTH_SHORT).show();

                }                quantitytxt9.setText(Integer.toString(i9));
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i1++;

                quantity1.setText(Integer.toString(i1));
            }
        });
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i2++;

                quantitytxt2.setText(Integer.toString(i2));
            }
        });
        fab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i3++;

                quantitytxt3.setText(Integer.toString(i3));
            }
        });
        fab8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i4++;

                quantitytxt4.setText(Integer.toString(i4));
            }
        });
        fab10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i5++;

                quantitytxt5.setText(Integer.toString(i5));
            }
        });
        fab12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i6++;

                quantitytxt6.setText(Integer.toString(i6));
            }
        });
        fab14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i7++;

                quantitytxt7.setText(Integer.toString(i7));
            }
        });
        fab16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i8++;

                quantitytxt8.setText(Integer.toString(i8));
            }
        });
        fab18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i9++;

                quantitytxt9.setText(Integer.toString(i9));
            }
        });



    }





   /*
*/


}
