package com.himanshu.achats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Admin_Men extends AppCompatActivity {
    EditText brand, price, desc;
    Spinner type;
    Button cancel, submit;
    String typetxt ="", id;
    String brandtxt ="";
    String pricetxt ="";
    String desctxt ="";
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__men);
        getSupportActionBar().setTitle("  MEN");

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("database");

        brand = (EditText) findViewById(R.id.brand);
        price = (EditText) findViewById(R.id.price);
        desc = (EditText) findViewById(R.id.desc);
        type = (Spinner) findViewById(R.id.type);
        cancel = (Button) findViewById(R.id.cancel);
        submit = (Button) findViewById(R.id.submit);

        String[] str = {"","T-shirts","Shirts","Jeans","Jackets","Sweaters","Shorts","Shoes","Flip Flops"};
        ArrayAdapter<String> ad = new ArrayAdapter<String>(Admin_Men.this, android.R.layout.simple_list_item_1, str);
        type.setAdapter(ad);
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typetxt = String.valueOf(type.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brandtxt = brand.getText().toString();
                pricetxt = price.getText().toString();
                desctxt = desc.getText().toString();
                if(brandtxt.equals("") || pricetxt.equals("") ||desctxt.equals("") ||typetxt.equals("")){
                    Toast.makeText(Admin_Men.this, "Fill All Details!", Toast.LENGTH_LONG).show();
                }
                else{
                    id = myRef.push().getKey();
                    Database database = new Database(typetxt, brandtxt, pricetxt, desctxt);
                    myRef.child("men").child(id).setValue(database);
                    Toast.makeText(Admin_Men.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
                    brand.setText("");
                    price.setText("");
                    desc.setText("");
                    type.setSelection(0);

                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Men.this, Admin_Options.class);
                startActivity(intent);
            }
        });
    }
}
